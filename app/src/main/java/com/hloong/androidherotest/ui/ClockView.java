package com.hloong.androidherotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.hloong.androidherotest.util.DisplayUtil;

/**
 * Created by Administrator on 2016/5/4.
 */
public class ClockView extends View{
    private Paint paint,degreePaint,paintHour,paintMinute,paintLayer;
    public ClockView(Context context) {
        super(context);
    }


    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initDraw(canvas);
    }


    private void initDraw(Canvas canvas) {
        int width = DisplayUtil.getWidth(getContext());
        int height = DisplayUtil.getHeight(getContext());

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawCircle(width/2,height/2,width/2,paint);

        paintHour = new Paint();
        paintHour.setAntiAlias(true);
        paintHour.setStrokeWidth(20);
        paintHour.setStyle(Paint.Style.STROKE);


        paintMinute = new Paint();
        paintMinute.setAntiAlias(true);
        paintMinute.setStrokeWidth(10);
        canvas.save();//保存画布
        canvas.translate(width/2,height/2);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMinute);
        canvas.restore();

        degreePaint = new Paint();
        degreePaint.setStyle(Paint.Style.FILL);
        degreePaint.setAntiAlias(true);
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i == 3 || i == 6 | i == 9) {
                degreePaint.setStrokeWidth(5);
                degreePaint.setTextSize(30);
                canvas.drawLine(width/2,height/2-width/2,width/2,height/2-width/2+60,degreePaint);
                String degree = ""+i;
                if (i == 0){
                    degree = ""+12;
                }
                canvas.drawText(degree,width/2 - degreePaint.measureText(degree),height/2-width/2+90,degreePaint);
            }else {
                degreePaint.setStrokeWidth(3);
                degreePaint.setTextSize(15);
                canvas.drawLine(width/2,height/2-width/2,width/2,height/2-width/2+30,degreePaint);
                String degree = ""+i;
                canvas.drawText(degree,width/2 - degreePaint.measureText(degree),height/2-width/2+60,degreePaint);
            }
            canvas.rotate(30,width/2,height/2);//旋转画布
        }

        paintLayer = new Paint();
        paintLayer.setColor(Color.BLUE);
        canvas.drawCircle(100,100,100,paintLayer);
        canvas.saveLayerAlpha(0,0,250,250,127,Canvas.FULL_COLOR_LAYER_SAVE_FLAG);
        paintLayer.setColor(Color.CYAN);
        canvas.drawCircle(150,150,100,paintLayer);
        canvas.restore();//合并图层


        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setRotate(0,150);
        colorMatrix.setRotate(1,150);
        colorMatrix.setRotate(2,150);
    }
}
