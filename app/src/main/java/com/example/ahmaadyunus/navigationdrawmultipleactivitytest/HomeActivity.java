package com.example.ahmaadyunus.navigationdrawmultipleactivitytest;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = getLayoutInflater().inflate(R.layout.activity_home,null);
        drawerLayout.addView(contentView,1);
        toolbar.setTitle(leftSliderData[position]);
    }
}
