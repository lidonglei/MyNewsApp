package com.example.administrator.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class RequestDisallowViewPager  extends ViewPager{


    private float startX;
    private float startY;
    private float endX;
    private float endy;



    public RequestDisallowViewPager(Context context) {
        super(context);
    }

    public RequestDisallowViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = ev.getRawX();
                startY=ev.getRawY();
                Log.e("huadong","00");

                break;
            case MotionEvent.ACTION_MOVE:

                endX = ev.getRawX();
                endy=ev.getRawY();

                float dx= Math.abs(endX-startX);
                float dy=Math.abs(endy-startY);
                


                //左右滑动
                if(dx>dy){

                    if((endX-startX)>0) {//左滑动

                        if (getCurrentItem() != 0) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    } //右滑
//                    else {
//                        if(getCurrentItem()!=getAdapter().getCount()-1){
//                            getParent().requestDisallowInterceptTouchEvent(true);
//                        }




                }else {
                    getParent().requestDisallowInterceptTouchEvent(false);


                }

                startX = endX;
                break;


            case MotionEvent.ACTION_UP:
                break;


        }


        return super.dispatchTouchEvent(ev);

    }
}
