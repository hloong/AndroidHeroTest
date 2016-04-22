package com.hloong.androidherotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hloong.androidherotest.bean.FeedBack;
import com.hloong.androidherotest.ui.CircleProgressView;
import com.hloong.androidherotest.util.LogUtil;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    private CircleProgressView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"94b9fa26a58b3a875c121e0a274083cd");
        initView();
    }

    private void initView() {
        view = (CircleProgressView) findViewById(R.id.cv);
        view.setSweepValue(120);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,ViewActivity.class));
                  saveBmob();
            }
        });
        findViewById(R.id.btn_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TouchActivity.class));
            }
        });
    }

    /**
     * 保存数据到bmob后台
     */
    private void saveBmob(){
        FeedBack data = new FeedBack();
        data.setName("hloong");
        data.setFeedback("测试Bmob");
        data.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                LogUtil.d("保存成功");

            }

            @Override
            public void onFailure(int i, String s) {
                LogUtil.d("保存失败");
            }
        });
    }

}
