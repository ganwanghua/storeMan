package com.pinnoocle.storeman.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.ClassListBean;
import com.pinnoocle.storeman.bean.OrderBean;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<ClassListBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public ClassListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_class_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).centerCrop().into(holder.iv_class);
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        holder.tv_content.setText(mShowItems.get(position).getSelling_point());
        holder.tv_money.setText("¥" + mShowItems.get(position).getGoods_sku().getGoods_price());
        holder.tv_sales_volume.setText("销量:" + mShowItems.get(position).getGoods_sku().getStock_num());

        holder.rl_class.setOnClickListener(new View.OnClickListener() {
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

    public void setData(List<ClassListBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_name, tv_content,tv_money,tv_sales_volume;
        private final ImageView iv_class;
        private final RelativeLayout rl_class;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_class = (ImageView) itemView.findViewById(R.id.iv_class);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_sales_volume = (TextView) itemView.findViewById(R.id.tv_sales_volume);
            rl_class = (RelativeLayout) itemView.findViewById(R.id.rl_class);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
