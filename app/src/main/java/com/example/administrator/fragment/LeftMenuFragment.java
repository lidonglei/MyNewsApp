package com.example.administrator.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class LeftMenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setText("mmmmmmm");
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.GRAY);



        return textView;



    }
}
