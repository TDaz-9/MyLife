package com.example.administrator.mylife.ui.activity;
import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.adapter.MyFragmentPagerAdapter;
import com.example.administrator.mylife.ui.activity.fragment.FifthFragment;
import com.example.administrator.mylife.ui.activity.fragment.FirstFragment;
import com.example.administrator.mylife.ui.activity.fragment.FourFragment;
import com.example.administrator.mylife.ui.activity.fragment.SecondFragment;
import com.example.administrator.mylife.ui.activity.fragment.ThridFragment;


/**
 * 实现滑动的fragment
 */

public class ViewPagerFragmentActivity extends FragmentActivity implements OnClickListener, OnPageChangeListener{
    private ViewPager myviewpager;
    //fragment的集合，对应每个子页面
    private ArrayList<Fragment> fragments;
    //选项卡中的按钮
    private Button btn_first;
    private Button btn_second;
    private Button btn_third;
    private Button btn_four;
    private Button btn_fifth;
    //作为指示标签的按钮
    private ImageView cursor;
    //标志指示标签的横坐标
    float cursorX = 0;
    //所有按钮的宽度的集合
    private int[] widthArgs;
    //所有按钮的集合
    private Button[] btnArgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        initView();
    }

    public void initView(){
        myviewpager = (ViewPager)this.findViewById(R.id.myviewpager);

        btn_first = (Button)this.findViewById(R.id.btn_first);
        btn_second = (Button)this.findViewById(R.id.btn_second);
        btn_third = (Button)this.findViewById(R.id.btn_third);
        btn_four = (Button)this.findViewById(R.id.btn_four);
        btn_fifth = (Button)this.findViewById(R.id.btn_fifth);
        btnArgs = new Button[]{btn_first,btn_second,btn_third,btn_four,btn_fifth};

        cursor = (ImageView)this.findViewById(R.id.cursor_btn);
        cursor.setBackgroundColor(Color.RED);
        //通过此方法设置指示器的初始大小和位置
        btn_first.post(new Runnable(){
            @Override
            public void run() {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)cursor.getLayoutParams();
                //减去边距*2，以对齐标题栏文字
                lp.width = btn_first.getWidth()-btn_first.getPaddingLeft()*2;
                cursor.setLayoutParams(lp);
                cursor.setX(btn_first.getPaddingLeft());
            }
        });

        myviewpager.setOnPageChangeListener(this);
        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);
        btn_third.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_fifth.setOnClickListener(this);

        fragments = new ArrayList<Fragment>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThridFragment());
        fragments.add(new FourFragment());
        fragments.add(new FifthFragment());

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        myviewpager.setAdapter(adapter);

        resetButtonColor();
        btn_first.setTextColor(Color.RED);

    }

    //重置所有按钮的颜色
    public void resetButtonColor(){
        btn_first.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_second.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_third.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_four.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_fifth.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_first.setTextColor(Color.BLACK);
        btn_second.setTextColor(Color.BLACK);
        btn_third.setTextColor(Color.BLACK);
        btn_four.setTextColor(Color.BLACK);
        btn_fifth.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View whichbtn) {
        // TODO Auto-generated method stub

        switch (whichbtn.getId()) {
            case R.id.btn_first:
                myviewpager.setCurrentItem(0);
                cursorAnim(0);
                break;

            case R.id.btn_second:
                myviewpager.setCurrentItem(1);
                cursorAnim(1);
                break;

            case R.id.btn_third:
                myviewpager.setCurrentItem(2);
                cursorAnim(2);
                break;

            case R.id.btn_four:
                myviewpager.setCurrentItem(3);
                cursorAnim(3);
                break;

            case R.id.btn_fifth:
                myviewpager.setCurrentItem(4);
                cursorAnim(4);
                break;

            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {
        // TODO Auto-generated method stub
        if(widthArgs==null){
            widthArgs = new int[]{btn_first.getWidth(),
                    btn_second.getWidth(),
                    btn_third.getWidth(),
                    btn_four.getWidth(),
                    btn_fifth.getWidth()};
        }
        //每次滑动首先重置所有按钮的颜色
        resetButtonColor();
        //将滑动到的当前按钮颜色设置为红色
        btnArgs[arg0].setTextColor(Color.RED);
        cursorAnim(arg0);
    }

    //指示器的跳转，传入当前所处的页面的下标
    public void cursorAnim(int curItem){
        //每次调用，就将指示器的横坐标设置为0，即开始的位置
        cursorX = 0;
        //再根据当前的curItem来设置指示器的宽度
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)cursor.getLayoutParams();
        //减去边距*2，以对齐标题栏文字
        lp.width = widthArgs[curItem]-btnArgs[0].getPaddingLeft()*2;
        cursor.setLayoutParams(lp);
        //循环获取当前页之前的所有页面的宽度
        for(int i=0; i<curItem; i++){
            cursorX = cursorX + btnArgs[i].getWidth();
        }
        //再加上当前页面的左边距，即为指示器当前应处的位置
        cursor.setX(cursorX+btnArgs[curItem].getPaddingLeft());
    }
}
