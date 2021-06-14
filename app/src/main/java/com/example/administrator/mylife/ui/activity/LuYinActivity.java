package com.example.administrator.mylife.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mylife.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 孟星 on 2018/11/13.\
 *
 */

public class LuYinActivity extends Activity{
    private TextView showTv;
    private Button luzhiBtn;

    private MediaRecorder mediaRecorder;
    private File mAudioFile;

    private long mStratRecordTime;
    private long mStopRecordTime;

    private Handler mMainHandler;

    private ExecutorService executorService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly);
        initView();
    }


    private void initView() {
        showTv = (TextView) findViewById(R.id.show_ly);
        luzhiBtn = (Button) findViewById(R.id.start_btn);

        executorService = Executors.newSingleThreadExecutor();
        mMainHandler = new Handler(Looper.getMainLooper());

        luzhiBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startRecord();
                        break;

                    case MotionEvent.ACTION_UP:
                        stopRecord();
                        break;

                    case MotionEvent.ACTION_CANCEL:
//                        stopRecord();
                        break;

                    default:
                        break;
                }
                return true;
            }

        });
    }

    // 开始录音
    private void startRecord() {
        luzhiBtn.setText(R.string.go);

        // 后台任务执行录音开始逻辑
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                // 释放之前录音的record
                releaseRecord();

                // 执行录音逻辑，如果失败提示用户
                if (!doStart()){
                    recordFail();
                }
            }

        });
    }

    // 结束录音
    private void stopRecord() {
        luzhiBtn.setText(R.string.start);

        // 后台任务执行录音停止逻辑、
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                // 执行停止录音逻辑失败提醒用户
                if (!doStop()) {
                    recordFail();
                }
                // 释放MediaRecord
                releaseRecord();
            }
        });
    }

    // 启动录音逻辑
    private boolean doStart() {
        // 创建一个MediaRecord
        try {
            // 创建录音文件
            mediaRecorder = new MediaRecorder();
            mAudioFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/iMoocDemo/" +
                    System.currentTimeMillis() + ".m4a");
            mAudioFile.getParentFile().mkdirs();
            mAudioFile.createNewFile();
            // 配置MediaRecord
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 从麦克风采集
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);// 保存文件为mp4格式
            mediaRecorder.setAudioSamplingRate(44100);// 所有安卓系统都支持的采样频率
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);//通用的AAC编码格式
            mediaRecorder.setAudioEncodingBitRate(96000);// 音质比较好的频率
            // 设置录音文件保存位置
            mediaRecorder.setOutputFile(mAudioFile.getAbsolutePath());

            // 开始录音
            mediaRecorder.prepare();
            mediaRecorder.start();

            // 记录开始录音时间，记录时长
            mStratRecordTime = System.currentTimeMillis();
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            // 捕获异常，避免闪退，提醒用户
            return false;
        }

        // 录音成功
        return true;
    }

    // 停止录音逻辑
    private boolean doStop() {
        try {
            // 停止录音
            mediaRecorder.stop();
            // 记录停止时间，统计时长
            mStopRecordTime = System.currentTimeMillis();
            // 只接受超过三秒录音，在UI上显示出来
            final int secondTime = (int) ((mStopRecordTime - mStratRecordTime)/1000);
            if (secondTime > 3) {
                // 在主线程UI上显示出来
                mMainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        showTv.setText(showTv.getText() + "\n录音成功" + secondTime + "秒");
                    }
                });
            }
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }

        // 停止成功
        return true;
    }

    // 释放MediaRecord
    private void releaseRecord() {
        // 检查MediaRecord不为空
        if(mediaRecorder != null) {
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }

    // 录音错误处理
    private void recordFail() {
        mAudioFile = null;

        // 给用户提示失败，并需要在主线程
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LuYinActivity.this,"录音失败",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity停止时销毁,避免北村溢出
        executorService.shutdownNow();
        releaseRecord();
    }
}
