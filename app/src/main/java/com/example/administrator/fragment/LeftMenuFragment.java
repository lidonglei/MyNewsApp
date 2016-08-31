package com.example.administrator.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.activity.HomeActivity;
import com.example.administrator.bean.Categories;
import com.example.administrator.bean.LeftMenuTitle;
import com.example.administrator.menuPage.BaseMenuPage;
import com.example.administrator.mynewsapp.R;
import com.example.administrator.pager.BasePage;
import com.example.administrator.pager.NewsPage;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class LeftMenuFragment extends Fragment {

    HomeActivity homeActivity;

    int mPosition;
    ArrayList<String> titles;
    private ListView lv_leftFragment_menu;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        homeActivity= (HomeActivity) getActivity();
        titles=new ArrayList<>();
        View inflate = View.inflate(homeActivity, R.layout.leftfragment_menu, null);



        //设置适配器
        lv_leftFragment_menu = (ListView) inflate.findViewById(R.id.lv_leftFragment_menu);
        myAdapter = new MyAdapter();
        lv_leftFragment_menu.setAdapter(myAdapter);



        //设置点击事件
        lv_leftFragment_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mPosition=position;
                myAdapter.notifyDataSetChanged();

                //从leftMenu找到newsPage的linearLayout
                ContentFragment contentMenuFragment = homeActivity.getContentMenuFragment();
                ArrayList<BasePage> pages = contentMenuFragment.getPages();

                NewsPage newsPage = (NewsPage) pages.get(1);


                ArrayList<BaseMenuPage> menuPages = newsPage.getMenuPages();
                BaseMenuPage baseMenuPage = menuPages.get(position);

                newsPage.initLinerLayout(baseMenuPage.getMenuView());
                Log.e("leftmenu","position ="+position );



                homeActivity.setSlidingMenuToggle();
            }
        });





        return inflate;



    }


    public void  setTitle(Categories categories){


        ArrayList<Categories.MenuDataInfo> data = categories.data;
        if(titles.size()>0){
            titles.clear();
        }
        for(int i=0;i<data.size();i++){


            titles.add(data.get(i).title);
        }
        myAdapter.notifyDataSetChanged();


        Log.e("leftmenu",titles.size()+"");

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            String s=titles.get(position);

            View inflate = View.inflate(homeActivity, R.layout.leftfragment_menu_item, null);
            TextView tv_leftFragment_item = (TextView) inflate.findViewById(R.id.tv_leftFragment_item);
            tv_leftFragment_item.setText(" "+s);


            if(mPosition!=position){

                tv_leftFragment_item.setEnabled(false);
            }else {

                tv_leftFragment_item.setEnabled(true);
            }
            return inflate;
        }
    }
}
