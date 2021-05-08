package com.example.administrator.mylife.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;
import com.example.administrator.mylife.ui.activity.fragment.HomePageFragment;
import com.example.administrator.mylife.ui.activity.fragment.LoveFragment;
import com.example.administrator.mylife.ui.activity.fragment.SearchFragment;
import com.example.administrator.mylife.ui.activity.fragment.SettingFragment;


/**
 * 测试fragment的activity
 */

public class TestFragmentActivity extends FragmentActivity implements View.OnClickListener{
    // 初始化4个fragment
    private Fragment homePageFragment;
    private Fragment loveFragment;
    private Fragment searchFragment;
    private Fragment settingFragment;

    private TextView homePageTv;
    private TextView searchTv;
    private TextView loveTv;
    private TextView settingTv;
    private NavBar navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testfragment);
        initView();
        homePageTv.setTextColor(0xff1B940A);
        initFragment(0);
    }
    private void initView(){
        navBar = new NavBar(this);
        navBar.setTitle("首页");
        navBar.hideLeft();
        navBar.hideRight();

        LinearLayout homeLayout = (LinearLayout) findViewById(R.id.homepage_layout);
        homeLayout.setOnClickListener(this);
        LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search_layout);
        searchLayout.setOnClickListener(this);
        LinearLayout loveLayout = (LinearLayout) findViewById(R.id.love_layout);
        loveLayout.setOnClickListener(this);
        LinearLayout setting = (LinearLayout) findViewById(R.id.setting_layout);
        setting.setOnClickListener(this);

        homePageTv = (TextView) findViewById(R.id.homepage_tv);
        searchTv = (TextView) findViewById(R.id.search_tv);
        loveTv = (TextView) findViewById(R.id.love_tv);
        settingTv = (TextView) findViewById(R.id.setting_tv);
    }

    private void initFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 开启事物
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        hideFragment(transaction);
        switch (index) {
            case 0:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();
                    transaction.add(R.id.content_fragment, homePageFragment);
                } else {
                    transaction.show(homePageFragment);
                }
                break;

            case 1:
                if (searchFragment == null) {
                    searchFragment = new SearchFragment();
                    transaction.add(R.id.content_fragment, searchFragment);
                } else {
                    transaction.show(searchFragment);
                }
                break;

            case 2:
                if (loveFragment == null) {
                    loveFragment = new LoveFragment();
                    transaction.add(R.id.content_fragment, loveFragment);
                } else {
                    transaction.show(loveFragment);
                }
                break;

            case 3:
                if (settingFragment== null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content_fragment, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }
                break;

            default:
                break;
        }
        transaction.commit();
    }

    // 隐藏fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (homePageFragment != null) {
            transaction.hide(homePageFragment);
        }
        if (searchFragment != null) {
            transaction.hide(searchFragment);
        }
        if (loveFragment != null) {
            transaction.hide(loveFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }

    @Override
    public void onClick(View view) {
        // 每次绘制重置底部颜色
        restartBotton();
        switch (view.getId()) {
            case R.id.homepage_layout:
                homePageTv.setTextColor(0xff1B940A);
                navBar.setTitle("首页");
                navBar.hideLeft();
                navBar.hideRight();
                initFragment(0);
                break;
            case R.id.search_layout:
                searchTv.setTextColor(0xff1B940A);
                navBar.setTitle("发现");
                navBar.hideLeft();
                navBar.hideRight();
                initFragment(1);
                break;
            case R.id.love_layout:
                loveTv.setTextColor(0xff1B940A);
                navBar.setTitle("兴趣");
                navBar.hideLeft();
                navBar.hideRight();
                initFragment(2);
                break;
            case R.id.setting_layout:
                settingTv.setTextColor(0xff1B940A);
                navBar.setTitle("设置");
                navBar.hideLeft();
                navBar.hideRight();
                initFragment(3);
                break;
            default:
                break;
        }
    }

    // 重置底部按钮颜色
    private void restartBotton() {
        homePageTv.setTextColor(0xffffffff);
        searchTv.setTextColor(0xffffffff);
        loveTv.setTextColor(0xffffffff);
        settingTv.setTextColor(0xffffffff);
    }

}
