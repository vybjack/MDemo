package loovee.com.mddemo.ui.main.wangyi;

import loovee.com.mddemo.entity.WangYiEntity;
import loovee.com.mddemo.ui.base.BaseModel;
import loovee.com.mddemo.ui.base.BasePresenter;
import loovee.com.mddemo.ui.base.BaseView;

/**
 * Created by loovee on 2017/4/20.
 */

public interface WangYiMVP {

    interface View extends BaseView{
        void showListData(WangYiEntity entity);
    }

    abstract class Model extends BaseModel{
        //请求网络列表数据
        abstract void requestListData(String date);
    }

    abstract class Presenter extends BasePresenter<View,Model>{

        //通知 model 请求列表数据
        public abstract void askModelRequestListData(String date);

    }
}
