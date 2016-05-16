package com.hloong.androidherotest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hloong.androidherotest.R;
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
        LogUtil.d("main-->"+"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("main-->"+"_onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d("main-->"+"onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("main-->"+"onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d("main-->"+"onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("main-->"+"onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("main-->"+"onPause");
    }

    private void initView() {
        view = (CircleProgressView) findViewById(R.id.cv);
        view.setSweepValue(120);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewActivity.class));
//                  saveBmob();
            }
        });
        findViewById(R.id.btn_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TouchActivity.class));
            }
        });
        findViewById(R.id.btn_palette).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BitmapActivity.class));
            }
        });
        findViewById(R.id.btn_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SystemInfoActivity.class));
            }
        });
        findViewById(R.id.btn_recycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
            }
        });
        findViewById(R.id.btn_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
            }
        });
        findViewById(R.id.btn_touch_flow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TouchFlowActivity.class));
            }
        });
        findViewById(R.id.btn_slide_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SlideMenuActivity.class));
            }
        });
        findViewById(R.id.btn_clock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ClockActivity.class));
            }
        });
        findViewById(R.id.btn_bitmap_canvas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BitmapCanvasActivity.class));
            }
        });
        findViewById(R.id.btn_matrix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MatrixActivity.class));
            }
        });
        findViewById(R.id.btn_circle_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CircleImageActivity.class));
            }
        });
        findViewById(R.id.btn_guaguaka).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GuaGuaKaActivity.class));
            }
        });
        findViewById(R.id.btn_shader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShaderActivity.class));
            }
        });
        findViewById(R.id.btn_shadow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShadowActivity.class));
            }
        });
        findViewById(R.id.btn_sin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SurfaceSinActivity.class));
            }
        });
        findViewById(R.id.btn_ani).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AnimationActivity.class));
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
