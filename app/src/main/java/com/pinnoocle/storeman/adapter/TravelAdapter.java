package com.pinnoocle.storeman.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.HomeModel;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<HomeModel.DataBean.TravelBean> mShowItems;
    private Context context;

    public TravelAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_travel, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).centerCrop().into(holder.iv_class);
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        holder.tv_money.setText("¥" + mShowItems.get(position).getGoods_sku().getGoods_price());
        holder.tv_sales_volume.setText("销量:" + mShowItems.get(position).getGoods_sku().getStock_num());
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<HomeModel.DataBean.TravelBean> list) {
        mShowItems = list;
        notifyDataSetChanged();
    }


    //**********************itemClick************************
    public interface OnItemClickListener {
        void onItemClick(int position, View v);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    //**************************************************************

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name, tv_money, tv_sales_volume, tv_rush_purchase;
        private final ImageView iv_class;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_class = (ImageView) itemView.findViewById(R.id.iv_class);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_sales_volume = (TextView) itemView.findViewById(R.id.tv_sales_volume);
            tv_rush_purchase = (TextView) itemView.findViewById(R.id.tv_rush_purchase);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
