package com.example.hasee.canvasdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

public class myView extends View {
    private Paint mPaint = new Paint();//画笔

    public myView(Context context) {
        super(context);
        initPaint();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawColor(Color.RED);
        //点
       // canvas.drawPoint(200,200,mPaint);
        //直线
       // canvas.drawLine(300,300,600,800,mPaint);
        //矩形
       // canvas.drawRect(100,100,800,400,mPaint);
        //圆形矩形 rx ry实际上是椭圆的两个半径
       // canvas.drawRoundRect(100,100,800,400,30,30,mPaint);
        //椭圆  传的是一个矩形
        //canvas.drawOval(100,100,800,400,mPaint);
        //圆
        //canvas.drawCircle(500,500,400,mPaint);
         //左上角和右下角的坐标
        RectF rectF = new RectF(0,100,500,400);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rectF,mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawArc(rectF,0,90,true,mPaint);


    }

    private void initPaint(){
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }
}
