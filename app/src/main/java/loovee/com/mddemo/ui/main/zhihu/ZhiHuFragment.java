package loovee.com.mddemo.ui.main.zhihu;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.Bind;
import loovee.com.mddemo.R;
import loovee.com.mddemo.entity.ZhiHuEntity;
import loovee.com.mddemo.ui.base.BaseFragment;
import loovee.com.mddemo.ui.main.ZhiHuDetail.ZhiHuDetailActivity;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuFragment extends BaseFragment<ZhiHuPresenter, ZhiHuModel> implements ZhiHuMVP.View {

    @Bind(R.id.zhi_hu_rv)
    RecyclerView recycleView;

    protected ZhiHuAdapter mAdapter;
    protected String date;

    @Override
    protected void initView() {
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ZhiHuAdapter(getActivity());
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
                            mPresenter.askModelRequestListData(date,false);
                        }
                        break;
                }
            }
        });
        mAdapter.setOnItemClickListener(new ZhiHuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ZhiHuEntity.StoriesBean bean = mAdapter.getObject(position);
                String id = null;
                if(bean != null){
                    id = String.valueOf(bean.getId());
                }
                Intent intent = new Intent(getActivity(), ZhiHuDetailActivity.class);
                intent.putExtra(ZhiHuDetailActivity.ID,id);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(0,0);
            }
        });
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_zhi_hu;
    }

    @Override
    public void showListData(ZhiHuEntity entity) {
        if(entity != null){
            mAdapter.addList(entity.getStories());
            date = entity.getDate();
        }
    }

}
