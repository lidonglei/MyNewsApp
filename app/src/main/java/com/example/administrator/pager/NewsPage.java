package com.example.administrator.pager;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.bean.Categories;
import com.example.administrator.fragment.LeftMenuFragment;
import com.example.administrator.menuPage.BaseMenuPage;
import com.example.administrator.menuPage.InteractionMenuPage;
import com.example.administrator.menuPage.NewsMenuPage;
import com.example.administrator.menuPage.PicturesMenuPage;
import com.example.administrator.menuPage.TopicMenuPage;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class NewsPage extends  BasePage {


    public Categories categories;

    public ArrayList<BaseMenuPage> menuPages;

    public NewsPage(Activity activity) {

        super(activity);

    }
    @Override
    protected void initData() {

        tv_pagerContent_news.setText("新闻中心");
        ib_pagerContent_newsMenuLeft.setVisibility(View.VISIBLE);



        //new出 4个菜单页 并添加进集合



        //给news左侧菜单钮设置监听事件
        ib_pagerContent_newsMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity.setSlidingMenuToggle();

                Toast.makeText(homeActivity,"ooo",Toast.LENGTH_SHORT).show();
            }
        });
        ib_pagerContent_newsMenuRight.setVisibility(View.VISIBLE);

    }

    private void initMenuPage() {
        menuPages=new ArrayList<>();
        NewsMenuPage newsMenuPage = new NewsMenuPage(homeActivity, categories.data.get(0));

        menuPages.add(newsMenuPage);
        menuPages.add(new TopicMenuPage(homeActivity,categories.data.get(1)));
        menuPages.add(new PicturesMenuPage(homeActivity,categories.data.get(2)));
        menuPages.add(new InteractionMenuPage(homeActivity,categories.data.get(3)));

        initLinerLayout(newsMenuPage.menuView);
    }

    public void getLeftMenuData() {

        String url="http://10.0.2.2:8080/zhbj/categories.json";
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                String result=responseInfo.result;
                parseJSON(result);
            }
            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }

    public void parseJSON(String result){

        Gson gson=new Gson();
        categories = gson.fromJson(result, Categories.class);
        Log.e("ooooo",categories.toString());
        initMenuPage();

        LeftMenuFragment leftMenuFragment = homeActivity.getLeftMenuFragment();
        leftMenuFragment.setTitle(categories);

    }

    public  void initLinerLayout(View view){

        ll_homeActivity_forContent.removeAllViews();
        ll_homeActivity_forContent.addView(view);

        Log.e("newspage","view");
    }

    public ArrayList<BaseMenuPage> getMenuPages() {
        return menuPages;
    }
}
