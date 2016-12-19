package com.example.ahmaadyunus.navigationdrawmultipleactivitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = getLayoutInflater().inflate(R.layout.activity_contact,null);
        drawerLayout.addView(contentView,1);
    }
}
