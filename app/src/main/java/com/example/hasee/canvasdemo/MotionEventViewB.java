package com.example.hasee.canvasdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 组长
 */
public class MotionEventViewB extends LinearLayout {
    public MotionEventViewB(Context context) {
        super(context);
    }

    public MotionEventViewB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventViewB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("111","组长 dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("111","组长 onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("111","组长 onTouchEvent");
        return true;
    }

}
