package loovee.com.mddemo.ui.main.zhihu;

import android.util.Log;

import com.loovee.lib.http.LooveeHttp;
import com.loovee.lib.http.LooveeRequestParams;
import com.loovee.lib.http.LooveeResponse;
import com.loovee.lib.http.OnLooveeResponseListener;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuModel extends ZhiHuMVP.Model {

    public static String ZHI_HU_BASE_USL = "http://news-at.zhihu.com/api/4/news/";

    @Override
    public void requestListData(String date, boolean isFirst) {
        String url;
        if(isFirst){
            url = ZHI_HU_BASE_USL + date;
        }else {
            url = ZHI_HU_BASE_USL + "before/" + date;
        }
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
