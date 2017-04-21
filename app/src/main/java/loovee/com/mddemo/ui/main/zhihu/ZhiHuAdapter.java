package loovee.com.mddemo.ui.main.zhihu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import loovee.com.mddemo.R;
import loovee.com.mddemo.entity.ZhiHuEntity;
import loovee.com.mddemo.ui.base.ViewHolder;
import loovee.com.mddemo.util.ImageUtil;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<ZhiHuEntity.StoriesBean> data;
    private Context mContext;
    private OnItemClickListener listener;

    public ZhiHuAdapter(Context context) {
        data = new ArrayList<>();
        this.mContext = context;
    }

    public void resetList(List<ZhiHuEntity.StoriesBean> data){
        if(data != null && data.size() > 0){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addList(List<ZhiHuEntity.StoriesBean> data){
        if(data != null && data.size() > 0){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public ZhiHuEntity.StoriesBean getObject(int position){
        if(position < data.size()){
            return data.get(position);
        }
        return null;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.NewInstance(mContext,null,parent,R.layout.view_zhi_hu_item);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String picUrl;
        List<String> urls = data.get(position).getImages();
        if(urls != null && urls.size() > 0){
            picUrl = urls.get(0);
        }else {
            picUrl = ImageUtil.url;
        }
        holder.setNetImage(mContext,R.id.zhi_hu_pic,picUrl);
        holder.setText(R.id.zhi_hu_title,data.get(position).getTitle());

        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(v,position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }


}
