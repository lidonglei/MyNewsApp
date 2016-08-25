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

    private SlidingMenu slidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setBehindContentView(R.layout.slide_homeactivity);

        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(600);
        slidingMenu.setFadeDegree(0.50f);




        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_slideHomeActivity_replace,new  LeftMenuFragment());
        fragmentTransaction.replace(R.id.fl_homeActivity_replace,new ContentFragment());

        fragmentTransaction.commit();


    }

    public void setSlidingMenuAble(boolean b) {


        if(b){
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

        }

    }

    public void setSlidingMenuToggle(){

        slidingMenu.toggle();
    }


}
