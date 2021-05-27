package com.example.administrator.mylife.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义View
 */

public class MyView extends View{
    private Paint mpaint; // 画笔

    private float mWidth;
    private float mHeight;

    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
    }

    private float min;
    private float max;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mpaint = new Paint();


    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint.setAntiAlias(true);                       //设置画笔为无锯齿
        mpaint.setColor(Color.BLACK);                    //设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //白色背景

        RectF rectF = new RectF(0,0,mWidth, mHeight);
        canvas.drawRoundRect(rectF,mHeight/2, mHeight/2, mpaint);

        // 进度条颜色
        mpaint.setColor(Color.BLUE);
        RectF rectF1 = new RectF(0,0,min/max * mWidth, mHeight);
        canvas.drawRoundRect(rectF1,mHeight/2, mHeight/2, mpaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth =w;
        mHeight = h;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int minw = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 1);
        int h = resolveSizeAndState(MeasureSpec.getSize(w), heightMeasureSpec, 0);
        setMeasuredDimension(w, h);
    }


}
