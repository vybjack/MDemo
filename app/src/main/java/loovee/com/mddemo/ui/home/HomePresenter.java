package loovee.com.mddemo.ui.home;

/**
 * Created by loovee on 2017/4/19.
 */

public class HomePresenter extends HomeMVP.Presenter {


    @Override
    public void initRequest() {
        requestHomeData();
    }


    @Override
    public void requestHomeData() {
        mModule.requestHomeData();
    }

    @Override
    public void onResult(String result, int code) {
        mView.showHomeData(result);
    }
}
