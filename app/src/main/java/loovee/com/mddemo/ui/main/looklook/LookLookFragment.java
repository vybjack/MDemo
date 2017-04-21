package loovee.com.mddemo.ui.main.looklook;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import loovee.com.mddemo.R;
import loovee.com.mddemo.entity.LookLookEntity;
import loovee.com.mddemo.ui.base.BaseFragment;

/**
 * Created by loovee on 2017/4/20.
 */

public class LookLookFragment extends BaseFragment<LookLookPresenter, LookLookModel> implements LookLookMVP.View {

    @Bind(R.id.zhi_hu_rv)
    RecyclerView recycleView;

    protected LookLookAdapter mAdapter;
    protected int index = 0;

    @Override
    protected void initView() {
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new LookLookAdapter(getActivity());
        recycleView.setAdapter(mAdapter);
        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        int lastVisiblePos = manager.findLastVisibleItemPosition();
                        if(lastVisiblePos >= mAdapter.getItemCount() - 3){
                            index += 1;
                            mPresenter.askModelRequestListData(String.valueOf(index));
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_zhi_hu;
    }

    @Override
    public void showListData(LookLookEntity entity) {
        if(entity != null){
            mAdapter.addList(entity.getResults());
        }
    }

}
