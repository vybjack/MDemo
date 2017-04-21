package loovee.com.mddemo.util;

import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import loovee.com.mddemo.app.App;

/**
 * 加载图片
 */
public class ImageUtil {

    public static String url = "http://www.2cto.com/uploadfile/Collfiles/20140615/20140615094106112.jpg";

    private static Context mContext = App.mContext;

    /**
     * 加载普通图片
     * @param v ImageView对象
     * @param url 网络或本地地址
     */
    public static void loadImg(Context context, ImageView v, String url) {
        try{
            if(!isUiThread()) return;
            Glide.with(mContext)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(v);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 加载普通图片
     * @param v ImageView对象
     * @param resourceId 本地资源id
     */
    public static void loadImg(Context context, ImageView v, Integer resourceId) {
        try{
            if(!isUiThread()) return;
            Glide.with(mContext)
                    .load(resourceId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(v);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 先加载缩略图，再加载全图
     * @param context
     * @param v
     * @param url
     */
    public static void loadThumbImg(Context context, ImageView v, String url){
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(v);
    }



    /**
     * 是否是ui线程
     * @return
     */
    public static boolean isUiThread(){
        return Looper.myLooper() == Looper.getMainLooper();
    }



}
