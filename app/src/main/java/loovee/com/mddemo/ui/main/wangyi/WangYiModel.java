package loovee.com.mddemo.ui.main.wangyi;

import android.util.Log;

import com.loovee.lib.http.LooveeHttp;
import com.loovee.lib.http.LooveeRequestParams;
import com.loovee.lib.http.LooveeResponse;
import com.loovee.lib.http.OnLooveeResponseListener;

/**
 * Created by loovee on 2017/4/20.
 */

public class WangYiModel extends WangYiMVP.Model {

    public static String WANG_YI_BASE_USL = "http://c.m.163.com/nc/article/headline/T1348647909107/";
    public static String WANG_YI_URL_END = "-20.html";

    /**
     * ("http://c.m.163.com/nc/article/{id}/full.html")
    **/

    @Override
    public void requestListData(String date) {
        String url = WANG_YI_BASE_USL + date + WANG_YI_URL_END;
        LooveeRequestParams params = new LooveeRequestParams(url);
        LooveeHttp.createHttp().get(params, String.class, new OnLooveeResponseListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSucceed(LooveeResponse response) {
                if(callBack != null){
                    String result = (String) response.get();
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
