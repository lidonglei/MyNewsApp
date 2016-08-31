package com.example.administrator.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.mynewsapp.R;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class RefreshListView  extends ListView{

    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private View refresh_listview_head;
    private int measuredHeight;

    public RefreshListView(Context context) {
        super(context);
    }

    public RefreshListView(Context context, AttributeSet attrs) {



        super(context, attrs);


        initView(context);
    }

    private static int LISTVIEWHEAD_INITIAL_STATE=0;
    private static int LISTVIEWHEAD_NEEDRELEASE=1;
    private static int LISTVIEWHEAD_REFRESHING=2;
    private static int liststate=-1;




    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:

                startX = ev.getRawX();
                startY = ev.getRawY();

                break;

            case MotionEvent.ACTION_MOVE:

                if(startX==0&&startY==0){

                    startX=ev.getRawX();
                    startY=ev.getRawY();
                }
                endX=ev.getRawX();
                endY=ev.getRawY();

                float dx=Math.abs(endX-startX);
                float dy=Math.abs(endY-startY);

                if((endY-startY)>0&&dy>dx){

                    refresh_listview_head.setPadding(0, (int) (-measuredHeight+dy),0,0);
                }


                break;

            case MotionEvent.ACTION_UP:
                startX=0;
                startY=0;

                break;


        }



        return super.onTouchEvent(ev);
    }

    private void initView(Context context) {

        refresh_listview_head = View.inflate(context, R.layout.refresh_listview_head, null);
        refresh_listview_head.measure(0,0);
        measuredHeight = refresh_listview_head.getMeasuredHeight();



        refresh_listview_head.setPadding(0,-measuredHeight,0,0);
        addHeaderView(refresh_listview_head);


    }
}
