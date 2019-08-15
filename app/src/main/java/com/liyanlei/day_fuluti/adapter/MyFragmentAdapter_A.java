package com.liyanlei.day_fuluti.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liyanlei.day_fuluti.R;
import com.liyanlei.day_fuluti.bean.RootBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MyFragmentAdapter_A extends RecyclerView.Adapter<MyFragmentAdapter_A.ViewHolder> {

    private final FragmentActivity activity;
    private final ArrayList<RootBean.DataBean.DatasBean> list;

    public MyFragmentAdapter_A(final FragmentActivity activity, final ArrayList<RootBean.DataBean.DatasBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = View.inflate(activity,R.layout.layout_mybanner,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        RootBean.DataBean.DatasBean datasBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.ban.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(final Context context, final Object path, final ImageView imageView) {
                        RootBean.DataBean.DatasBean bean = (RootBean.DataBean.DatasBean) path;
                        Glide.with(activity).load(bean.getEnvelopePic()).placeholder(R.mipmap.ic_launcher).into(imageView);
                    }
                }).start();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Banner ban;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.ban);
        }
    }
}
