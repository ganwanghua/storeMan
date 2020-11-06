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
import com.pinnoocle.storeman.bean.PackageManagerBean;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class PackageManagementAdapter extends RecyclerView.Adapter<PackageManagementAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<PackageManagerBean.DataBeanX.ListBean.DataBean> mShowItems;
    private Context context;

    public PackageManagementAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_package_manager, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).centerCrop().into(holder.iv_picture);
        if (mShowItems.get(position).getGoods_status().getValue() == 10) {
            holder.iv_type.setBackgroundResource(R.drawable.bg_package_manager_one);
            holder.tv_type.setText(mShowItems.get(position).getGoods_status().getText());
        }else {
            holder.iv_type.setBackgroundResource(R.drawable.bg_package_manager);
            holder.tv_type.setText(mShowItems.get(position).getGoods_status().getText());
        }
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        if (mShowItems.get(position).getIs_points_exchange() == 1) {
            if (Double.parseDouble(mShowItems.get(position).getNeed_points_money()) > 0) {
                holder.tv_original_price.setText(mShowItems.get(position).getNeed_points_num() + "+¥" + mShowItems.get(position).getNeed_points_money());
            } else {
                holder.tv_original_price.setText("¥" + mShowItems.get(position).getNeed_points_money());
            }
        } else {
            holder.tv_original_price.setText("¥" + mShowItems.get(position).getGoods_sku().getGoods_price());
            holder.tv_concessional_rate.setText("¥" + mShowItems.get(position).getGoods_sku().getLine_price());
        }
        holder.tv_stock.setText("库存：" + mShowItems.get(position).getGoods_stock() + "  销量：");
        holder.tv_sales_volume.setText(mShowItems.get(position).getSales_actual() + "");
        holder.tv_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, view);
                }
            }
        });
        holder.tv_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<PackageManagerBean.DataBeanX.ListBean.DataBean> list) {
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
        private final TextView tv_type, tv_original_price, tv_concessional_rate, tv_name, tv_stock, tv_sales_volume,
                tv_state, tv_purchase, tv_promotion_plan;
        private final ImageView iv_picture, iv_type;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_picture = (ImageView) itemView.findViewById(R.id.iv_picture);
            iv_type = (ImageView) itemView.findViewById(R.id.iv_type);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            tv_original_price = (TextView) itemView.findViewById(R.id.tv_original_price);
            tv_concessional_rate = (TextView) itemView.findViewById(R.id.tv_concessional_rate);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_stock = (TextView) itemView.findViewById(R.id.tv_stock);
            tv_sales_volume = (TextView) itemView.findViewById(R.id.tv_sales_volume);
            tv_state = (TextView) itemView.findViewById(R.id.tv_state);
            tv_purchase = (TextView) itemView.findViewById(R.id.tv_purchase);
            tv_promotion_plan = (TextView) itemView.findViewById(R.id.tv_promotion_plan);
        }

    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
