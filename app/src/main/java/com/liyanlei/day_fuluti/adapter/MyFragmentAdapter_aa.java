package com.liyanlei.day_fuluti.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liyanlei.day_fuluti.R;
import com.liyanlei.day_fuluti.bean.RootBean;

import java.util.ArrayList;

public class MyFragmentAdapter_aa extends RecyclerView.Adapter<MyFragmentAdapter_aa.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<RootBean.DataBean.DatasBean> list;

    public MyFragmentAdapter_aa(final FragmentActivity activity, final ArrayList<RootBean.DataBean.DatasBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = View.inflate(activity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        RootBean.DataBean.DatasBean bean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.title.setText(bean.getTitle());
        Glide.with(activity)
                .load(bean.getEnvelopePic())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
