package com.example.administrator.detailPage;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.bean.Categories;
import com.example.administrator.bean.NewsDetail;
import com.example.administrator.mynewsapp.R;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class NewsMenuDetailPager {

    public View mNewsDetailView;
    Activity homeActivity;
    private View inflate;
    Categories.childrenInfo childrenInfo;
    NewsDetail newsDetail;
    private ListView lv_newsMenu_detailPager;
    public  static final String URL_START="http://10.0.2.2:8080/zhbj";

    BitmapUtils bitmapUtils;
    private ViewPager vp_newsMenuDetail_pager;
    private View inflate2;


    //------------------------------------------------------------------

    public NewsMenuDetailPager(Activity homeActivity,Categories.childrenInfo childrenInfo){


        bitmapUtils=new BitmapUtils(homeActivity);
        this.childrenInfo=childrenInfo;
        this.homeActivity=homeActivity;
        initView();
        initData();
    }
    //------------------------------------------------------------------
    private void initView() {

        inflate = View.inflate(homeActivity, R.layout.newsmenu_detailpager_layout, null);//使用的xml文件
        inflate2 = View.inflate(homeActivity, R.layout.item_listview_newsdetail_head, null);
        lv_newsMenu_detailPager = (ListView) inflate.findViewById(R.id.lv_newsMenu_detailPager);

        vp_newsMenuDetail_pager = (ViewPager) inflate2.findViewById(R.id.vp_newsMenuDetail_pager);



    }

    private void initData() {
        String url = childrenInfo.url;
        getNewsDetailData(url);


        mNewsDetailView= inflate;
    }


    public void getNewsDetailData(String url_news) {

        String url=URL_START+url_news;
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                String result=responseInfo.result;

                parseJSON(result);
            }
            @Override
            public void onFailure(HttpException e, String s) {
                Log.e("newsmenudetail","onFailure");

            }
        });

    }

    public void parseJSON(String result){

        Gson gson=new Gson();
        newsDetail = gson.fromJson(result, NewsDetail.class);

        lv_newsMenu_detailPager.setAdapter(new MyAdapter());
        lv_newsMenu_detailPager.addHeaderView(inflate2);
        vp_newsMenuDetail_pager.setAdapter(new MyPageAdapter());

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {

            return newsDetail.getData().getNews().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View inflate = View.inflate(homeActivity, R.layout.item_listview_newsdetail, null);
            ImageView iv_listviewnewsdetail_img = (ImageView) inflate
                                    .findViewById(R.id.iv_listviewnewsdetail_img);
            TextView tv_listviewnewsdetail_title = (TextView) inflate
                                    .findViewById(R.id.tv_listviewnewsdetail_title);
            TextView tv_listviewnewsdetail_pubtime = (TextView) inflate
                                    .findViewById(R.id.tv_listviewnewsdetail_pubtime);

            String sr=newsDetail.data.getNews().get(position).getListimage();
            tv_listviewnewsdetail_title.setText(newsDetail.data.getNews().get(position).getTitle());
            tv_listviewnewsdetail_pubtime.setText(newsDetail.data.getNews().get(position).getPubdate());
            bitmapUtils.display(iv_listviewnewsdetail_img,sr);



            return inflate;
        }
    }

    private class MyPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return newsDetail.getData().getTopnews().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            //super.destroyItem(container, position, object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            String topImage = newsDetail.getData().getTopnews().get(position).getTopimage();

            ImageView imageView = new ImageView(homeActivity);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            bitmapUtils.display(imageView,topImage);

            container.addView(imageView);
            return imageView;//super.instantiateItem(container, position);
        }
    }
}
