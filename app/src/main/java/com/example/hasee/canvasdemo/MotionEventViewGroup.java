package com.example.hasee.canvasdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 老大
 */
public class MotionEventViewGroup extends LinearLayout {
    public MotionEventViewGroup(Context context) {
        super(context);
    }

    public MotionEventViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("111","老大 MotionEventViewGroupA dispatchTouchEventA");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("111","老大 onInterceptHoverEvent");
        return super.onInterceptTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("111","老大 onTouchEvent");
        return super.onTouchEvent(event);
    }
}
