package com.bwei.newstitlewuxingyu.frames;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.newstitlewuxingyu.adapter.HomeVpAdapter;
import com.bwei.newstitlewuxingyu.R;


import java.util.ArrayList;
import java.util.List;

/**
 *    Home 主页的布局设计 及 数据导入
 *
 */

public class Home extends Fragment {
   
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

   
    private String mParam1;
    private String mParam2;
    private View view;
    private TabLayout home_tablayout;
    private ViewPager home_viewpager;
    private final String[] Tabtitle = {"推荐","本地","社会","军事","体育","游戏","生活","科技"};
    private List<Fragment> list;

    public Home() {
        
    }

   
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return view=inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //不布局中的控件
        home_tablayout = (TabLayout) view.findViewById(R.id.home_tablayout);
        home_viewpager = (ViewPager) view.findViewById(R.id.home_viewpager);


        initList();//根据TabLayout布局中的Title 数量的多少 添加Frament


        // ViewPager Adapter
        HomeVpAdapter adapter = new HomeVpAdapter(getActivity().getSupportFragmentManager(),this,Tabtitle);
        adapter.setList(list);
        home_viewpager.setAdapter(adapter);


        //根据Tabtitle数组的索引，将值写入到 TabLayout中，
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[0]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[1]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[2]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[3]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[4]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[5]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[6]));
        home_tablayout.addTab(home_tablayout.newTab().setText(Tabtitle[7]));
        home_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置TabLayout可以滑动
        home_tablayout.setupWithViewPager(home_viewpager);//关联ViewPager
        
        
    }
    
    void initList(){
        list = new ArrayList<>();
        for (int i=0;i<Tabtitle.length;i++){

             //Vpframent 布局中设置数据 及 布局
            Vpframent frament = new Vpframent();
            list.add(frament);

        }
    }
    
   
    
    
}
