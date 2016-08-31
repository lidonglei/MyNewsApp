package com.example.administrator.menuPage;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.bean.Categories;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class TopicMenuPage extends BaseMenuPage{


    public TopicMenuPage(Activity activity, Categories.MenuDataInfo menuDataInfo) {
        super(activity, menuDataInfo);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected View initView() {
        TextView textView=new TextView(homeActivity);
        textView.setText(menuDataInfo.title);
        textView.setGravity(Gravity.CENTER);





        return textView;
    }
}
