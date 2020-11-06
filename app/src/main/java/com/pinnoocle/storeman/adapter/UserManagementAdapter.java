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
import com.pinnoocle.storeman.bean.UserManagerBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class UserManagementAdapter extends RecyclerView.Adapter<UserManagementAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<UserManagerBean.DataBeanX.UserBean.DataBean> mShowItems;
    private Context context;

    public UserManagementAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_user_manager, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getAvatarUrl()).centerCrop().into(holder.iv_personal_icon);
        holder.tv_name.setText(mShowItems.get(position).getNickName()+"    "+mShowItems.get(position).getPhone());

        Date date = new Date(Long.parseLong(String.valueOf(mShowItems.get(position).getCreate_time())) * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        holder.tv_time.setText("注册时间："+format.format(date));

        holder.tv_money.setText(mShowItems.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<UserManagerBean.DataBeanX.UserBean.DataBean> list) {
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
        private final TextView tv_name, tv_money, tv_time;
        private final CircleImageView iv_personal_icon;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_personal_icon = (CircleImageView) itemView.findViewById(R.id.iv_personal_icon);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


    public Object getItem(int position) {
        return mShowItems.get(position);
    }


}
