package com.hloong.androidherotest.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.hloong.androidherotest.R;
import com.hloong.androidherotest.util.LogUtil;

public class AnimationActivity extends AppCompatActivity {
    private TextView tv;
    private Button btnPostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        tv = (TextView)findViewById(R.id.tvAni);
        btnPostion = (Button)findViewById(R.id.btPosition);

        findViewById(R.id.btAlpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation animation = new AlphaAnimation(0,1);
                animation.setDuration(2000);
                tv.startAnimation(animation);
            }
        });
        findViewById(R.id.btPosition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TranslateAnimation animation = new TranslateAnimation(0,300,0,300);
//                animation.setDuration(2000);
//                tv.startAnimation(animation);
//                objAni();
                propertyAni();
            }
        });
        findViewById(R.id.btScale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ScaleAnimation animation = new ScaleAnimation(0,2,0,2);
//                animation.setDuration(2000);
//                tv.startAnimation(animation);
                scaleX(tv);
            }
        });
        findViewById(R.id.btRotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RotateAnimation animation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5F,RotateAnimation.RELATIVE_TO_SELF,0.5F);
//                animation.setDuration(2000);
//                tv.startAnimation(animation);
                ani3(tv);
            }
        });



    }

    private void objAni(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"translationX",300);
        animator.setDuration(1000);
        animator.start();
    }

    private void propertyAni(){
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("ScaleX",1f,0,1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("ScaleY",1f,0,1f);
        ObjectAnimator.ofPropertyValuesHolder(tv,pvh2,pvh3).setDuration(1000).start();
    }

    private void valueAni(){
        ValueAnimator animator = ValueAnimator.ofFloat(0,100);
        animator.setTarget(tv);
        animator.setDuration(1000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float)animation.getAnimatedValue();

            }
        });


    }

    private void listenerAni(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"Alpha",0.5f);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

        });
    }

    private void animatorSet(){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tv,"translationX",300f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(tv,"scaleX",1f,0f,1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(tv,"scaleY",1f,0f,1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animator1,animator2,animator3);
        set.start();
    }


    private void scaleX(View view){
        Animator anim = AnimatorInflater.loadAnimator(this,R.animator.scalex);
        anim.setTarget(view);
        anim.start();
    }

    private void ani3(View view){
        view.animate().alpha(0).y(300).setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("start-->");
            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("start-->");
            }
        });
    }
}
