package com.pinnoocle.storeman.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.bean.HomeModel;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class CourseCatalogueAdapter extends RecyclerView.Adapter<CourseCatalogueAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<ClassDetailBean.DataBean.VideoListBean> mShowItems;
    private Context context;

    public CourseCatalogueAdapter(Context context, List<ClassDetailBean.DataBean.VideoListBean> videoList) {
        this.context = context;
        this.mShowItems = videoList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_course_catalogue, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_name.setText(mShowItems.get(position).getTitle());
        if(mShowItems.get(position).getFree() == 1){
            holder.iv_play.setImageResource(R.mipmap.play);
        }else {
            holder.iv_play.setImageResource(R.mipmap.locking);
        }

        holder.iv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    //**********************itemClick************************
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    //**************************************************************

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final ImageView iv_play;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_play = (ImageView) itemView.findViewById(R.id.iv_play);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
