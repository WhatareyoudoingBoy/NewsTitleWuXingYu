package com.bwei.newstitlewuxingyu.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.bwei.newstitlewuxingyu.frames.Home;
import com.bwei.newstitlewuxingyu.frames.Vpframent;

import java.util.List;


/**
 * 将Frament添加到 ViewPager的Adapter中。
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
        return Vpframent.newInstance(title[position],null);
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
