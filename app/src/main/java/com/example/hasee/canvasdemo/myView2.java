package com.example.hasee.canvasdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.view.View;

/**
 * 画布的基本操作
 */
public class myView2 extends View{

    private Paint mPaint = new Paint();//画笔
    int mHeight,mWidth;//宽高

    private Picture mpicture = new Picture();//创建Picture

    //位移 translate是坐标系的移动，

    // 可以为图形绘制选择一个合适的坐标系

    // 位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动

    //        mPaint.setColor(Color.BLACK);

    //        canvas.translate(200,200);

    //        canvas.drawCircle(0,0,100,mPaint);

    //

    //        mPaint.setColor(Color.RED);

    //        canvas.translate(200,200);

    //        canvas.drawCircle(0,0,100,mPaint);


    //缩放


    //        canvas.translate(mWidth/2,mHeight/2);


    //        RectF rectF = new RectF(-400,-400,400,400); //绘制矩形区域


    //        mPaint.setColor(Color.BLACK);


    //       for (int i = 0;i <=20;i++){


    //           canvas.scale(0.9f,0.9f);


    //           canvas.drawRect(rectF,mPaint);


    //       }


    //旋转


    //        canvas.translate(mWidth/2,mHeight/2);


    //


    //        RectF rectF = new RectF(0,-400,400,0);


    //        mPaint.setColor(Color.BLACK);


    //        canvas.drawRect(rectF,mPaint);


    //


    //        canvas.rotate(180);


    //


    //        mPaint.setColor(Color.RED);


    //        canvas.drawRect(rectF,mPaint);


    //错切 线性变换  public void skew (float sx, float sy)


    //float sx:将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，


    //float sy:将画布在y轴方向上倾斜相应的角度，sy为倾斜角度的tan值


    //X = x + sx * y


    // Y = sy * x + y


    //


    //        canvas.translate(mWidth/2,mHeight/2);


    //        RectF rectF1 = new RectF(0,0,200,200);


    //


    //        mPaint.setColor(Color.BLACK);


    //        canvas.drawRect(rectF1,mPaint);


    //


    //        canvas.skew(1,0);


    //


    //        mPaint.setColor(Color.RED);


    //        canvas.drawRect(rectF1,mPaint);


    //mpicture.draw(canvas);// 1 picture绘制


    //canvas.drawPicture(mpicture,new RectF(0,0,mpicture.getWidth(),200));


    //包装成drawable


    //  PictureDrawable drawable = new PictureDrawable(mpicture);


    //设置绘制区域


    // drawable.setBounds(0,0,250,mpicture.getHeight());


    //绘制


    //drawable.draw(canvas);

    Bitmap bitmap = BitmapFactory.decodeResource(this.getContext().getResources(),R.raw.picture);



    public myView2(Context context) {
        super(context);
        recording();
        initPaint();
    }

    private void initPaint(){
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(50);
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

        //Bitmap的存放

       // canvas.drawBitmap(bitmap,200,500,new Paint()); 1

     //   canvas.drawBitmap(bitmap,500,600,new Paint());  2


//        //将画布移到画布中央                     3
//        canvas.translate(mWidth/2,mHeight/2);
//        //指定图片的绘制区域
//        Rect src = new Rect(0,0,bitmap.getWidth()/2,bitmap.getHeight()/2);
//        //图片在屏幕上的显示区域
//        Rect dst = new Rect(0,0,200,400);
//        //绘制图片
//        canvas.drawBitmap(bitmap,src,dst,null);
        //第一类
        String str = "无敌帅气可爱的笑笑";

        canvas.drawText(str,200,500,mPaint);
        //第二类 每个字母都绘制一个地方
        canvas.drawPosText(str,new float[]{
                100,100,
                200,200,
                300,300,
                400,400,
                500,500,
                600,600,
                700,700,
                800,800,
                900,900
        },mPaint);




    }
    /**
     * 录制
     */
    private void recording(){
        //开始录制
        Canvas canvas = mpicture.beginRecording(500,500);
        //创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        //绘制
        canvas.translate(250,250);
        canvas.drawCircle(0,0,100,paint);

        mpicture.endRecording();
    }
}
