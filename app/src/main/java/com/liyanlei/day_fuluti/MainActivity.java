package com.liyanlei.day_fuluti;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liyanlei.day_fuluti.adapter.MyAdapter;
import com.liyanlei.day_fuluti.bean.RootBean;
import com.liyanlei.day_fuluti.fragment.AFragment;
import com.liyanlei.day_fuluti.fragment.BFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());

        myAdapter = new MyAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(myAdapter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setCustomView(R.layout.fma);
        mTab.getTabAt(1).setCustomView(R.layout.fmb);



    }
}
