package com.hloong.androidherotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.util.AppUtil;

/**
 * Created by hl on 16/4/8.
 */
public class CircleProgressView extends View {
    private Paint mCircle;
    private int mCircleXY;
    private float mRadius;

    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCircleXY = AppUtil.getWidth(getContext())/2;
        mRadius = (float) (AppUtil.getWidth(getContext()) * 0.5 / 2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
