package com.example.administrator.mylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mylife.tool.NavBar;
import com.example.administrator.mylife.ui.activity.ImageShowActivity;
import com.example.administrator.mylife.ui.activity.LuYinActivity;
import com.example.administrator.mylife.ui.activity.MusicActivity;
import com.example.administrator.mylife.ui.activity.RecyclerViewTest;
import com.example.administrator.mylife.ui.activity.TestEventBusActivity;
import com.example.administrator.mylife.ui.activity.TestFragmentActivity;
import com.example.administrator.mylife.ui.activity.TestListActivity;
import com.example.administrator.mylife.ui.activity.ViewPagerFragmentActivity;
import com.example.administrator.mylife.ui.activity.phone.GetPhoneActivity;
import com.example.administrator.mylife.ui.activity.studyGlide.GlideActivity;
import com.example.administrator.mylife.ui.activity.wxapi.WXEntryActivity;
import com.example.administrator.mylife.util.CustomDialog;

import static com.example.administrator.mylife.R.id.caiming_et;
import static com.example.administrator.mylife.R.id.glide_btn;
import static com.example.administrator.mylife.R.id.start;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button dialogBtn;
    private Button easyDialogBtn;
    private Button listBtn;
    private Button fragmentBtn;
    private Button viewPagerFragmentBtn;
    private Button h5Button;
    private Button musicButton;
    private Button getPhone;
    private Button wxBtn;
    private Button lyBtn;
    private CustomDialog errorDialog;
    private CustomDialog easyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("??????");
        navBar.hideRight();
        dialogBtn = (Button) findViewById(R.id.dialog_btn);
        dialogBtn.setOnClickListener(this);
        easyDialogBtn = (Button) findViewById(R.id.easy_dialog_btn);
        easyDialogBtn.setOnClickListener(this);

        // ??????listview??????
        listBtn = (Button) findViewById(R.id.list_view_btn);
        listBtn.setOnClickListener(this);

        // ??????H5??????
        h5Button = (Button) findViewById(R.id.hfive_btn);
        h5Button.setOnClickListener(this);

        // EventBus??????
        Button eventBusBtn = (Button) findViewById(R.id.even_bus);
        eventBusBtn.setOnClickListener(this);

        // ????????????
        Button imageBtn = (Button) findViewById(R.id.image_show_btn);
        imageBtn.setOnClickListener(this);

        // ???????????????
        getPhone = (Button) findViewById(R.id.getphone);
        getPhone.setOnClickListener(this);

        // ????????????
        musicButton = (Button) findViewById(R.id.music_btn);
        musicButton.setOnClickListener(this);

        // ??????fragment
        fragmentBtn = (Button) findViewById(R.id.fragment_btn);
        fragmentBtn.setOnClickListener(this);
        viewPagerFragmentBtn = (Button) findViewById(R.id.viewpager_fragment);
        viewPagerFragmentBtn.setOnClickListener(this);

        // ????????????
        wxBtn = (Button) findViewById(R.id.wx_btn);
        wxBtn.setOnClickListener(this);

        // ??????
        lyBtn = (Button) findViewById(R.id.ly_btn);
        lyBtn.setOnClickListener(this);

        // glide??????
        Button glideBtn = (Button) findViewById(glide_btn);
        glideBtn.setOnClickListener(this);
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
                        .setMessage(R.id.message, "??????")
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
                        .setTitle(R.id.easy_message, "????????????")
                        .addViewOnclick(R.id.easy_sure_btn, listener)
                        .addViewOnclick(R.id.easy_cancle_btn, listener)
                        .build();
                easyDialog.show();
                break;

            case R.id.list_view_btn:
                Intent intentList = new Intent(this, RecyclerViewTest.class);
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

            // ?????????????????????
            case R.id.hfive_btn:
                Intent intent = new Intent(this, com.example.administrator.mylife.com.example.qr_codescan.MainActivity.class);
                startActivity(intent);
                break;

            // ??????eventBus??????
            case R.id.even_bus:
                Intent intentE = new Intent(this, TestEventBusActivity.class);
                startActivity(intentE);
                break;

            // ????????????
            case R.id.image_show_btn:
                Intent intentImage = new Intent(this, ImageShowActivity.class);
                startActivity(intentImage);
                break;

            // ??????
            case R.id.music_btn:
                Intent intentMusic = new Intent(this, MusicActivity.class);
                startActivity(intentMusic);
                break;

            // Glide
            case R.id.glide_btn:
                Intent intentGlide = new Intent(this, GlideActivity.class);
                startActivity(intentGlide);
                break;

            // ????????????????????????
            case R.id.getphone:
                Intent intentPhone = new Intent(this, GetPhoneActivity.class);
                startActivity(intentPhone);
                break;

            // ????????????
            case R.id.wx_btn:
                Intent intentWx = new Intent(this, WXEntryActivity.class);
                startActivity(intentWx);
                break;

            // ????????????
            case R.id.ly_btn:
                Intent intentLy = new Intent(this, LuYinActivity.class);
                startActivity(intentLy);

            default:
                break;
        }
    }

    // dialog??????????????????
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_cancel:
                    Toast.makeText(MainActivity.this, "??????", Toast.LENGTH_LONG).show();
                    errorDialog.dismiss();
                    break;

                case R.id.easy_sure_btn:
                    Toast.makeText(MainActivity.this, "????????????", Toast.LENGTH_LONG).show();
                    easyDialog.dismiss();
                    break;

                case R.id.easy_cancle_btn:
                    Toast.makeText(MainActivity.this, "????????????", Toast.LENGTH_LONG).show();
                    easyDialog.dismiss();
                    break;

                default:
                    break;
            }
        }
    };
}
