package com.example.administrator.activity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.fragment.ContentFragment;
import com.example.administrator.fragment.LeftMenuFragment;
import com.example.administrator.mynewsapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class HomeActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setBehindContentView(R.layout.slide_homeactivity);

        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(700);
        slidingMenu.setFadeDegree(0.50f);


        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_slideHomeActivity_replace,new  LeftMenuFragment(),"leftFrag");
        fragmentTransaction.replace(R.id.fl_homeActivity_replace,new ContentFragment(),"contentFrag");

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

    public  LeftMenuFragment getLeftMenuFragment(){

        return  (LeftMenuFragment) fragmentManager.findFragmentByTag("leftFrag");


    }
    public  ContentFragment getContentMenuFragment(){

        Log.e("homeactivity","getcontent");
        return  (ContentFragment) fragmentManager.findFragmentByTag("contentFrag");


    }


}
