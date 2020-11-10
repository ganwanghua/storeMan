package com.pinnoocle.storeman.adapter;


import android.content.Context;
import android.text.TextUtils;
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

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class PurchaseRecordsAdapter extends RecyclerView.Adapter<PurchaseRecordsAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<OrderBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public PurchaseRecordsAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_purchase_records, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getUser().getAvatarUrl()).centerCrop().into(holder.iv_personal_icon);
        if (!TextUtils.isEmpty(mShowItems.get(position).getUser().getPhone()) && mShowItems.get(position).getUser().getPhone().length() > 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mShowItems.get(position).getUser().getPhone().length(); i++) {
                char c = mShowItems.get(position).getUser().getPhone().charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            holder.tv_name.setText(mShowItems.get(position).getUser().getNickName() + "    " + sb.toString());
        }
        holder.tv_money.setText(mShowItems.get(position).getGoods().get(0).getGoods_price());
        holder.tv_num.setText("" + mShowItems.get(position).getGoods().get(0).getTotal_num());
        holder.tv_time.setText(mShowItems.get(position).getCreate_time());
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<OrderBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_name, tv_money, tv_num, tv_time;
        private final ImageView iv_personal_icon;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_personal_icon = (ImageView) itemView.findViewById(R.id.iv_personal_icon);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
