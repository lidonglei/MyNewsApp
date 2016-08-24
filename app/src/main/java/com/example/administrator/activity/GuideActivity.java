package com.example.administrator.activity;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.administrator.mynewsapp.R;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {


    ArrayList<ImageView> images;
    int i;
    private Button bt_guideActivity_guide;
    private  final static int viewPageNum=3;
    private View view_guideActivity_redpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        view_guideActivity_redpoint = findViewById(R.id.view_guideActivity_redpoint);

        bt_guideActivity_guide = (Button) findViewById(R.id.bt_guideActivity_guide);

        getIndicator();

        initImages();

        initViewPager();




    }

    private void initViewPager() {
        ViewPager vp_guideActivity_guide = (ViewPager) findViewById(R.id.vp_guideActivity_guide);

        vp_guideActivity_guide.setAdapter(new MyPagerAdapter());

        vp_guideActivity_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
                if(position==2){
                    bt_guideActivity_guide.setVisibility(View.VISIBLE);


                }else{
                    bt_guideActivity_guide.setVisibility(View.INVISIBLE);
                }

                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)
                        view_guideActivity_redpoint.getLayoutParams();

                layoutParams.leftMargin= (int) (position*80+positionOffset*60);

                view_guideActivity_redpoint.setLayoutParams(layoutParams);


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            //ViewPager#SCROLL_STATE_IDLE
            //ViewPager#SCROLL_STATE_DRAGGING
            //ViewPager#SCROLL_STATE_SETTLING
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initImages() {
        int [] imagesInt=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        images=new ArrayList<>();
        i=2;

        for(int j=0;j<=i;j++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imagesInt[j]);
            images.add(imageView);

        }
    }

    private void getIndicator() {

        LinearLayout ll_guideActivity_indicator = (LinearLayout)
                        findViewById(R.id.ll_guideActivity_indicator);
        for(int i=0;i<viewPageNum;i++){
            View view = new View(this);

            LinearLayout.LayoutParams layoutParams=new
                 LinearLayout.LayoutParams(40,40);//在代码中没有单位 默认是像素px

            if(i!=0){
                layoutParams.leftMargin=40;
            }
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.graypoint);
            ll_guideActivity_indicator.addView(view);
        }






    }


    class MyPagerAdapter  extends PagerAdapter{
        @Override
        public int getCount() {

            return viewPageNum;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            ImageView imageView = images.get(position);
            container.addView(imageView);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((ImageView)object);

           // super.destroyItem(container, position, object);
        }
    }


    public  void goToHome(View view){
        startActivity(new Intent(this,HomeActivity.class));


    }
}
