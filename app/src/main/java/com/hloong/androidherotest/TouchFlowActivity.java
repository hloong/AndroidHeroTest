package com.hloong.androidherotest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class TouchFlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_flow);
        ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.bitmap);

    }
}
