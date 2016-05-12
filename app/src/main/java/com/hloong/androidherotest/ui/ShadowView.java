package com.hloong.androidherotest.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.R;

/**
 * Created by Administrator on 2016/5/9.
 */
public class ShadowView extends View {
    private PorterDuffXfermode mXfermode;
    private Paint paint;
    private Bitmap mSrcBitmap,mShaBitmap;//原图，阴影图

    public ShadowView(Context context) {
        super(context);
        initView(context);
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmapcanvas);
        Matrix matrix = new Matrix();
        matrix.setScale(1F,-1F);
        mShaBitmap = Bitmap.createBitmap(mSrcBitmap,0,0,mSrcBitmap.getWidth(),mSrcBitmap.getHeight(),matrix,true);

        paint = new Paint();
        paint.setShader(new LinearGradient(0,mSrcBitmap.getHeight(),0,mSrcBitmap.getHeight()+mSrcBitmap.getHeight()/4,0XDD00000,0X10000000, Shader.TileMode.CLAMP));
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(mSrcBitmap,0,0,null);
        canvas.drawBitmap(mShaBitmap,0,mSrcBitmap.getHeight(),null);
        paint.setXfermode(mXfermode);
        //绘制渐变效果矩形
        canvas.drawRect(0,mSrcBitmap.getHeight(),mShaBitmap.getWidth(),mSrcBitmap.getHeight()* 2,paint);
        paint.setXfermode(null);
    }


}
