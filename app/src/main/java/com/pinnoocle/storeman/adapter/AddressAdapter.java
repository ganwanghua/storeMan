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
import com.pinnoocle.storeman.bean.AddressBean;
import com.pinnoocle.storeman.bean.HomeModel;

import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<AddressBean.DataBean.ListBean> mShowItems;
    private Context context;
    private int pos;

    public AddressAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_address, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mShowItems.get(position).getPhone().length(); i++) {
            char c = mShowItems.get(position).getPhone().charAt(i);
            if (i >= 3 && i <= 6) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        holder.tv_name.setText(mShowItems.get(position).getName() + "    " + sb.toString());
        holder.tv_address.setText(mShowItems.get(position).getRegion().getProvince() + mShowItems.get(position).getRegion().getCity()
                + mShowItems.get(position).getRegion().getRegion() + mShowItems.get(position).getDetail());

        if (pos == position) {
            holder.iv_select.setImageResource(R.mipmap.select);
            holder.tv_select.setText("已设为默认");
            holder.tv_select.setTextColor(0xff333333);
        }else {
            holder.iv_select.setImageResource(R.mipmap.unselect);
            holder.tv_select.setText("设为默认");
            holder.tv_select.setTextColor(0xff888888);
        }
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<AddressBean.DataBean.ListBean> list, int position) {
        mShowItems = list;
        pos = position;
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
        private final TextView tv_name, tv_address, tv_select;
        private final ImageView iv_select;
        private final LinearLayout ll_edit, ll_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_select = (ImageView) itemView.findViewById(R.id.iv_select);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_select = (TextView) itemView.findViewById(R.id.tv_select);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            ll_edit = (LinearLayout) itemView.findViewById(R.id.ll_edit);
            ll_delete = (LinearLayout) itemView.findViewById(R.id.ll_delete);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
