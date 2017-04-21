package loovee.com.mddemo.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import loovee.com.mddemo.util.ImageUtil;

public class ViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private int mLayoutId;  
    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, View itemView) {
        super(itemView);  
        mViews = new SparseArray<>();
        this.mContext = context;  
        this.mConvertView = itemView;  
        this.mConvertView.setTag(this);  
    }  
  
    public static ViewHolder NewInstance(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {  
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            ViewHolder holder = new ViewHolder(context, itemView);
            holder.mLayoutId = layoutId;  
            return holder;  
        } else {  
            ViewHolder holder = (ViewHolder) convertView.getTag();
            return holder;  
        }  
    }  
  
    public View getConvertView() {
        return mConvertView;  
  
    }  
    public int getLayoutId(){  
        return mLayoutId;  
    }

    /**  
     * 通过id寻找到控件  
     * @param viewId  
     * @param <T>  
     * @return  
     */  
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {  
            view = mConvertView.findViewById(viewId);  
            mViews.put(viewId, view);  
        }  
        return (T) view;  
    }  
  
    /**  
     * 给text赋值  
     * @param viewId  
     * @param text  
     */  
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);  
        return this;  
    }

    /**
     * 给text赋值
     * @param viewId 控件id
     * @param resId 字符id
     */
    public ViewHolder setText(int viewId, int resId) {
        TextView tv = getView(viewId);
        tv.setText(resId);
        return this;
    }

    /**
     * 给text赋值
     * @param viewId
     * @param text
     */
    public ViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置文本颜色
     * @param viewId
     * @param color
     */
    public ViewHolder setTextColor(int viewId, int color) {
        TextView tv = getView(viewId);
        tv.setTextColor(color);
        return this;
    }

    /**
     * 给text赋值
     * @param viewId 控件id
     * @param localUrl 本地图片地址
     */
    public ViewHolder setLocalImage(int viewId, String localUrl) {
        ImageView image = getView(viewId);
        Bitmap bitmap = BitmapFactory.decodeFile(localUrl);
        image.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 给text赋值
     * @param viewId 控件id
     * @param resId 本地资源图片
     */
    public ViewHolder setResImage(int viewId, int resId) {
        ImageView image = getView(viewId);
        image.setImageResource(resId);
        return this;
    }

    /**
     * 加载网络图片
     * @param context
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setNetImage(Context context,int viewId, String url) {
        ImageView image = getView(viewId);
        ImageUtil.loadImg(context,image,url);
        return this;
    }

}