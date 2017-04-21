package loovee.com.mddemo.ui.base;

import android.content.Context;

/**
 * Created by loovee on 2017/4/19.
 */

public abstract class BasePresenter<V,M> implements BaseCallBack{

    protected Context mContext;
    protected V mView;
    protected M mModule;

    public void setVM(Context context, V v, M m){
        this.mContext = context;
        this.mView = v;
        this.mModule = m;
    }

    public abstract void initRequest();//一开始需要请求的数据

}
