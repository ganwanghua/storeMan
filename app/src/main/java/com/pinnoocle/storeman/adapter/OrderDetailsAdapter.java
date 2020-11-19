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
import com.pinnoocle.storeman.bean.OrderDetailBean;
import com.pinnoocle.storeman.bean.PackageManagerBean;

import java.util.List;

import ch.ielse.view.SwitchView;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<OrderDetailBean.DataBean.DetailBean.GoodsBean> mShowItems;
    private Context context;
    private int nums;

    public OrderDetailsAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_order_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        if (nums > 0) {
            if (Double.parseDouble(mShowItems.get(position).getExchange_points_money()) > 0) {
                holder.tv_money.setText(mShowItems.get(position).getExchange_points_num() + "积分+¥" + mShowItems.get(position).getExchange_points_money());
            } else {
                holder.tv_money.setText(mShowItems.get(position).getExchange_points_num() + "积分");
            }
        } else {
            holder.tv_money.setText("¥" + mShowItems.get(position).getGoods_price());
        }
        holder.tv_num.setText("X" + mShowItems.get(position).getTotal_num());
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<OrderDetailBean.DataBean.DetailBean.GoodsBean> list, int num) {
        mShowItems = list;
        nums = num;
        notifyDataSetChanged();
    }

    //**************************************************************

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_num, tv_money, tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
        }
    }

    public Object getItem(int position) {
        return mShowItems.get(position);
    }

}
