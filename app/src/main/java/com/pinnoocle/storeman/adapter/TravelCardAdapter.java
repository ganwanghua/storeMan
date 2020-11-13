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

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class TravelCardAdapter extends RecyclerView.Adapter<TravelCardAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<ClassListBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public TravelCardAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_travel_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).into(holder.iv_class);
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        holder.tv_money.setText("¥" + mShowItems.get(position).getGoods_sku().getGoods_price());
        holder.tv_sales_volume.setText("销量:" + mShowItems.get(position).getGoods_sales());

        holder.rl_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, v);
                }
            }
        });
        holder.tv_rush_purchase.setOnClickListener(new View.OnClickListener() {
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

    public void setData(List<ClassListBean.DataBeanX.ListBean.DataBean> list) {
        mShowItems = list;
        notifyDataSetChanged();
    }


    //**********************itemClick************************
    public interface OnItemClickListener {
        void onItemClick(int position,View v);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    //**************************************************************

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name, tv_rush_purchase,tv_money,tv_sales_volume;
        private final ImageView iv_class;
        private final LinearLayout rl_class;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_class = (ImageView) itemView.findViewById(R.id.iv_class);
            tv_rush_purchase = (TextView) itemView.findViewById(R.id.tv_rush_purchase);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_sales_volume = (TextView) itemView.findViewById(R.id.tv_sales_volume);
            rl_class = (LinearLayout) itemView.findViewById(R.id.rl_class);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
