package com.example.administrator.pager;

import android.app.Activity;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class GovernPage extends  BasePage {


    public GovernPage(Activity activity) {
        super(activity);
    }

    @Override
    protected void initData() {
        tv_pagerContent_news.setText("政务");
    }
}
