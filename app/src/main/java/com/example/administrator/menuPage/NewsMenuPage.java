package com.example.administrator.menuPage;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.activity.HomeActivity;
import com.example.administrator.bean.Categories;
import com.example.administrator.detailPage.NewsMenuDetailPager;
import com.example.administrator.mynewsapp.R;
import com.viewpagerindicator.TabPageIndicator;

import java.util.List;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class NewsMenuPage extends BaseMenuPage{


    private List<Categories.childrenInfo> children;
    private NewsMenuDetailPager newsMenuDetailPager;

    public NewsMenuPage(Activity activity, Categories.MenuDataInfo menuDataInfo) {
        super(activity, menuDataInfo);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected View initView() {




        children = menuDataInfo.getChildren();
        View inflate = View.inflate(homeActivity, R.layout.newsmenupage_layout, null);//这个类的xml

        ViewPager vp_newsMenuPage_home = (ViewPager) inflate.findViewById(R.id.vp_newsMenuPage_home);
        vp_newsMenuPage_home.setAdapter(new MyAdapter());

        TabPageIndicator indicator_newsMenuPage_title = (TabPageIndicator) inflate.findViewById(R.id.indicator_newsMenuPage_title);
        indicator_newsMenuPage_title.setViewPager(vp_newsMenuPage_home);



        vp_newsMenuPage_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position!=0){
                    homeActivity.setSlidingMenuAble(false);
                    Log.e("newsmenu","False");
                }else {
                    homeActivity.setSlidingMenuAble(true);
                    Log.e("newsmenu","true");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return inflate;
    }



    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return children.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {



                newsMenuDetailPager = new NewsMenuDetailPager(homeActivity, menuDataInfo.children.get(position));
                View detailView = newsMenuDetailPager.mNewsDetailView;
                container.addView(detailView);
                return detailView;//super.instantiateItem(container, position);

        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);//super.destroyItem(container, position, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return children.get(position).title;
        }
    }
}
