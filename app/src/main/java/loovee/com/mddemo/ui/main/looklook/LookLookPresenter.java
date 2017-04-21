package loovee.com.mddemo.ui.main.looklook;

import com.google.gson.Gson;

import loovee.com.mddemo.entity.LookLookEntity;

/**
 * Created by loovee on 2017/4/20.
 */

public class LookLookPresenter extends LookLookMVP.Presenter {

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
        LookLookEntity entity = new Gson().fromJson(result,LookLookEntity.class);
        mView.showListData(entity);
    }
}
