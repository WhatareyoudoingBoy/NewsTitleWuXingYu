package com.bwei.newstitlewuxingyu.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.bean.VideoBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 创建人 武星宇
 * 创建时间 2017/2/22.
 */

public class VideoListViewAdpater extends BaseAdapter {
    Context supportFragmentManager;
    List<VideoBean.V9LG4B3A0Bean> beanList;
    private JCVideoPlayerStandard videoplayer;
    private TextView video_source;
    public VideoListViewAdpater(Context supportFragmentManager, List<VideoBean.V9LG4B3A0Bean> beanList) {
        this.supportFragmentManager = supportFragmentManager;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = View.inflate(supportFragmentManager, R.layout.video_lv_item,null);

        }
        videoplayer = (JCVideoPlayerStandard) view.findViewById(R.id.videoplayer);
        video_source = (TextView) view.findViewById(R.id.video_source);

        videoplayer.setUp(beanList.get(i).getMp4Hd_url()
                            , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, beanList.get(i).getTitle());

        video_source.setText(beanList.get(i).getTopicName());

//        videoplayer.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        return view;
    }
}
