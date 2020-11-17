package com.pinnoocle.storeman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pinnoocle.storeman.R;
import com.pinnoocle.storeman.bean.TraceBean;

import java.util.ArrayList;
import java.util.List;

public class TraceListAdapter extends BaseAdapter {
    private Context context;
    private List<TraceBean.DataBean.ExpressBean.ListBean> traceList = new ArrayList<>();
    private static final int TYPE_TOP = 0x0000;
    private static final int TYPE_NORMAL = 0x0001;

    public TraceListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TraceBean.DataBean.ExpressBean.ListBean> traceList) {
        this.traceList = traceList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return traceList.size();
    }

    @Override
    public TraceBean.DataBean.ExpressBean.ListBean getItem(int position) {
        return traceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_trace, parent, false);
            holder.tvAcceptTime = (TextView) convertView.findViewById(R.id.tvAcceptTime);
            holder.tvAcceptStation = (TextView) convertView.findViewById(R.id.tvAcceptStation);
            holder.tvTopLine = (TextView) convertView.findViewById(R.id.tvTopLine);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
            holder.tvDot = (TextView) convertView.findViewById(R.id.tvDot);
            convertView.setTag(holder);
        }
        if (getItemViewType(position) == TYPE_TOP) {
            // 第一行头的竖线不显示
            holder.tvTopLine.setVisibility(View.INVISIBLE);
            // 字体颜色加深
            holder.tvStatus.setTextColor(0xff111111);
            holder.tvAcceptTime.setTextColor(0xff111111);
            holder.tvAcceptStation.setTextColor(0xff888888);
            holder.tvDot.setBackgroundResource(R.drawable.timelline_dot_first);
        } else if (getItemViewType(position) == TYPE_NORMAL) {
            holder.tvTopLine.setVisibility(View.VISIBLE);
            holder.tvStatus.setTextColor(0xffA5A5A5);
            holder.tvAcceptTime.setTextColor(0xffA5A5A5);
            holder.tvAcceptStation.setTextColor(0xffA5A5A5);
            holder.tvDot.setBackgroundResource(R.drawable.timelline_dot_normal);
        }

        holder.tvStatus.setText(traceList.get(position).getStatus());
        holder.tvAcceptTime.setText(traceList.get(position).getContext());
        holder.tvAcceptStation.setText(traceList.get(position).getTime());
        return convertView;
    }

    @Override
    public int getItemViewType(int id) {
        if (id == 0) {
            return TYPE_TOP;
        }
        return TYPE_NORMAL;
    }

    static class ViewHolder {
        public TextView tvAcceptTime, tvAcceptStation;
        public TextView tvTopLine, tvDot,tvStatus;
    }
}