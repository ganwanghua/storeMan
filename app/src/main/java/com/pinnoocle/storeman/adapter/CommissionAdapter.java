package com.pinnoocle.storeman.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.CommissionBean;
import com.pinnoocle.storeman.bean.MyMoneyBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class CommissionAdapter extends RecyclerView.Adapter<CommissionAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<CommissionBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public CommissionAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_my_money, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getAvatarUrl()).centerCrop().into(holder.iv_personal_icon);
        holder.tv_name.setText(mShowItems.get(position).getNickName());
        holder.tv_commission.setText("¥" + mShowItems.get(position).getMoney());
        holder.tv_time.setText(mShowItems.get(position).getCreate_time());
        holder.tv_money.setText(mShowItems.get(position).getRemark());
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<CommissionBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_name, tv_money, tv_time, tv_commission;
        private final CircleImageView iv_personal_icon;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_personal_icon = (CircleImageView) itemView.findViewById(R.id.iv_personal_icon);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_commission = (TextView) itemView.findViewById(R.id.tv_commission);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
