package loovee.com.mddemo.ui.main.wangyi;

import com.google.gson.Gson;

import loovee.com.mddemo.entity.WangYiEntity;

/**
 * Created by loovee on 2017/4/20.
 */

public class WangYiPresenter extends WangYiMVP.Presenter {

    @Override
    public void askModelRequestListData(String date) {
        mModule.requestListData(date);
    }

    @Override
    public void initRequest() {
        askModelRequestListData("0");
    }

    @Override
    public void onResult(String result, int code) {
        WangYiEntity entity = new Gson().fromJson(result,WangYiEntity.class);
        mView.showListData(entity);
    }
}
