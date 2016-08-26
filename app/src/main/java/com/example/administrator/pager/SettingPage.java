package com.example.administrator.pager;

import android.app.Activity;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class SettingPage extends  BasePage {


    public SettingPage(Activity activity) {
        super(activity);
    }

    @Override
    protected void initData() {
        tv_pagerContent_news.setText("设置");
    }
}