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
import com.pinnoocle.storeman.bean.HomeModel;
import com.pinnoocle.storeman.bean.MyMoneyBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<HomeModel.DataBean.ClassBean> mShowItems;
    private Context context;

    public ClassAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_class, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).into(holder.iv_class);
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        holder.tv_content.setText(mShowItems.get(position).getSelling_point());

        holder.ll_class.setOnClickListener(new View.OnClickListener() {
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

    public void setData(List<HomeModel.DataBean.ClassBean> list) {
        mShowItems = list;
        notifyDataSetChanged();
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
        private final TextView tv_name, tv_content;
        private final ImageView iv_class;
        private final LinearLayout ll_class;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_class = (ImageView) itemView.findViewById(R.id.iv_class);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            ll_class = (LinearLayout) itemView.findViewById(R.id.ll_class);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
