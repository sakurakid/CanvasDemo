package com.example.hasee.canvasdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 组员
 */
public class MotionEventViewC extends View {
    public MotionEventViewC(Context context) {
        super(context);
    }

    public MotionEventViewC(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventViewC(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("111","组员 dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("111","组员 onTouchEvent");
        return super.onTouchEvent(event);
    }
}
