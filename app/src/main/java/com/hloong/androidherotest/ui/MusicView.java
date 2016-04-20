package com.hloong.androidherotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.R;

/**
 * Created by hl on 16/4/17.
 */
public class MusicView extends View {
    private int mRectCount=10;
    private int mRectWidth;
    private int mRectHeight;
    private int offset=4;
    private float currentHeight;
    private Paint mPaint;
    private int mWidth;

    public MusicView(Context context) {
        super(context);
        initView();
    }

    public MusicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MusicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int)(mWidth * 0.6 / mRectCount);
        //增加一个渐变效果
        LinearGradient mLinearGradient = new LinearGradient(0,0,mRectWidth,mRectHeight, Color.YELLOW,Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0;i<mRectCount;i++){
            currentHeight = (float)(mRectHeight * Math.random());
            canvas.drawRect((float)(mWidth * 0.4 / 2 + mRectWidth*i + offset),
                    currentHeight,(float)(mWidth * 0.4 / 2 + mRectWidth*(i + 1)),
                    mRectHeight,mPaint);
        }
        postInvalidateDelayed(200);
    }
}
