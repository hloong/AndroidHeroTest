package com.hloong.androidherotest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.Window;

public class BitmapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        initView();
    }

    private void initView() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
        //创建Palette对象
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getMutedSwatch();
                if (vibrant != null) {
                    getActionBar().setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));
                    Window window = getWindow();
                    window.setStatusBarColor(vibrant.getRgb());
                }
            }
        });
    }
}
