package com.hloong.androidherotest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hloong.androidherotest.ui.ElasticityListView;
import com.hloong.androidherotest.util.LogUtil;

public class ListViewActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ElasticityListView mListView;
    private String[] mStr = new String[20];
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = (ElasticityListView) findViewById(R.id.listview);
        for (int i = 0; i < mStr.length; i++) {
            mStr[i] = "Item " + i;
        }
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material)));
        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(ListViewActivity.this,
                android.R.layout.simple_expandable_list_item_1,mStr));
//        mListView.setOnTouchListener(touchListener);
    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    LogUtil.d(mFirstY + "--"+mCurrentY+"--"+mTouchSlop);
                    if (mCurrentY -mFirstY > mTouchSlop) {
                        direction = 0;//向上滑动
                    }else if (mFirstY - mCurrentY > mTouchSlop){
                        direction = 1;//向下滑动
                    }
                    if (direction == 1){
                        if (mShow){
                            toolbarAnim(0);
                            mShow = !mShow;
                        }
                    }else if (direction == 0){
                        if (!mShow){
                            toolbarAnim(1);
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:

                    break;
            }
            return false;
        }
    };

    private void toolbarAnim(int i) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (i == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),0);
        }else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),-mToolbar.getHeight());
        }
        mAnimator.start();
    }
}
