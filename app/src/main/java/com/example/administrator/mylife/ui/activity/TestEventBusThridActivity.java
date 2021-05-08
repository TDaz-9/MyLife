package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.model.FirstEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * 第三个测试eventBus界面
 */

public class TestEventBusThridActivity extends Activity implements View.OnClickListener{
    private TextView tv;
    private Button button;

    private Handler mha = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                tv.setText("更新ui");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        initView();
    }

    private void initView() {
        EventBus.getDefault().register(this);
        tv = (TextView) findViewById(R.id.message_eventbus);
        button = (Button) findViewById(R.id.comit_btn);
        button.setOnClickListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MainThread)
    public void onEvent(FirstEvent firstEvent) {
        String msg = "消息是:i"+ firstEvent.getMsg();
        tv.setText(msg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.comit_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = 1;
                        mha.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
