package com.hloong.androidherotest.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.hloong.androidherotest.util.LogUtil;

/**
 * Created by Administrator on 2016/4/29.
 */
public class TouchFlowView extends View {
    private int lastX,lastY;
    public TouchFlowView(Context context) {
        super(context);
    }

    public TouchFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchFlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                LogUtil.d("X-->"+x+"--Y--"+y);
                LogUtil.d("lastX-->"+lastX+"--lastY--"+lastY);
                LogUtil.d("offX-->"+offsetX+"--offY--"+offsetY);
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

}
