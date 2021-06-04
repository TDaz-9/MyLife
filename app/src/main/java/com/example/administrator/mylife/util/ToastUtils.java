package com.example.administrator.mylife.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 兴兴 on 2016/3/31.
 */
public class ToastUtils {
    private static ToastUtils instance = null;
    private static Context mContext;
    private Toast mToast;
    private final Handler mHandler;
    private Timer mTimer;

    private ToastUtils() {
        mHandler = new Handler();
    }

    public static ToastUtils getInstance(Context context){
        mContext = context;
        if (instance == null) {
            synchronized (ToastUtils.class) {
                if (instance == null) {
                    instance = new ToastUtils();
                }
            }
        }
        return instance;
    }

    public void showToast(String text, ToastListener toastListener) {
        mToastListener = toastListener;
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
//            mToast.setGravity(Gravity.CENTER,0,0);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }

            mToast.getView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    if (mToastListener != null) {
                        mToastListener.onShow();
                    }
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    if (mToastListener != null) {
                        mToastListener.onDismiss();
                    }
                }
            });
        mToast.show();
        startTimer();
    }

    private void startTimer() {
        stopTimer();
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        dismissToast();
                    }
                });
            }
        },1000);
    }

    private void stopTimer() {
        if (mTimer!= null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void showToast(String text) {
        showToast(text,null);
    }


    public void dismissToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    public interface ToastListener{
        void onShow();
        void onDismiss();
    }

    private ToastListener mToastListener;
}
