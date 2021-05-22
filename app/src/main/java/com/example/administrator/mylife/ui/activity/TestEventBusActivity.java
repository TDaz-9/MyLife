package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.model.FirstEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * 测试eventBus使用界面
 * 主要。。。。。
 */

public class TestEventBusActivity extends Activity implements View.OnClickListener{
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        initView();
    }

    private void initView() {
        // 注册eventBus
        EventBus.getDefault().register(this);

        Button button = (Button) findViewById(R.id.comit_btn);
        button.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.tiaozhuan_btn);
        button1.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.message_eventbus);

        final RadioButton r1 = (RadioButton) findViewById(R.id.one_radio);
        final RadioButton r2 = (RadioButton) findViewById(R.id.two_radio);
        final RadioButton r3 = (RadioButton) findViewById(R.id.third_radio);
        final RadioButton r4 = (RadioButton) findViewById(R.id.four_radio);

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    r2.setChecked(false);
                    r3.setChecked(false);
                    r4.setChecked(false);
                }
            }
        });

        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    r1.setChecked(false);
                    r3.setChecked(false);
                    r4.setChecked(false);
                }
            }
        });

        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r4.setChecked(false);
                }
            }
        });

        r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 反注册eventBus
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 测试提交按钮eventbus使用
            case R.id.comit_btn:
                Intent intent = new Intent(this, TestEventBusTwoActivity.class);
                startActivity(intent);
                break;

            case R.id.tiaozhuan_btn:
                Intent intent1 = new Intent(this, TestEventBusThridActivity.class);
                startActivity(intent1);
                break;

            default:
                break;
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MainThread)
    public void onEvent(FirstEvent firstEvent) {
        String msg = "消息是:i"+ firstEvent.getMsg();
        tv.setText(msg);
    }
}
