package com.example.administrator.pager;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.activity.HomeActivity;
import com.example.administrator.menuPage.BaseMenuPage;
import com.example.administrator.menuPage.InteractionMenuPage;
import com.example.administrator.menuPage.NewsMenuPage;
import com.example.administrator.menuPage.PicturesMenuPage;
import com.example.administrator.menuPage.TopicMenuPage;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class NewsPage extends  BasePage {


    private HomeActivity mActivity;
    public ArrayList<BaseMenuPage> menuPages;

    public NewsPage(Activity activity) {

        super(activity);
        mActivity= (HomeActivity) activity;
        menuPages=new ArrayList<>();
    }

    @Override
    protected void initData() {
        tv_pagerContent_news.setText("新闻中心");
        ib_pagerContent_newsMenuLeft.setVisibility(View.VISIBLE);


        //给news左侧菜单钮设置监听事件
        ib_pagerContent_newsMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.setSlidingMenuToggle();

                //new出 4个菜单页 并添加进集合
                if (menuPages.size()==0){
                    menuPages.add(new NewsMenuPage());
                    menuPages.add(new TopicMenuPage());
                    menuPages.add(new PicturesMenuPage());
                    menuPages.add(new InteractionMenuPage());
                }


                Toast.makeText(mActivity,"ooo",Toast.LENGTH_SHORT).show();
            }
        });
        ib_pagerContent_newsMenuRight.setVisibility(View.VISIBLE);

    }

    public  void initLinerLayout(View view){

        ll_homeActivity_forContent.removeAllViews();
        ll_homeActivity_forContent.addView(view);

        Log.e("newspage","view");
    }
}
