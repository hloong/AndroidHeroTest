package com.hloong.androidherotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
    }
}
