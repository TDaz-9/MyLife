package com.example.administrator.mylife.ui.activity.wxapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;
import com.example.administrator.mylife.util.WechatShareManager;

/**
 * Created by mengxing on 2017/10/11.
 *
 */

public class WXEntryActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mShareText, mSharePicture, mShareVideo;
    private WechatShareManager mShareManager;

    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("微信");
        navBar.hideRight();
        mShareText = (Button) findViewById(R.id.share_text);
        mSharePicture = (Button) findViewById(R.id.share_picture);
        mShareVideo = (Button) findViewById(R.id.share_video);
        mShareText.setOnClickListener(this);
        mSharePicture.setOnClickListener(this);
        mShareVideo.setOnClickListener(this);

        mContext = this;

        mShareManager = WechatShareManager.getInstance(mContext);
    }


    private boolean isWebchatAvaliable() {
        //检测手机上是否安装了微信
        try {
            getPackageManager().getPackageInfo("com.tencent.mm", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        if (!isWebchatAvaliable()) {
            Toast.makeText(mContext, "请先安装微信", Toast.LENGTH_LONG).show();
            return;
        }
        switch (view.getId()) {
            case R.id.share_text:
                WechatShareManager.ShareContentText mShareContentText = (WechatShareManager.ShareContentText) mShareManager.getShareContentText("微信文本分享");
                mShareManager.shareByWebchat(mShareContentText, WechatShareManager.WECHAT_SHARE_TYPE_FRENDS);
                break;
            case R.id.share_picture:
                WechatShareManager.ShareContentPicture mShareContentPicture = (WechatShareManager.ShareContentPicture) mShareManager.getShareContentPicture(R.drawable.wait);
                mShareManager.shareByWebchat(mShareContentPicture, WechatShareManager.WECHAT_SHARE_TYPE_FRENDS);
                break;
            case R.id.share_video:
                WechatShareManager.ShareContentVideo mShareContentVideo = (WechatShareManager.ShareContentVideo) mShareManager.getShareContentVideo("http://baidu.hz.letv.com/kan/agSlT?fr=v.baidu.com/");
                mShareManager.shareByWebchat(mShareContentVideo, WechatShareManager.WECHAT_SHARE_TYPE_FRENDS);
                break;
            default:
                break;
        }
    }
}
