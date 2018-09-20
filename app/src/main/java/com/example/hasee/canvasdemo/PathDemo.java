package com.example.hasee.canvasdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Path的练习
 */
public class PathDemo extends View {
    private Paint mPaint;//画笔
    int mHeight,mWidth;//宽高

    public PathDemo(Context context) {
        super(context);
        initPaint();
    }

    public PathDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 初始化画笔
     */
    private void initPaint(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
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
        canvas.translate(mWidth/2,mHeight/2);

        //lineTo
        @SuppressLint("DrawAllocation") Path path = new Path();  //创建Path

//        path.lineTo(200,200);  //默认一开始从原点开始
//
//        //path.moveTo(200,100);//移动下一次操作开始的点 不会对上传操作进行影响
//       //path.setLastPoint(200,100);//移动下一次操作开始的点 会对上传操作进行影响，直接重置了上次最后一个点的位置
//
//
//
//        path.lineTo(200,0);  //接着上个点
//
//        path.close();//闭合 连接最后一个点和第一个点
//
//        canvas.drawPath(path,mPaint);

        //moveTo 移动下一次操作的起点位置



        //第二类 1
//        path.addRect(-200,-200,200,200,Path.Direction.CCW);//Direction 方向趋势cw 顺时针 ccw逆时针
//
//        path.setLastPoint(-300,300);
//
//
//        canvas.drawPath(path,mPaint);

        //第二类 2

//        canvas.scale(1,-1);
//
//        Path path1 = new Path();
//        Path src = new Path();
//
//        path1.addRect(-200,-200,200,200,Path.Direction.CW);
//        src.addCircle(0,0,100,Path.Direction.CW);
//
//        path1.addPath(src,0,200);//将第二个路径加到第一个路径里面，然后向上移动（0，200）
//
//        mPaint.setColor(Color.RED);
//        canvas.drawPath(path1,mPaint);


//        //第三类 圆弧
//        canvas.scale(1,-1);
//
//        Path path1 = new Path();
//        path.lineTo(100,100);
//
//        RectF oval = new RectF(0,0,200,200);
//
//      //  path1.addArc(oval,0,270); //第一种
//
//        //path1.arcTo(oval,0,270);  //第二种
//        canvas.drawPath(path1,mPaint);





    }
}
