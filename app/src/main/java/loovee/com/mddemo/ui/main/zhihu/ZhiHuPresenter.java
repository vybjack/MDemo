package loovee.com.mddemo.ui.main.zhihu;

import com.google.gson.Gson;

import loovee.com.mddemo.entity.ZhiHuEntity;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuPresenter extends ZhiHuMVP.Presenter {

    @Override
    public void askModelRequestListData(String date, boolean isFirst) {
        mModule.requestListData(date,isFirst);
    }

    @Override
    public void initRequest() {
        askModelRequestListData("latest",true);
    }

    @Override
    public void onResult(String result, int code) {
        ZhiHuEntity entity = new Gson().fromJson(result,ZhiHuEntity.class);
        mView.showListData(entity);
    }
}
