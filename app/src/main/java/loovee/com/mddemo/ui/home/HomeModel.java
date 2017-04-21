package loovee.com.mddemo.ui.home;

import com.loovee.lib.http.LooveeHttp;
import com.loovee.lib.http.LooveeResponse;
import com.loovee.lib.http.OnLooveeResponseListener;

/**
 * Created by loovee on 2017/4/19.
 */

public class HomeModel extends HomeMVP.Model {

    @Override
    public void requestHomeData() {

        LooveeHttp.createHttp().get(null, String.class, new OnLooveeResponseListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSucceed(LooveeResponse response) {

            }

            @Override
            public void onFailed(Exception exception, int responseCode) {

            }

            @Override
            public void onFinish() {

            }
        });

        String result = "there is data hahahhaahhahahhah";
        if(callBack != null){
            callBack.onResult(result,0);
        }

    }

}
