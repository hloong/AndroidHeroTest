package com.hloong.androidherotest.weibo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.hloong.androidherotest.R;

public class WeiboActivity extends AppCompatActivity {

	ImageView image;
	MoreWindow mMoreWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_weibo);

		image = (ImageView) findViewById(R.id.show);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showMoreWindow(v);
			}
		});
	}

	private void showMoreWindow(View view) {
		if (null == mMoreWindow) {
			mMoreWindow = new MoreWindow(this);
			mMoreWindow.init();
		}

		mMoreWindow.showMoreWindow(view,100);
	}
}
