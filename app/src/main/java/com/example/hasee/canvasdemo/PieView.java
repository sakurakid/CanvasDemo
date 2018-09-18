package com.example.hasee.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * 饼状图
 *
 * 思路 需要的东西 名字 数值  百分比  对应的角度 颜色
 * 扇型 ---也就是弧度
 */
public class PieView extends View {
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    //初始角度
    private float mStartAngle = 0;
    //数据
    private ArrayList<PieDate> mData;
    //宽高
    private int mWidth, mHeight;
    //画笔
    private Paint mPaint = new Paint();

    // // 文字色块部分
    private PointF mStartPoint = new PointF(20, 20);
    private PointF mCurrentPoint = new PointF(mStartPoint.x, mStartPoint.y);
    private float mColorRectSideLength = 20;
    private float mTextInterval = 10;
    private float mRowMaxLength;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData) {
            return;
        }

        float currentStartAngle = mStartAngle; //当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2); //将画笔坐标移动到中心原点
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);//饼状图

        RectF rectF = new RectF(-r, -r, r, r);  //绘制区域

        for (int i = 0; i < mData.size(); i++) {
            PieDate pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();



            canvas.save();
            canvas.translate(-mWidth / 2, -mHeight / 2);
            RectF colorRect = new RectF(mCurrentPoint.x, mCurrentPoint.y, mCurrentPoint.x + mColorRectSideLength, mCurrentPoint.y + mColorRectSideLength);


            canvas.restore();
        }

    }

    // 设置起始角度
    public void setStartAngle(int  mStartAngle){
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    // 设置数据
    public void setData (ArrayList <PieDate> mData){
        this.mData = mData;
        initData(mData);
        invalidate();   // 刷新
    }

    //初始化数据
    private void initData(ArrayList<PieDate> mData){
        if (null == mData||mData.size() == 0){
            return;
        }


        float sumValue = 0;

        for(int i = 0;i < mData.size();i++){
            PieDate pie = mData.get(i);

            sumValue += pie.getValue(); //计算总和

            int j = i % mColors.length;
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;

        for (int i = 0;i < mData.size();i++){
            PieDate pie = mData.get(i);

            float perentage = pie.getValue()/sumValue; //百分比
            float angle = perentage*360;  //对应的角度

            pie.setPercentage(perentage);   //记录百分比
            pie.setAngle(angle);      //记录角度大小
            sumAngle += angle;

        }

    }
}
