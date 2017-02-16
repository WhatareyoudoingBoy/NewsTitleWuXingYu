package com.bwei.newstitlewuxingyu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.newstitlewuxingyu.R;
import com.bwei.newstitlewuxingyu.bean.NewsBean;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 布局设计，
 * 此类中 有ListView Item的多条目展示
 */

public class NetVpAdapter extends BaseAdapter {
   private  Context context;
   private List<NewsBean.ResultBean.DataBean> dataBeen;
   private List<NewsBean.ResultBean.DataBean> data = new ArrayList<>();
    private final int TYPE_1 = 0;
    private final int TYPE_2 = 1;


    public NetVpAdapter (Context context, List<NewsBean.ResultBean.DataBean> dataBeen){
        this.context = context ;
        this.dataBeen = dataBeen ;
    }

    /**
     * 多条目展示必须调用的方法
     * getViewTypeCount()
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    /**
     * 多条目展示必须调用的方法
     * getItemViewType
     *
     */
    @Override
    public int getItemViewType(int position) {

        if(position % 2 == 0){
            return TYPE_1; // 偶数 出现的应该是三个图？
        }else {
            return TYPE_2; // 基数  出现的应该是1个图？
        }



    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public NewsBean.ResultBean.DataBean getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        int type = getItemViewType(position);  //获取多条目的 类型

        ViewHolder viewHolder ;

        ImageOptions imageOptions = new ImageOptions.Builder().build();//Xutils3.0 图片框架的调用，
        if(view == null){
            viewHolder = new ViewHolder();
            switch (type){
                case TYPE_1:
                    view = view.inflate(context, R.layout.home_vp_item_adapter, null);//加载布局

                    //找控件
                    viewHolder.title = (TextView) view.findViewById(R.id.home_vp_item_adapter_title);
                    viewHolder.laiyuan = (TextView) view.findViewById(R.id.home_vp_item_adapter_laiyuan);
                    viewHolder.shijian = (TextView) view.findViewById(R.id.home_vp_item_adapter_shijian);
                    viewHolder.imageView_1 = (ImageView) view.findViewById(R.id.home_vp_item_adapter_image_1);
                    viewHolder.imageView_2 = (ImageView) view.findViewById(R.id.home_vp_item_adapter_image_2);
                    viewHolder.imageView_3 = (ImageView) view.findViewById(R.id.home_vp_item_adapter_image_3);

                    //赋值
                    viewHolder.title.setText(getItem(position).getTitle());
                    viewHolder.laiyuan.setText(getItem(position).getAuthor_name());
                    viewHolder.shijian.setText(getItem(position).getDate());
                    x.image().bind(viewHolder.imageView_1, getItem(position).getThumbnail_pic_s(), imageOptions);
                    x.image().bind(viewHolder.imageView_2, getItem(position).getThumbnail_pic_s02(), imageOptions);
                    x.image().bind(viewHolder.imageView_3, getItem(position).getThumbnail_pic_s03(), imageOptions);

                    /**
                     * ViewHolder 优化设置 Tag
                     */
                    view.setTag(viewHolder);
                    break;
                case TYPE_2:
                    view = view.inflate(context, R.layout.type_2_item, null);

                    viewHolder.imageView2 = (ImageView) view.findViewById(R.id.type_2_iv);
                    viewHolder.laiyuan2 = (TextView) view.findViewById(R.id.type_2_laiyuan);
                    viewHolder.shijian2 = (TextView) view.findViewById(R.id.type_2_shijian);
                    viewHolder.title2 = (TextView) view.findViewById(R.id.type_2_title);

                    viewHolder.title2.setText(getItem(position).getTitle());
                    viewHolder.laiyuan2.setText(getItem(position).getAuthor_name());
                    viewHolder.shijian2.setText(getItem(position).getDate());
                    x.image().bind(viewHolder.imageView2, getItem(position).getThumbnail_pic_s(), imageOptions);

                    view.setTag(viewHolder);
                    break;

            }
        }else{
            viewHolder = (ViewHolder) view.getTag();

            //根据多条目的类型进行赋值
            switch(type){
                case TYPE_1:
                    viewHolder.title.setText(getItem(position).getTitle());
                    viewHolder.laiyuan.setText(getItem(position).getAuthor_name());
                    viewHolder.shijian.setText(getItem(position).getDate());
                    x.image().bind(viewHolder.imageView_1, getItem(position).getThumbnail_pic_s(), imageOptions);
                    x.image().bind(viewHolder.imageView_2, getItem(position).getThumbnail_pic_s02(), imageOptions);
                    x.image().bind(viewHolder.imageView_3, getItem(position).getThumbnail_pic_s03(), imageOptions);
                    break;
                case TYPE_2:
                    viewHolder.title2.setText(getItem(position).getTitle());
                viewHolder.laiyuan2.setText(getItem(position).getAuthor_name());
                viewHolder.shijian2.setText(getItem(position).getDate());
                x.image().bind(viewHolder.imageView2, getItem(position).getThumbnail_pic_s(), imageOptions);
                    break;
            }
        }
                    return view;



    }

    //自定义的方法。为了确保携带的数据不为空。
    public void AddData(List<NewsBean.ResultBean.DataBean> datas){

         if(data.size()==0){
             data.addAll(datas);
         }
    }


    //ViewHolder 优化
    private class ViewHolder{
        TextView title;
        TextView laiyuan;
        TextView shijian;
        ImageView imageView_1;
        ImageView imageView_2;
        ImageView imageView_3;
        ImageView imageView2;
        TextView title2;
        TextView laiyuan2;
        TextView shijian2;

    }

}
