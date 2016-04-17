package com.hloong.androidherotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hloong.androidherotest.ui.CircleProgressView;

public class MainActivity extends AppCompatActivity {
    private CircleProgressView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (CircleProgressView) findViewById(R.id.cv);
        view.setSweepValue(120);
    }
}
