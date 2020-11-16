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
import com.pinnoocle.storeman.bean.MyClassBean;
import com.pinnoocle.storeman.bean.OrderBean;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class TravelCodeOrderAdapter extends RecyclerView.Adapter<TravelCodeOrderAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<MyClassBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public TravelCodeOrderAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods().get(0).getImage().getFile_path()).centerCrop().into(holder.iv_shop);
        holder.tv_order.setText(mShowItems.get(position).getOrder_no());
        holder.tv_status.setText(mShowItems.get(position).getState_text());
        holder.tv_title.setText(mShowItems.get(position).getGoods().get(0).getGoods_name());

        if (mShowItems.get(position).getPoints_exchange_num() > 0) {
            if (Double.parseDouble(mShowItems.get(position).getGoods().get(0).getExchange_points_money()) > 0) {
                holder.tv_money.setText(mShowItems.get(position).getGoods().get(0).getExchange_points_num() + "积分+¥" + mShowItems.get(position).getGoods().get(0).getExchange_points_money());
            } else {
                holder.tv_money.setText(mShowItems.get(position).getGoods().get(0).getExchange_points_num() + "积分");
            }
        } else {
            holder.tv_money.setText("¥" + mShowItems.get(position).getGoods().get(0).getGoods_price());
        }
        holder.tv_num.setText("x" + mShowItems.get(position).getGoods().get(0).getTotal_num());
        holder.tv_all_money.setText("共:" + mShowItems.get(position).getGoods().get(0).getTotal_price() + "元");
        holder.tv_time.setText("支付时间：" + mShowItems.get(position).getCreate_time());

        if (mShowItems.get(position).getState_text().equals("待付款")) {
            holder.tv_pay.setVisibility(View.VISIBLE);
            holder.tv_logistics.setVisibility(View.GONE);
            holder.tv_receipt_confirmation.setVisibility(View.GONE);
            holder.tv_evaluate.setVisibility(View.GONE);
        } else if (mShowItems.get(position).getState_text().equals("已付款，待发货")) {
            holder.tv_pay.setVisibility(View.GONE);
            holder.tv_logistics.setVisibility(View.VISIBLE);
            holder.tv_receipt_confirmation.setVisibility(View.GONE);
            holder.tv_evaluate.setVisibility(View.GONE);
        } else if (mShowItems.get(position).getState_text().equals("已发货，待收货")) {
            holder.tv_pay.setVisibility(View.GONE);
            holder.tv_logistics.setVisibility(View.VISIBLE);
            holder.tv_receipt_confirmation.setVisibility(View.VISIBLE);
            holder.tv_evaluate.setVisibility(View.GONE);
        } else if (mShowItems.get(position).getState_text().equals("已取消")) {
            holder.tv_pay.setVisibility(View.GONE);
            holder.tv_logistics.setVisibility(View.GONE);
            holder.tv_receipt_confirmation.setVisibility(View.GONE);
            holder.tv_evaluate.setVisibility(View.GONE);
        } else if (mShowItems.get(position).getState_text().equals("已完成")) {
            holder.tv_pay.setVisibility(View.GONE);
            holder.tv_logistics.setVisibility(View.GONE);
            holder.tv_receipt_confirmation.setVisibility(View.GONE);
            holder.tv_evaluate.setVisibility(View.VISIBLE);
        }
        holder.ll_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, v);
                }
            }
        });
        holder.tv_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, v);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<MyClassBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_order, tv_status, tv_title, tv_money, tv_all_money, tv_num, tv_time,
                tv_pay, tv_logistics, tv_receipt_confirmation, tv_evaluate;
        private final ImageView iv_shop;
        private final LinearLayout ll_order;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_shop = (ImageView) itemView.findViewById(R.id.iv_shop);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_order = (TextView) itemView.findViewById(R.id.tv_order);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
            tv_all_money = (TextView) itemView.findViewById(R.id.tv_all_money);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_pay = (TextView) itemView.findViewById(R.id.tv_pay);
            tv_logistics = (TextView) itemView.findViewById(R.id.tv_logistics);
            tv_receipt_confirmation = (TextView) itemView.findViewById(R.id.tv_receipt_confirmation);
            tv_evaluate = (TextView) itemView.findViewById(R.id.tv_evaluate);
            ll_order = (LinearLayout) itemView.findViewById(R.id.ll_order);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
