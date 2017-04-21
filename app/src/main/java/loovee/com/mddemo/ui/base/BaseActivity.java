package loovee.com.mddemo.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    protected P mPresenter;
    protected M mModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        ButterKnife.bind(this);
        mPresenter = InstanceUtil.getInstance(this,0);
        mModule = InstanceUtil.getInstance(this,1);
        if(this instanceof BaseView){
            if(mModule != null){
                mModule.setOnResultCallBack(mPresenter);
            }
            if(mPresenter != null){
                mPresenter.setVM(this,this,mModule);
                mPresenter.initRequest();
            }
        }
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public abstract int setContentView();
    public abstract void initData();

}
