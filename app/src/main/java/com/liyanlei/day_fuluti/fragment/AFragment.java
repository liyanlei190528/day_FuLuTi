package com.liyanlei.day_fuluti.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liyanlei.day_fuluti.R;
import com.liyanlei.day_fuluti.adapter.MyFragmentAdapter_A;
import com.liyanlei.day_fuluti.adapter.MyFragmentAdapter_aa;
import com.liyanlei.day_fuluti.bean.RootBean;
import com.liyanlei.day_fuluti.model.MyModelImpl;
import com.liyanlei.day_fuluti.presenter.MyPresenterImpl;
import com.liyanlei.day_fuluti.view.MyView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MyView {


    private View view;
    private Banner mRv;
    private ArrayList<RootBean.DataBean.DatasBean> list;
    private TabLayout mTab;
    /**
     * 今日推荐
     */
    private TextView mTv;
    private RecyclerView mRv2;
    private MyFragmentAdapter_A myFragmentAdapter_a;
    private MyFragmentAdapter_aa myFragmentAdapter_aa;
    private int page = 1;
    private MyPresenterImpl myPresenter;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        myPresenter = new MyPresenterImpl(new MyModelImpl(), this);
        myPresenter.getDate(page);

    }

    private void initView(View inflate) {
        mRv = (Banner) inflate.findViewById(R.id.rv);
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mTv = (TextView) inflate.findViewById(R.id.tv);
        mRv2 = (RecyclerView) inflate.findViewById(R.id.rv2);


        mTab.addTab(mTab.newTab().setText("最新").setIcon(R.mipmap.story_icon_new));
        mTab.addTab(mTab.newTab().setText("叫早").setIcon(R.mipmap.story_icon_morning));
        mTab.addTab(mTab.newTab().setText("哄睡").setIcon(R.mipmap.story_icon_sleep ));
        mTab.addTab(mTab.newTab().setText("全部").setIcon(R.mipmap. story_icon_classify));

        list = new ArrayList<>();
      /*  myFragmentAdapter_a = new MyFragmentAdapter_A(getActivity(), list);
        mRv.setAdapter(myFragmentAdapter_a);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));*/

        myFragmentAdapter_aa = new MyFragmentAdapter_aa(getActivity(), list);
        mRv2.setAdapter(myFragmentAdapter_aa);
        mRv2.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }


    @Override
    public void onSuccrss(final RootBean rootBean) {
        list.addAll(rootBean.getData().getDatas());


        myFragmentAdapter_aa.notifyDataSetChanged();
        mRv.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(final Context context, final Object path, final ImageView imageView) {
                        RootBean.DataBean.DatasBean datasBean = (RootBean.DataBean.DatasBean) path;
                        Glide.with(getActivity())
                                .load(datasBean.getEnvelopePic())
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageView);
                    }
                }).start();
    }

    @Override
    public void Field(final String msg) {

    }
}
