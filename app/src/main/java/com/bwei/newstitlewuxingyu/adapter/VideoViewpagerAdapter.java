package com.bwei.newstitlewuxingyu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bwei.newstitlewuxingyu.frames.VideoVpframent;

import java.util.List;

/**
 * 创建人 武星宇
 * 创建时间 2017/2/22.
 */

public class VideoViewpagerAdapter extends FragmentPagerAdapter {
    String[] fragmentList;

    public VideoViewpagerAdapter(FragmentManager fm, String[] fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return VideoVpframent.newInstance(fragmentList[position],null);
    }

    @Override
    public int getCount() {
        return fragmentList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList[position];
    }
}
