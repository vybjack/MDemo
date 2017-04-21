package loovee.com.mddemo.ui.main.looklook;

import android.util.Log;

import com.loovee.lib.http.LooveeHttp;
import com.loovee.lib.http.LooveeRequestParams;
import com.loovee.lib.http.LooveeResponse;
import com.loovee.lib.http.OnLooveeResponseListener;

/**
 * Created by loovee on 2017/4/20.
 */

public class LookLookModel extends LookLookMVP.Model {

    public static String Look_Look_BASE_USL = "http://gank.io/api/data/福利/10/";

    /**"/api/data/福利/10/{page}

     /day/{year}/{month}/{day}

     /api/data/休息视频/10/{page}"*/

    @Override
    public void requestListData(String date) {
        String url = Look_Look_BASE_USL + date;
        LooveeRequestParams params = new LooveeRequestParams(url);
        LooveeHttp.createHttp().get(params, String.class, new OnLooveeResponseListener<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSucceed(LooveeResponse<String> response) {
                if(callBack != null){
                    String result = response.get();
                    callBack.onResult(result,1000);
                    Log.e("数据列表：",result);
                }
            }

            @Override
            public void onFailed(Exception exception, int responseCode) {

            }

            @Override
            public void onFinish() {

            }
        });
    }

}
