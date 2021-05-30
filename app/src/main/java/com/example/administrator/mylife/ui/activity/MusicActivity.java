package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mylife.R;

/**
 * Created by 瀛熸槦 on 2017/9/11.
 * 测试播放MP3
 */

public class MusicActivity extends Activity implements View.OnClickListener{
    private Button btn_play;
    private Button btn_pause;
    private Button btn_stop;
    private MediaPlayer mPlayer = null;
    private boolean isRelease = true;   //判断是否MediaPlayer是否释放的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_activity);
        bindViews();
    }

    private void bindViews() {
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_pause = (Button) findViewById(R.id.btn_pause);
        btn_stop = (Button) findViewById(R.id.btn_stop);

        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                if(isRelease){
                    mPlayer = MediaPlayer.create(this,R.raw.a);
                    isRelease = false;
                }
                mPlayer.start();   //开始播放
                btn_play.setEnabled(false);
                btn_pause.setEnabled(true);
                btn_stop.setEnabled(true);
                break;
            case R.id.btn_pause:
                mPlayer.pause();     //停止播放
                btn_play.setEnabled(true);
                btn_pause.setEnabled(false);
                btn_stop.setEnabled(false);
                break;
            case R.id.btn_stop:
                mPlayer.reset();     //重置MediaPlayer
                mPlayer.release();   //释放MediaPlayer
                isRelease = true;
                btn_play.setEnabled(true);
                btn_pause.setEnabled(false);
                btn_stop.setEnabled(false);
                break;
        }
    }
}
