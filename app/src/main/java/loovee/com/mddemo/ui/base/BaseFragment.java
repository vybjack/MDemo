package loovee.com.mddemo.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {

    protected boolean mIsVisibleToUser = false;//是否为可见状态
    protected boolean isInit = false;//是否已经初始化
    protected P mPresenter;
    protected M mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(setContentView(), container, false);
        ButterKnife.bind(this,view);
        initView();
//        Log.e("onCreateView",getClass().getName() + "/onCreateView");
        return view;
    }

    protected abstract void initView();

    /**
     * 此方法运行在 onCreate方法之前
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.e("setUserVisibleHint",getClass().getName() + "/setUserVisibleHint/" + getUserVisibleHint());
        if(this instanceof BaseView){
            if(mPresenter == null){
                mPresenter = InstanceUtil.getInstance(this,0);
                if(mModel == null){
                    mModel = InstanceUtil.getInstance(this,1);
                    mModel.setOnResultCallBack(mPresenter);
                }
                mPresenter.setVM(getActivity(),this,mModel);
            }

        }
        //利用懒加载模式
        mIsVisibleToUser = getUserVisibleHint();
        if(mIsVisibleToUser){
            if(mPresenter != null){
                if(!isInit){
                    isInit = true;
                    mPresenter.initRequest();
                }
            }
        }

    }

    protected abstract int setContentView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        isInit = false;
    }
}
