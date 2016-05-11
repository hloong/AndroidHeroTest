package com.hloong.androidherotest.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.R;

/**
 * Created by Administrator on 2016/5/9.
 */
public class CricleImageView extends View {
    private Bitmap mBitmap,mOut;
    private Paint paint;

    public CricleImageView(Context context) {
        super(context);
        initView();
    }

    public CricleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CricleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mOut, 0, 0, null);
    }

    /**
     *
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bitmapcanvas);


        mOut = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mOut);

        paint = new Paint();
        paint.setAntiAlias(true);

        canvas.drawRoundRect(0,0,mBitmap.getWidth(),mBitmap.getHeight(),80,80,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBitmap,0,0,paint);
    }

}
