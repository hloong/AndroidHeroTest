package com.hloong.androidherotest.ui;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;

import com.hloong.androidherotest.util.LogUtil;

/**
 * Created by Administrator on 2016/4/29.
 */
public class TouchFlowView extends TextView {
    private int lastX,lastY;

    private Scroller mScroller;

    public TouchFlowView(Context context) {
        super(context);
        initView();
    }


    public TouchFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TouchFlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        View view = (View) getParent();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //以下2种情况都是随手指移动view
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                view.scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                mScroller.startScroll(view.getScrollX(),view.getScrollY(),-view.getScrollX(),-view.getScrollY(),3000);
                invalidate();
                break;
        }

        return true;
    }


    private void initView() {
        mScroller = new Scroller(getContext());

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollBy(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
}
