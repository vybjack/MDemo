package loovee.com.mddemo.ui.main.ZhiHuDetail;

import com.google.gson.Gson;

import loovee.com.mddemo.entity.ZhiHuDetailEntity;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuDetailPresenter extends ZhiHuDetailMVP.Presenter {

    @Override
    public void askModelRequestListData(String date) {
        mModule.requestListData(date);
    }

    @Override
    public void initRequest() {
    }

    @Override
    public void onResult(String result, int code) {
        ZhiHuDetailEntity entity = new Gson().fromJson(result,ZhiHuDetailEntity.class);
        mView.showListData(entity);
    }
}
