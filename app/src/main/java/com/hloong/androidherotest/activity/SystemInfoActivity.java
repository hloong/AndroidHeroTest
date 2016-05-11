package com.hloong.androidherotest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hloong.androidherotest.R;
import com.hloong.androidherotest.util.LogUtil;
import com.hloong.androidherotest.util.SystemInfoUtil;

public class SystemInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        TextView textView = (TextView) findViewById(R.id.text);
        String systemInfoStr = SystemInfoUtil.getBuildInfo();
        systemInfoStr += "-------------------------------------\r\n";
        systemInfoStr += SystemInfoUtil.getSystemPropertyInfo();
        textView.setText(systemInfoStr);
        LogUtil.d("SystemInfoActivity-->"+"onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("SystemInfoActivity-->"+"_onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d("SystemInfoActivity-->"+"onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("SystemInfoActivity-->"+"onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d("SystemInfoActivity-->"+"onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("SystemInfoActivity-->"+"onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("SystemInfoActivity-->"+"onPause");
    }


}
