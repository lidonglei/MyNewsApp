package com.example.administrator.menuPage;

import android.app.Activity;
import android.view.View;

import com.example.administrator.activity.HomeActivity;
import com.example.administrator.bean.Categories;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public abstract class BaseMenuPage {




    HomeActivity homeActivity;
    public View menuView;

    public Categories.MenuDataInfo menuDataInfo;

    public BaseMenuPage(Activity activity, Categories.MenuDataInfo menuDataInfo){
        homeActivity= (HomeActivity) activity;
        this.menuDataInfo=menuDataInfo;
        menuView=initView();

        initData();

    }

    protected abstract void initData();

    protected abstract View initView();

    public View getMenuView() {
        return menuView;
    }
}
