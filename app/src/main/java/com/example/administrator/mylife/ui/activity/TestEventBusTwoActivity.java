package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.model.FirstEvent;

import de.greenrobot.event.EventBus;

/**
 * 测试使用eventBus界面
 */

public class TestEventBusTwoActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventtwo);
        initView();
    }


    private void initView() {
        Button button = (Button) findViewById(R.id.event_back);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event_back:
//                Intent intent = new Intent(this, TestEventBusActivity.class);
                EventBus.getDefault().post(new FirstEvent("message"));
                finish();
//                startActivity(intent);

                break;

            default:
                break;
        }
    }
}
