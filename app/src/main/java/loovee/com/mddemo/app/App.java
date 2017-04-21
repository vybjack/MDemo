package loovee.com.mddemo.app;

import android.app.Application;
import android.content.Context;

import com.loovee.lib.http.LooveeHttp;

/**
 * Created by loovee on 2017/4/21.
 */

public class App extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        LooveeHttp.init(this,true);
    }
}
