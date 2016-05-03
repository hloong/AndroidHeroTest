package com.hloong.androidherotest.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/29.
 */
public class ViewDrag extends FrameLayout {
    private ViewDragHelper mHelper;
    private View mMainView,mMenuView;//定义2个子布局
    private int mWidth;
    public ViewDrag(Context context) {
        super(context);
        initView();
    }


    public ViewDrag(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ViewDrag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将触摸事件传递给ViewDragHelper
        mHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mHelper.shouldInterceptTouchEvent(ev);
    }

    private void initView() {
        mHelper = ViewDragHelper.create(this,callback);
    }

    @Override
    public void computeScroll() {
        if (mHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mMainView == child;
        }
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return super.clampViewPositionVertical(child, top, dy);
        }

        // 触摸到View后回调
        @Override
        public void onViewCaptured(View capturedChild,
                                   int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }

        // 当拖拽状态改变，比如idle，dragging
        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        // 当位置改变的时候调用,常用与滑动时更改scale等
        @Override
        public void onViewPositionChanged(View changedView,
                                          int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if (mMainView.getLeft() < 500){
                //关闭菜单，相当于Scroller的startScroll方法
                mHelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(ViewDrag.this);
            }else {
                //打开菜单
                mHelper.smoothSlideViewTo(mMainView,300,0);
                ViewCompat.postInvalidateOnAnimation(ViewDrag.this);
            }
        }
    };

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mMenuView.getMeasuredWidth();
    }
}
