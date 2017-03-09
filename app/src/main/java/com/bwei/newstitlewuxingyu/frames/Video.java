package com.bwei.newstitlewuxingyu.frames;



import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.adapter.VideoViewpagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class Video extends Fragment {
    
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    
    private String mParam1;
    private String mParam2;
     private View view;
     private TabLayout video_tabtitle;
     private ViewPager video_viewpager;
    private String[] video_Title = {"推荐","音乐","搞笑","社会","小品","生活","影视","娱乐","呆萌","游戏","原创"};
    private VideoViewpagerAdapter vvpAdapter;
    private List<Fragment> fragmentList;

    public Video() {
       
    }

   
    public static Video newInstance(String param1, String param2) {
        Video fragment = new Video();
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
        view = inflater.inflate(R.layout.fragment_video, container, false);
        return view;
    }

     @Override
     public void onActivityCreated(@Nullable Bundle savedInstanceState) {
         super.onActivityCreated(savedInstanceState);


         inintView(); //优化控件
         addTabtitle(); //Tablayout 添加 标题
         setPagerdapter(); //适配器
         addFramentList();


     }

     //优化控件
     private void inintView(){
         video_tabtitle = (TabLayout) view.findViewById(R.id.video_tabtitle);
         video_viewpager = (ViewPager) view.findViewById(R.id.video_viewpager);
     }

     //Tablayout 添加 标题
     private void addTabtitle(){

         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[0]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[1]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[2]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[3]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[4]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[5]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[6]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[7]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[8]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[9]));
         video_tabtitle.addTab(video_tabtitle.newTab().setText(video_Title[10]));
         video_tabtitle.setupWithViewPager(video_viewpager);
         video_tabtitle.setTabMode(TabLayout.MODE_SCROLLABLE);
     }

    //适配器
     private  void setPagerdapter(){
         vvpAdapter = new VideoViewpagerAdapter(getActivity().getSupportFragmentManager(),video_Title);
         video_viewpager.setAdapter(vvpAdapter);

     }

    //添加与标题数量同等的 ViewPager 中Frament的展示内容

    private void addFramentList(){
        fragmentList = new ArrayList<>();
        for (int i = 0; i <video_Title.length; i++){

            VideoVpframent vvf = new VideoVpframent();
            fragmentList.add(vvf);
        }

    }
 }
