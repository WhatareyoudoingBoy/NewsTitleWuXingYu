package com.bwei.newstitlewuxingyu.frames;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.activity.NewsInfoWeb;
import com.bwei.newstitlewuxingyu.adapter.NetVpAdapter;
import com.bwei.newstitlewuxingyu.bean.NewsBean;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


import java.util.List;

/**
 * 此类中 网络请求数据，并解析 在页面中显示出来
 */

public class Vpframent extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private View view;
    private PullToRefreshListView vp_item_pull;
    private NewsBean newsBean;
    private List<NewsBean.ResultBean.DataBean> dataa;

    public Vpframent() {

    }


    public static Vpframent newInstance(String param1, String param2) {
        Vpframent fragment = new Vpframent();
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
        //加载布局
        view = inflater.inflate(R.layout.fragment_vp_frament, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //PullToRefreshExpandableListView控件加载

        vp_item_pull = (PullToRefreshListView) view.findViewById(R.id.vp_item_pull);
        getNewsInfo(mParam1);


        vp_item_pull.setMode(PullToRefreshBase.Mode.BOTH);
        vp_item_pull.setScrollingWhileRefreshingEnabled(true);

        vp_item_pull.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), NewsInfoWeb.class);
                intent.putExtra("url", dataa.get(i - 1).getUrl());
                startActivity(intent);
            }
        });


        vp_item_pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //设置下拉时显示的日期和时间
                String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // 更新显示的label
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                dataa.clear();
                getNewsInfo(mParam1);
                vp_item_pull.onRefreshComplete();

            }
        });


        vp_item_pull.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                Toast.makeText(getActivity(), "已经是最后一个了", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // XUtils3.0 请求 新闻头条 数据
    public void getNewsInfo(String type) {

        try {
            String key = "&key=1d0359e69946f7edbbc3b74a3c6d7e57";
            String url = "http://v.juhe.cn/toutiao/index?type=" + type + key;
            x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {


                @Override
                public void onSuccess(String result) {

                    Gson gson = new Gson();//解析数据
                    newsBean = gson.fromJson(result, NewsBean.class);


                    if (newsBean.getError_code() == 0) {  //返回码为0 返回成功，解析数据
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
