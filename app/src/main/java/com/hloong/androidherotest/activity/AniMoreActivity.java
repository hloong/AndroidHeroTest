package com.hloong.androidherotest.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hloong.androidherotest.R;

import java.util.ArrayList;
import java.util.List;

public class AniMoreActivity extends AppCompatActivity {
    private int[] mRes = {R.id.imageView_a, R.id.imageView_b, R.id.imageView_c,
            R.id.imageView_d, R.id.imageView_e};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();
    private boolean mFlag = true;

    private TextView tvAni;


    private LinearLayout mHiddenView,mShowView;
    private float mDensity;
    private int mHiddenViewMeasuredHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_more);
        for (int i = 0; i < mRes.length; i++) {
            ImageView imageView = (ImageView) findViewById(mRes[i]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.imageView_a:
                            if (mFlag) {
                                startAnim();
                            } else {
                                closeAnim();
                            }
                            break;
                        default:
                            Toast.makeText(AniMoreActivity.this, "" + v.getId(),
                                    Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            mImageViews.add(imageView);
        }

        tvAni = (TextView)findViewById(R.id.tvAniNo);
        tvAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
                valueAnimator.addUpdateListener(
                        new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                tvAni.setText("$ " +(Integer) animation.getAnimatedValue());
                            }
                        });
                valueAnimator.setDuration(3000);
                valueAnimator.start();
            }
        });

        mHiddenView = (LinearLayout) findViewById(R.id.hidden_view);
        mShowView = (LinearLayout) findViewById(R.id.show_view);
        // 获取像素密度
        mDensity = getResources().getDisplayMetrics().density;
        // 获取布局的高度
        mHiddenViewMeasuredHeight = (int) (mDensity * 40 + 0.5);
        mShowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHiddenView.getVisibility() == View.GONE) {
                    // 打开动画
                    animateOpen();
                } else {
                    // 关闭动画
                    animateClose();
                }
            }
        });
    }
    private void closeAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),"alpha", 0.5F, 1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),"translationY", 200F, 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),"translationX", 200F, 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),"translationY", -200F, 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),"translationX", -200F, 0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
        mFlag = true;
    }

    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),"alpha",1F,0.5F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),"translationY",200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),"translationX",200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),"translationY",-200F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),"translationX",-200F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
        mFlag = false;
    }


    private void animateOpen() {
        mHiddenView.setVisibility(View.VISIBLE);
        ValueAnimator animator = createDropAnimator(
                mHiddenView,
                0,
                mHiddenViewMeasuredHeight);
        animator.start();
    }

    private void animateClose() {
        int origHeight = mHiddenView.getHeight();
        ValueAnimator animator = createDropAnimator(mHiddenView, origHeight, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                mHiddenView.setVisibility(View.GONE);
            }
        });
        animator.start();
    }

    private ValueAnimator createDropAnimator(
            final View view, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int value = (Integer) valueAnimator.getAnimatedValue();
                        ViewGroup.LayoutParams layoutParams =
                                view.getLayoutParams();
                        layoutParams.height = value;
                        view.setLayoutParams(layoutParams);
                    }
                });
        return animator;
    }
}
