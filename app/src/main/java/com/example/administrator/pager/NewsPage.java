package com.example.administrator.pager;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.activity.HomeActivity;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class NewsPage extends  BasePage {


    private HomeActivity mActivity;

    public NewsPage(Activity activity) {
        super(activity);
        mActivity= (HomeActivity) activity;

    }

    @Override
    protected void initData() {
        tv_pagerContent_news.setText("NewsPage");
        ib_pagerContent_newsMenuLeft.setVisibility(View.VISIBLE);

        ib_pagerContent_newsMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.setSlidingMenuToggle();
                Toast.makeText(mActivity,"oo",Toast.LENGTH_SHORT).show();
            }
        });
        ib_pagerContent_newsMenuRight.setVisibility(View.VISIBLE);



    }
}
