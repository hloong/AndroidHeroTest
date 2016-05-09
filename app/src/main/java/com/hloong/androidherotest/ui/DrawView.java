package com.hloong.androidherotest.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/3.
 */
public class DrawView extends View{
    private Paint paint;
    public DrawView(Context context) {
        super(context);
        initView();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint();
//        paint.setAntiAlias(ture);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("ceshi",10,10,paint);
//        canvas.drawArc(0,0,100,100,0,360,true,paint);
        canvas.drawArc(new RectF(),0,180,true,paint);
        canvas.drawCircle(50,50,20,paint);
    }
}
