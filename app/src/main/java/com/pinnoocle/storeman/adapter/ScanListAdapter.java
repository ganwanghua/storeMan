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
import com.pinnoocle.storeman.bean.ScanBean;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class ScanListAdapter extends RecyclerView.Adapter<ScanListAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<ScanBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public ScanListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_scan, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (mShowItems.get(position).getUser() != null) {
            Glide.with(context).load(mShowItems.get(position).getUser().getAvatarUrl()).into(holder.iv_personal_icon);
            holder.tv_name.setText(mShowItems.get(position).getUser().getNickName());
            holder.tv_commission.setText(mShowItems.get(position).getUser().getPhone());
        }
        holder.tv_time.setText("支付时间：" + mShowItems.get(position).getCreate_time());
        holder.tv_money.setText("¥" + mShowItems.get(position).getMoney());

    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<ScanBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_name, tv_commission, tv_time, tv_money;
        private final ImageView iv_personal_icon;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_personal_icon = (ImageView) itemView.findViewById(R.id.iv_personal_icon);
            tv_commission = (TextView) itemView.findViewById(R.id.tv_commission);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
