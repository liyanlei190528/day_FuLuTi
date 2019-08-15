package com.liyanlei.day_fuluti.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liyanlei.day_fuluti.R;
import com.liyanlei.day_fuluti.adapter.Fragment_Adapter_B;
import com.liyanlei.day_fuluti.adapter.Fragment_Adapter_BB;
import com.liyanlei.day_fuluti.adapter.Fragment_Adapter_BBB;
import com.liyanlei.day_fuluti.bean.FuLiBean;
import com.liyanlei.day_fuluti.bean.RootBean;
import com.liyanlei.day_fuluti.model.MyModelImpl2;
import com.liyanlei.day_fuluti.presenter.MyPresenterImpl2;
import com.liyanlei.day_fuluti.view.MyView2;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements MyView2 {


    private View view;
    private Banner mRv;
    private RecyclerView mRv2;
    private RecyclerView mRv3;
    private ArrayList<FuLiBean.ResultsBean> list;
    private Fragment_Adapter_B fragment_adapter_b;
    private Fragment_Adapter_BB fragment_adapter_bb;
    private Fragment_Adapter_BBB fragment_adapter_bbb;
    private MyPresenterImpl2 myPresenterImpl2;
    private int page = 1;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {

        myPresenterImpl2 = new MyPresenterImpl2(new MyModelImpl2(), this);
        myPresenterImpl2.getDate(page);
    }

    private void initView(View inflate) {
        mRv = (Banner) inflate.findViewById(R.id.rv);
        mRv2 = (RecyclerView) inflate.findViewById(R.id.rv2);
        mRv3 = (RecyclerView) inflate.findViewById(R.id.rv3);


        list = new ArrayList<>();

       /* fragment_adapter_b = new Fragment_Adapter_B(getActivity(), list);
        mRv.setAdapter(fragment_adapter_b);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));*/

        fragment_adapter_bb = new Fragment_Adapter_BB(getActivity(), list);
        mRv2.setAdapter(fragment_adapter_bb);
        mRv2.setLayoutManager(new LinearLayoutManager(getActivity()));

        fragment_adapter_bbb = new Fragment_Adapter_BBB(getActivity(), list);
        mRv3.setAdapter(fragment_adapter_bbb);
        mRv3.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    @Override
    public void onSuccrss(final FuLiBean fuLiBean) {
        list.addAll(fuLiBean.getResults());

        fragment_adapter_bb.notifyDataSetChanged();
        fragment_adapter_bbb.notifyDataSetChanged();
        mRv.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(final Context context, final Object path, final ImageView imageView) {
                        FuLiBean.ResultsBean datasBean = (FuLiBean.ResultsBean) path;
                        Glide.with(getActivity())
                                .load(datasBean.getUrl())
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageView);
                    }
                }).start();


    }

    @Override
    public void Field(final String msg) {

    }
}
