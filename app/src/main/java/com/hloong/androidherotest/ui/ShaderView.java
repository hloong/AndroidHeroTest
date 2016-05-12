package com.hloong.androidherotest.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.R;

/**
 * Created by Administrator on 2016/5/9.
 */
public class ShaderView extends View {
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private Paint paint;

    public ShaderView(Context context) {
        super(context);
    }

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        mBitmapShader = new BitmapShader(mBitmap,Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(mBitmapShader);
        canvas.drawCircle(500,250,200,paint);
    }


}
