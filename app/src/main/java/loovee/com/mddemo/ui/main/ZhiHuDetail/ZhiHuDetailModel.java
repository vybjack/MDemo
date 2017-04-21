package loovee.com.mddemo.ui.main.ZhiHuDetail;

import android.util.Log;

import com.loovee.lib.http.LooveeHttp;
import com.loovee.lib.http.LooveeRequestParams;
import com.loovee.lib.http.LooveeResponse;
import com.loovee.lib.http.OnLooveeResponseListener;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuDetailModel extends ZhiHuDetailMVP.Model {

    public static String ZHI_HU_BASE_USL = "http://news-at.zhihu.com/api/4/news/";

    @Override
    public void requestListData(String date) {
        String url = ZHI_HU_BASE_USL + date;
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
