package loovee.com.mddemo.ui.home;

import loovee.com.mddemo.ui.base.BaseModel;
import loovee.com.mddemo.ui.base.BasePresenter;
import loovee.com.mddemo.ui.base.BaseView;

/**
 * Created by loovee on 2017/4/19.
 */

public interface HomeMVP {

    interface View extends BaseView {
        void showHomeData(String result);

    }

    abstract class Model extends BaseModel{
        abstract void requestHomeData();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void requestHomeData();
    }

}
