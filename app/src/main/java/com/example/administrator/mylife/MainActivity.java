package com.example.administrator.mylife;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mylife.tool.NavBar;
import com.example.administrator.mylife.ui.activity.TestEventBusActivity;
import com.example.administrator.mylife.ui.activity.TestFragmentActivity;
import com.example.administrator.mylife.ui.activity.TestListActivity;
import com.example.administrator.mylife.ui.activity.ViewPagerFragmentActivity;
import com.example.administrator.mylife.util.CustomDialog;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button dialogBtn;
    private Button easyDialogBtn;
    private Button listBtn;
    private Button fragmentBtn;
    private Button viewPagerFragmentBtn;
    private Button h5Button;
    private CustomDialog errorDialog;
    private CustomDialog easyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("学习");
        navBar.hideRight();
        dialogBtn = (Button) findViewById(R.id.dialog_btn);
        dialogBtn.setOnClickListener(this);
        easyDialogBtn = (Button) findViewById(R.id.easy_dialog_btn);
        easyDialogBtn.setOnClickListener(this);

        // 显示listview界面
        listBtn = (Button) findViewById(R.id.list_view_btn);
        listBtn.setOnClickListener(this);

        // 测试H5界面
        h5Button = (Button) findViewById(R.id.hfive_btn);
        h5Button.setOnClickListener(this);

        // EventBus使用
        Button eventBusBtn = (Button) findViewById(R.id.even_bus);
        eventBusBtn.setOnClickListener(this);

        // 测试fragment
        fragmentBtn = (Button) findViewById(R.id.fragment_btn);
        fragmentBtn.setOnClickListener(this);
        viewPagerFragmentBtn = (Button) findViewById(R.id.viewpager_fragment);
        viewPagerFragmentBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_btn:
                CustomDialog.Builder builder = new CustomDialog.Builder(this);
                errorDialog = builder.style(R.style.Dialog)
                        .heightDimenRes(R.dimen.dilog_identitychange_height)
                        .widthDimenRes(R.dimen.dilog_identitychange_width)
                        .cancelTouchout(false)
                        .view(R.layout.dialog_error)
                        .addViewOnclick(R.id.btn_cancel, listener)
                        .setMessage(R.id.message, "测试")
                        .build();
                errorDialog.show();
                break;

            case R.id.easy_dialog_btn:
                CustomDialog.Builder builderTwo = new CustomDialog.Builder(this);
                easyDialog = builderTwo.style(R.style.Dialog)
                        .heightDimenRes(R.dimen.easy_dilog_identitychange_height)
                        .widthDimenRes(R.dimen.easy_dilog_identitychange_width)
                        .cancelTouchout(false)
                        .view(R.layout.dialog_easy)
                        .setTitle(R.id.easy_message, "删除信息")
                        .addViewOnclick(R.id.easy_sure_btn, listener)
                        .addViewOnclick(R.id.easy_cancle_btn, listener)
                        .build();
                easyDialog.show();
                break;

            case R.id.list_view_btn:
                Intent intentList = new Intent(this, TestListActivity.class);
                startActivity(intentList);
                break;

            case R.id.fragment_btn:
                Intent intentFragment = new Intent(this, TestFragmentActivity.class);
                startActivity(intentFragment);
                break;

            case R.id.viewpager_fragment:
                Intent intentViewpager = new Intent(this, ViewPagerFragmentActivity.class);
                startActivity(intentViewpager);
                break;

            // 测试扫描码界面
            case R.id.hfive_btn:
                Intent intent = new Intent(this, com.example.administrator.mylife.com.example.qr_codescan.MainActivity.class);
                startActivity(intent);
                break;

            // 学习eventBus使用
            case R.id.even_bus:
                Intent intentE = new Intent(this, TestEventBusActivity.class);
                startActivity(intentE);
                break;

            default:
                break;
        }
    }

    // dialog内部点击事件
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_cancel:
                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                    errorDialog.dismiss();
                    break;

                case R.id.easy_sure_btn:
                    Toast.makeText(MainActivity.this, "点击确定", Toast.LENGTH_LONG).show();
                    easyDialog.dismiss();
                    break;

                case R.id.easy_cancle_btn:
                    Toast.makeText(MainActivity.this, "点击取消", Toast.LENGTH_LONG).show();
                    easyDialog.dismiss();
                    break;

                default:
                    break;
            }
        }
    };
}
