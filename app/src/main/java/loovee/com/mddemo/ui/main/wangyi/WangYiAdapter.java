package loovee.com.mddemo.ui.main.wangyi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import loovee.com.mddemo.R;
import loovee.com.mddemo.entity.WangYiEntity;
import loovee.com.mddemo.ui.base.ViewHolder;

/**
 * Created by loovee on 2017/4/20.
 */

public class WangYiAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<WangYiEntity.T1348647909107Bean> data;
    private Context mContext;

    public WangYiAdapter(Context context) {
        data = new ArrayList<>();
        this.mContext = context;
    }

    public void resetList(List<WangYiEntity.T1348647909107Bean> data){
        if(data != null && data.size() > 0){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addList(List<WangYiEntity.T1348647909107Bean> data){
        if(data != null && data.size() > 0){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.NewInstance(mContext,null,parent,R.layout.view_zhi_hu_item);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setNetImage(mContext,R.id.zhi_hu_pic,data.get(position).getImgsrc());
        holder.setText(R.id.zhi_hu_title,data.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


}
