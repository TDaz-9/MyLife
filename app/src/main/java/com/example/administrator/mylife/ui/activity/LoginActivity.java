package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mylife.MainActivity;
import com.example.administrator.mylife.R;
import com.example.administrator.mylife.adapter.HomePageAdapter;
import com.example.administrator.mylife.model.HomeName;
import com.example.administrator.mylife.tool.NavBar;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * 用于显示所有可链接项
 */

public class LoginActivity extends Activity {
    private List<HomeName> list;
    HomeName homeName;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private long firstTime = 0;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                // 先判断侧边栏是否开启（开启的话 先关闭  在按两次退出App）
                if (drawerLayout.isDrawerOpen(findViewById(R.id.test_left_tv))) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    long secondTime = System.currentTimeMillis();
                    if (secondTime - firstTime > 2000) {                                         //如果两次按键时间间隔大于2秒，则不退出
                        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                        firstTime = secondTime;//更新firstTime
                        return true;
                    } else {                                                    //两次按键小于2秒时，退出应用
                        System.exit(0);
                    }
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {

    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.hideLeft();
        navBar.setTitle("首页");

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        TextView newsTv = (TextView) findViewById(R.id.news_tv);
        drawerLayout = (DrawerLayout) findViewById(R.id.login_draw_layout);
        newsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "测试滑动点击", Toast.LENGTH_SHORT).show();
            }
        });

        // 侧边栏点击事件(侧边栏滑出  底部不响应事件)
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawerView.setClickable(true);
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        list = new ArrayList<>();
        homeName = new HomeName("学习");
        list.add(homeName);
        homeName = new HomeName("生活");
        list.add(homeName);
        homeName = new HomeName("娱乐");
        list.add(homeName);
        homeName = new HomeName("兴趣");
        list.add(homeName);
        homeName = new HomeName("食谱");
        list.add(homeName);
        homeName = new HomeName("美图");
        list.add(homeName);
        BaseAdapter mAdapter = new HomePageAdapter<HomeName>((ArrayList<HomeName>) list, R.layout.login_item) {

            @Override
            public void bindView(ViewHolder holder, HomeName obj) {
                switch (obj.getName()) {
                    case "学习":
                        holder.setImageResource(R.id.image_iv, R.drawable.domawb);
                        break;
                    case "生活":
                        holder.setImageResource(R.id.image_iv, R.drawable.domawb);
                        break;
                    case "娱乐":
                        holder.setImageResource(R.id.image_iv, R.drawable.domawb);
                        break;
                    case "兴趣":
                        holder.setImageResource(R.id.image_iv, R.drawable.domawb);
                        break;
                    case "食谱":
                        holder.setImageResource(R.id.image_iv, R.drawable.domawb);
                        break;
                    case "美图":
                        holder.setImageResource(R.id.image_iv, R.drawable.domawb);
                        break;
                    default:
                        break;
                }
                holder.setText(R.id.image_tv, obj.getName());
            }
        };
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (list.get(position).getName().equals("学习")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (list.get(position).getName().equals("生活")) {
                    Toast.makeText(LoginActivity.this, "尚未开发", Toast.LENGTH_SHORT).show();
                } else if (list.get(position).getName().equals("娱乐")) {
                    Toast.makeText(LoginActivity.this, "尚未开发", Toast.LENGTH_SHORT).show();
                } else if (list.get(position).getName().equals("兴趣")) {
                    Toast.makeText(LoginActivity.this, "尚未开发", Toast.LENGTH_SHORT).show();
                } else if (list.get(position).getName().equals("食谱")) {
                    Intent intent = new Intent(LoginActivity.this, FavouriteSearchActivity.class);
                    startActivity(intent);
                } else if (list.get(position).getName().equals("美图")) {
                Intent intent = new Intent(LoginActivity.this, ImageActivity.class);
                startActivity(intent);
            }
            }
        });
    }
}
