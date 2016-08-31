package com.example.administrator.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.administrator.activity.HomeActivity;
import com.example.administrator.bean.Categories;
import com.example.administrator.bean.LeftMenuTitle;
import com.example.administrator.mynewsapp.R;
import com.example.administrator.pager.BasePage;
import com.example.administrator.pager.GovernPage;
import com.example.administrator.pager.HomePage;
import com.example.administrator.pager.NewsPage;
import com.example.administrator.pager.ServicePage;
import com.example.administrator.pager.SettingPage;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ContentFragment extends Fragment{

    private static final int NEWS_PAGER_NUM = 5;
    ArrayList<BasePage> pages;
    private ViewPager vp_homeActivity_news;
    HomeActivity homeActivity;
    public Categories categories;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeActivity= (HomeActivity) getActivity();
        View inflate = View.inflate(getActivity(), R.layout.contentfragment_layout, null);
        vp_homeActivity_news = (ViewPager) inflate.findViewById(R.id.vp_homeActivity_news);

        RadioGroup rg_homeActivity_select = (RadioGroup) inflate.findViewById(R.id.rg_homeActivity_select);

        vp_homeActivity_news.setAdapter(new MyViewPagerAdapter());
        rg_homeActivity_select.check(R.id.rb_homeActivity_home);

        rg_homeActivity_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){ //点击5个radio button

                    case R.id.rb_homeActivity_home:
                        vp_homeActivity_news.setCurrentItem(0,false);
                        pages.get(0).setSlidingMenu(false);
                        break;
                    case R.id.rb_homeActivity_newsCenter:
                        vp_homeActivity_news.setCurrentItem(1,false);
                        pages.get(1).setSlidingMenu(true);
                        NewsPage newsPage = (NewsPage) pages.get(1);
                        newsPage.getLeftMenuData();
                        break;
                    case R.id.rb_homeActivity_smartService:
                        vp_homeActivity_news.setCurrentItem(2,false);
                        pages.get(2).setSlidingMenu(false);
                        break;
                    case R.id.rb_homeActivity_government:
                        vp_homeActivity_news.setCurrentItem(3,false);
                        pages.get(3).setSlidingMenu(false);
                        break;
                    case R.id.rb_homeActivity_setting:
                        vp_homeActivity_news.setCurrentItem(4,false);
                        pages.get(4).setSlidingMenu(false);
                        break;
                }
            }
        });

        pages=new ArrayList<>();
        pages.add(new HomePage(homeActivity));
        pages.add(new NewsPage(homeActivity));
        pages.add(new GovernPage(homeActivity));
        pages.add(new ServicePage(homeActivity));
        pages.add(new SettingPage(homeActivity));

        return inflate;
    }



    public ArrayList<BasePage> getPages() {
        Log.e("contentfragment","pagesize="+pages.size());
        return pages;
    }





    private class MyViewPagerAdapter extends PagerAdapter{
        @Override
        public int getCount(){
            return NEWS_PAGER_NUM;
        }

        @Override
        public boolean isViewFromObject(View view, Object object){
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){

            View view= pages.get(position).mView;
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }
    }
}
