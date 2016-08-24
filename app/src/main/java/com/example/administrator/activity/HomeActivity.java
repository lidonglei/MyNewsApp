package com.example.administrator.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.fragment.ContentFragment;
import com.example.administrator.fragment.LeftMenuFragment;
import com.example.administrator.mynewsapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class HomeActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        setBehindContentView(R.layout.slide_homeactivity);

        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(400);


        View inflate = View.inflate(this, R.layout.slide_homeactivity, null);
        View viewById = inflate.findViewById(R.id.tv_slideHome_activity);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tv_slideHome_activity,new  LeftMenuFragment());
        fragmentTransaction.replace(R.id.tv_activity_home,new ContentFragment());
    }
}
