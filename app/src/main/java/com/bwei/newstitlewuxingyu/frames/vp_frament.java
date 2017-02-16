package com.bwei.newstitlewuxingyu.frames;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.adapter.NetVpAdapter;
import com.bwei.newstitlewuxingyu.bean.NewsBean;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * 此类中 网络请求数据，并解析 在页面中显示出来
 *
 */

public class vp_frament extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private View view;
    private PullToRefreshListView vp_item_pull;


    public vp_frament() {

    }


    public static vp_frament newInstance(String param1, String param2) {
        vp_frament fragment = new vp_frament();
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

        view = inflater.inflate(R.layout.fragment_vp_frament, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //PullToRefreshExpandableListView控件加载

        vp_item_pull = (PullToRefreshListView) view.findViewById(R.id.vp_item_pull);
        getNewsInfo(mParam1);

    }


            // XUtils3.0 请求 新闻头条 数据
    public  void getNewsInfo(String type){

        try {
        String key = "&key=1d0359e69946f7edbbc3b74a3c6d7e57";
            String   url = "http://v.juhe.cn/toutiao/index?type="+type+key;
            x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {

                private NewsBean newsBean;
                private List<NewsBean.ResultBean.DataBean> dataa;
                 @Override
                public void onSuccess(String result) {

                    Gson gson = new Gson();
                    newsBean = gson.fromJson(result, NewsBean.class);


                    if(newsBean.getError_code() == 0) {
                        dataa = newsBean.getResult().getData();

                        if (dataa != null) {

                            NetVpAdapter adapter = new NetVpAdapter(getActivity(), dataa);

                            adapter.notifyDataSetChanged();
                            adapter.AddData(dataa);

                            vp_item_pull.setAdapter(adapter);

                        }
                    }

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
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
