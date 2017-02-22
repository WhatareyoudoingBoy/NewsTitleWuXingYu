package com.bwei.newstitlewuxingyu.frames;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.adapter.VideoListViewAdpater;
import com.bwei.newstitlewuxingyu.bean.VideoBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class VideoVpframent extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private View view;

    private VideoBean videoBean;
    private List<VideoBean.V9LG4B3A0Bean> beanList;
    private ListView video_listview;


    public VideoVpframent() {

    }


    public static VideoVpframent newInstance(String param1, String param2) {
        VideoVpframent fragment = new VideoVpframent();
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

        view = inflater.inflate(R.layout.video_vpframent, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        videoHttp();



    }


    //优化控件
    public void initView(){

        video_listview = (ListView) view.findViewById(R.id.video_listview);
    }
    
    //网络请求-- 视频类
    private void videoHttp(){
        String url = "http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html";
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson  gson = new Gson();
                videoBean = gson.fromJson(result, VideoBean.class);
                beanList = videoBean.getV9LG4B3A0();


//

                VideoListViewAdpater vlv = new VideoListViewAdpater(getContext(),beanList);

               video_listview.setAdapter(vlv);





            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
