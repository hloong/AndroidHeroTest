package com.hloong.androidherotest.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.hloong.androidherotest.util.LogUtil;

/**
 * Created by Administrator on 2016/4/21.
 */
public class ViewABChild extends View {

    public ViewABChild(Context context) {
        super(context);
    }

    public ViewABChild(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewABChild(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.d("ViewABChild-dispatchTouchEvent"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.d("ViewABChild-onTouchEvent"+event.getAction());
        return super.onTouchEvent(event);
    }
}
