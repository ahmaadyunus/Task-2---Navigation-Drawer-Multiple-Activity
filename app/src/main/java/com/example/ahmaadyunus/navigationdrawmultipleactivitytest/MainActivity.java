package com.example.ahmaadyunus.navigationdrawmultipleactivitytest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected DrawerLayout drawerLayout;
    protected RelativeLayout mRelativeLayout;
    protected ActionBarDrawerToggle drawerToggle;
    protected ListView leftDrawerList;
    protected ArrayAdapter<String> navigationDrawerAdapter;
    protected static int position;
    protected String [] leftSliderData;
    private static boolean isLaunch=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leftSliderData = getResources().getStringArray(R.array.navigation_drawer_items_array);
        setContentView(R.layout.activity_main);

        nitView(leftSliderData);
        initDrawer();
        toolbar.setTitle(leftSliderData[position]);
        if(isLaunch){
            openActivity(0,leftSliderData);
            isLaunch=false;
        }
    }

    protected void nitView(final String [] leftSliderData) {
        leftDrawerList = (ListView) findViewById(R.id.left_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayoutleftdrawer);
        navigationDrawerAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leftSliderData);

        leftDrawerList.setAdapter(navigationDrawerAdapter);
        leftDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                    openActivity(position, leftSliderData);

            }
        });




    }

    protected void initDrawer() {

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
       drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void openActivity(int position, String [] leftSliderData) {
    leftDrawerList.setItemChecked(position, true);
    setTitle(leftSliderData[position]);
       drawerLayout.closeDrawer(mRelativeLayout);
        MainActivity.position = position; //Setting currently selected position in this field so that it will be available in our child activities.

        switch (position) {
            case 0:
                startActivity(new Intent(this, HomeActivity.class));

                break;
            case 1:
                startActivity(new Intent(this, ProfileActivity.class));
//                break;
//            case 2:
//                startActivity(new Intent(this, Item3Activity.class));
//                break;
//            case 3:
//                startActivity(new Intent(this, Item4Activity.class));
//                break;
//            case 4:
//                startActivity(new Intent(this, Item5Activity.class));
//                break;

            default:
                break;
        }

        Toast.makeText(this, "Selected Item Position::"+position, Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = drawerLayout.isDrawerOpen(leftDrawerList);
        //menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /* We can override onBackPressed method to toggle navigation drawer*/
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(leftDrawerList)){
            drawerLayout.closeDrawer(leftDrawerList);
        }else {
            drawerLayout.openDrawer(leftDrawerList);
        }
    }
}
