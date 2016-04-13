package com.hloong.androidherotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.util.AppUtil;

/**
 * Created by hl on 16/4/8.
 */
public class CircleProgressView extends View {
    private int mMeasureH;
    private int mMeasureW;

    private float mRadius;
    private float mCircleXY;
    private float mSweepAngle;
    private float mShowTextSize;
    private float mSweepValue = 66;

    private Paint mCircle;
    private Paint mArcPaint;
    private RectF mArcRectF;
    private Paint mTextPaint;

    private String mShowText;

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
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mCircle);
        canvas.drawArc(mArcRectF,270,mSweepAngle,false,mArcPaint);
        canvas.drawText(mShowText,0,mShowText.length(),mCircleXY,
                mCircleXY + (mShowTextSize /4),mTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasureW = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureH = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureW,mMeasureH);
        initView();

    }

    private void initView() {
        float length = mMeasureH >= mMeasureW ? mMeasureW : mMeasureH;
        mCircleXY = length / 2;
        mRadius = (float)(length * 0.5 /2);
        mCircle = new Paint();
        mCircle.setAntiAlias(true);
        mCircle.setColor(getResources().getColor(android.R.color.holo_blue_bright));

        mArcRectF = new RectF((float) (length * 0.1), (float) (length * 0.1),
                (float) (length * 0.9),(float) (length * 0.9));
        mSweepAngle = (mSweepValue / 100f) * 360f;

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mArcPaint.setStrokeWidth((float)(length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);

        mShowText = setShowText();
        mShowTextSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private String setShowText(){
        this.invalidate();
        return "Android Skill";
    }

    private float setShowTextSize() {
        this.invalidate();
        return 50;
    }

    public void forceInvalidate() {
        this.invalidate();
    }

    public void setSweepValue(float sweepValue){
        if (sweepValue != 0){
            mSweepValue = sweepValue;
        }else{
            mSweepValue = 25;
        }
        this.invalidate();
    }
}
