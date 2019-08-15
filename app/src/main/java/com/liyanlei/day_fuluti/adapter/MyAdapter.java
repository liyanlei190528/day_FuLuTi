package com.liyanlei.day_fuluti.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public MyAdapter(final FragmentManager fm) {
        super(fm);
    }

    public MyAdapter(final FragmentManager supportFragmentManager, final ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(final int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
