package com.hloong.androidherotest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BitmapActivity extends Activity {
    TextView textView1;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        initView();
    }

    private void initView() {
        textView1 = (TextView) findViewById(R.id.tv1);
        TextView textView2 = (TextView) findViewById(R.id.tv1);
        TextView textView3 = (TextView) findViewById(R.id.tv1);

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

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    textView1.animate().translationZ(100);
                    flag = false;
                }else {
                    textView1.animate().translationZ(0);
                    flag = true;
                }
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
