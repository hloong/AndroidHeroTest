package com.hloong.androidherotest.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.hloong.androidherotest.R;

public class BitmapCanvasActivity extends AppCompatActivity {
    private float hue ,sat ,lum ;
    private SeekBar sbHue,sbSat,sbLum;
    private ImageView imageView;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_canvas);
        initView();
    }

    private void initView() {
        sbHue = (SeekBar) findViewById(R.id.sb_hue);
        sbSat = (SeekBar) findViewById(R.id.sb_sat);
        sbLum = (SeekBar) findViewById(R.id.sb_lum);
        imageView = (ImageView)findViewById(R.id.imageView);

        sbHue.setOnSeekBarChangeListener(sb);
        sbSat.setOnSeekBarChangeListener(sb);
        sbLum.setOnSeekBarChangeListener(sb);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bitmapcanvas);

        sbHue.setMax(MAX_VALUE);
        sbSat.setMax(MAX_VALUE);
        sbLum.setMax(MAX_VALUE);

        sbHue.setProgress(MID_VALUE);
        sbSat.setProgress(MID_VALUE);
        sbLum.setProgress(MID_VALUE);
        imageView.setImageBitmap(bitmap);
    }

    SeekBar.OnSeekBarChangeListener sb = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()) {
                case R.id.sb_hue:
                    hue = (progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                    break;
                case R.id.sb_sat:
                    sat = progress * 1.0F / MID_VALUE;
                    break;
                case R.id.sb_lum:
                    lum = progress * 1.0F / MID_VALUE;
                    break;
            }
            imageView.setImageBitmap(effect(bitmap, hue, sat, lum));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public static Bitmap effect(Bitmap bm,float hue,float sat,float lum){
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix satMatrix = new ColorMatrix();
        satMatrix.setSaturation(sat);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(satMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bm,0,0,paint);

        return bmp;
    }

}
