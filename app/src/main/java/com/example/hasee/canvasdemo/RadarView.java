package com.example.hasee.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 雷达图
 */
public class RadarView extends View {
    private int count = 6;  //数据的个数
    private float angle = (float)(Math.PI*2/count);
    private float radius;  //网格的最大半径
    private  int centerx; //中心x
    private  int centery;  //中心y
    private String[] titles = {"a","b","c","d","e","f"};
    private double[] data = {100,60,60,60,100,50,10,20}; //各维度分值
    private float maxValue = 100;             //数据最大值
    private Paint mainPaint;                //雷达区画笔
    private Paint valuePaint;               //数据区画笔
    private Paint textPaint;                //文本画笔
    public RadarView(Context context) {
        super(context);
        init();
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h,w)/2*0.9f;
        //中心坐标
        centerx = w/2;
        centery = h/2;
        super.onSizeChanged(w, h, oldw, oldh);
    }
    //初始化
    private void init() {
        count = Math.min(data.length,titles.length);

        mainPaint = new Paint();
        mainPaint.setAntiAlias(true);
        mainPaint.setColor(Color.GRAY);
        mainPaint.setStyle(Paint.Style.STROKE);

        valuePaint = new Paint();
        valuePaint.setAntiAlias(true);
        valuePaint.setColor(Color.BLUE);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint = new Paint();
        textPaint.setTextSize(20);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);//画多边形
    }
    /**
     * 绘制正多边形
     */
    private void drawPolygon(Canvas canvas){
        Path path = new Path();
        float r = radius/(count - 1); //蛛丝间的距离
        for (int i = 1;i < count;i++){
            float curR = r*i;//当前半径
            path.reset();//清空里面的东西
            for (int j = 0;j < count;j++){
                if (j == 0){
                    path.moveTo(centerx+curR,centery);
                }else {
                    //根据半径 然后计算五边形一个边的
                    float x = (float) (centerx + curR*Math.cos(angle*j));
                    float y = (float) (centery + curR*Math.sin(angle*j));
                    path.lineTo(x,y);
                }
            }
            path.close();//画完一个五边形就封闭
            canvas.drawPath(path,mainPaint);
        }
    }
}
