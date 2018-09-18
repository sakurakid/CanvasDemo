package com.example.hasee.canvasdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 滑动的第一种方式
 */
public class CustomView extends View {
    private int lastx;
    private int lasty;
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastx = x;
                lasty = y;
                break;

            case MotionEvent.ACTION_MOVE:
                int offx = x - lastx;
                int offy = y - lasty;

                //用layout方法重新放置他的位置
              //  layout(getLeft()+offx,getTop()+offy,getRight()+offx,getBottom()+offy);

                //offsetLeftAndRight
                //offsetLeftAndRight(offx);
                //offsetTopAndBottom(offy);

                //LayoutParams 布局参数
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
//                layoutParams.leftMargin = getLeft()+offx;
//                layoutParams.topMargin = getTop()+offy;
//                setLayoutParams(layoutParams);

                


                break;
        }
        return true;
    }
}
