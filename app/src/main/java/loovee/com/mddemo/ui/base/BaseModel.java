package loovee.com.mddemo.ui.base;

/**
 * Created by loovee on 2017/4/19.
 */

public abstract class BaseModel {

    protected BaseCallBack callBack;

    public void setOnResultCallBack(BaseCallBack callBack) {
        this.callBack = callBack;
    }
}
