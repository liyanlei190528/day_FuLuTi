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
import com.liyanlei.day_fuluti.bean.FuLiBean;

import java.util.ArrayList;

public class Fragment_Adapter_BB extends RecyclerView.Adapter<Fragment_Adapter_BB.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<FuLiBean.ResultsBean> list;

    public Fragment_Adapter_BB(final FragmentActivity activity, final ArrayList<FuLiBean.ResultsBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = View.inflate(activity,R.layout.layout_item2,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        FuLiBean.ResultsBean resultsBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.title.setText(resultsBean.getType());
        Glide.with(activity)
                .load(resultsBean.getUrl())
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
