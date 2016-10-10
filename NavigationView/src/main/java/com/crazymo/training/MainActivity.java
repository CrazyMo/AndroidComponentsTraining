package com.crazymo.training;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    private DrawerLayout drawerlayout;
    private NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void getViews(){
        mNavView= (NavigationView) findViewById(R.id.id_nv_menu);
        drawerlayout= (DrawerLayout) findViewById(R.id.id_drawer_layout);
    }
    //设置选中item事件
    private void setNavItemListener(){
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                Log.e("CrazyMo", "onNavigationItemSelected: "+"选中item的Id"+item.getItemId());
                return true;
            }
        });
    }
    //设置HeadView点击事件
    private void setHeadViewClick(){
        //首先你得先获取得到HeadView的对象
        mNavView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.closeDrawers();//关闭导航菜单
                Log.e("CrazyMo", "onClick: " +"HeadView Clicked");
            }
        });
    }
    private void init(){
        getViews();
        //初始化NavigationView
        mNavView.setBackgroundResource(R.mipmap.nav_bcg);
        //mNavView.setItemBackgroundResource(R.mipmap.nav_bcg);
        setNavItemListener();
        setHeadViewClick();
    }
}
