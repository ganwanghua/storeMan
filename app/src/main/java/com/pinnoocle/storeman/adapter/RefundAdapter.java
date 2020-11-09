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
import com.pinnoocle.storeman.bean.OrderBean;
import com.pinnoocle.storeman.bean.RefundBean;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class RefundAdapter extends RecyclerView.Adapter<RefundAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<RefundBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public RefundAdapter(Context context) {
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
        Glide.with(context).load(mShowItems.get(position).getOrder_goods().getImage().getFile_path()).centerCrop().into(holder.iv_shop);
        holder.tv_order.setText("订单编号：" + mShowItems.get(position).getOrder_no());
        holder.tv_title.setText(mShowItems.get(position).getOrder_goods().getGoods_name());
        holder.tv_money.setText("¥" + mShowItems.get(position).getOrder_goods().getGoods_price());
        holder.tv_num.setText("x" + mShowItems.get(position).getOrder_goods().getTotal_num());
        holder.tv_all_money.setText("共:" + mShowItems.get(position).getOrder_goods().getTotal_price() + "元");
        holder.tv_time.setText("支付时间：" + mShowItems.get(position).getOrder_goods().getCreate_time());
        holder.ll_operation.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<RefundBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_order, tv_status, tv_title, tv_money, tv_all_money, tv_num, tv_time, tv_pay, tv_logistics, tv_receipt_confirmation, tv_evaluate;
        private final ImageView iv_shop;
        private LinearLayout ll_operation;

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
            tv_logistics = (TextView) itemView.findViewById(R.id.tv_logistics);
            tv_pay = (TextView) itemView.findViewById(R.id.tv_pay);
            tv_receipt_confirmation = (TextView) itemView.findViewById(R.id.tv_receipt_confirmation);
            tv_evaluate = (TextView) itemView.findViewById(R.id.tv_evaluate);
            ll_operation = (LinearLayout) itemView.findViewById(R.id.ll_operation);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
