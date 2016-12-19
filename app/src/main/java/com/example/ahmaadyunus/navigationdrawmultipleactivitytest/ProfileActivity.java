package com.example.ahmaadyunus.navigationdrawmultipleactivitytest;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ProfileActivity extends MainActivity {

         @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             View contentView = getLayoutInflater().inflate(R.layout.activity_profile,null);
             drawerLayout.addView(contentView,1);
         }
}
