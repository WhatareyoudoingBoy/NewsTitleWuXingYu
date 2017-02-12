package com.bwei.newstitlewuxingyu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.bwei.newstitlewuxingyu.frames.Home;
import com.bwei.newstitlewuxingyu.frames.vp_frament;

import java.util.List;

/**
 * Created by hp on 2017/2/12.
 */

public class HomeVpAdapter extends FragmentPagerAdapter {

    private final String[] tabtitle = {"推荐","本地","社会","军事","体育","游戏","生活","科技"};
    private List<Fragment> list;
    private Home context;
    private String[] title;
   

    public HomeVpAdapter(FragmentManager fm, Home context, String[] title) {
        super(fm);
        this.context = context;
        this.title = title;
        
    }
    public void setList(List<Fragment> list) {
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return vp_frament.newInstance(title[position],tabtitle[position]);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitle[position];
    }
}
