package com.example.administrator.pager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.activity.HomeActivity;
import com.example.administrator.mynewsapp.R;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public abstract class BasePage {

    public View mView;
    protected TextView tv_pagerContent_news;
    protected ImageButton ib_pagerContent_newsMenuLeft;
    protected LinearLayout ll_homeActivity_forContent;
    protected ImageButton ib_pagerContent_newsMenuRight;
    public Activity mactivity;


    public BasePage(Activity  activity){
        this.mactivity=activity;
        mView=View.inflate(activity, R.layout.pager_contentfrag,null);
        initView();
        initData();



    }

    public void setSlidingMenu(boolean b) {
        HomeActivity homeActivity = (HomeActivity) mactivity;
        homeActivity.setSlidingMenuAble(b);
    }

    protected abstract void initData();




    protected void initView() {
        tv_pagerContent_news = (TextView) mView.findViewById(R.id.tv_pagerContent_news);
        ib_pagerContent_newsMenuLeft = (ImageButton) mView.findViewById(R.id.ib_pagerContent_newsMenuLeft);
        ll_homeActivity_forContent = (LinearLayout) mView.findViewById(R.id.ll_HomeActivity_forContent);
        ib_pagerContent_newsMenuRight = (ImageButton) mView.findViewById(R.id.ib_pagerContent_newsMenuRight);


    }


}
