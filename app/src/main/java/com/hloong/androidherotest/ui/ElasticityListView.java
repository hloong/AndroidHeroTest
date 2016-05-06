package com.hloong.androidherotest.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/4/29.
 * 弹性的listview
 */
public class ElasticityListView extends ListView {

    private static int mMaxOverDistance = 100;
    public ElasticityListView(Context context) {
        super(context);
    }


    public ElasticityListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ElasticityListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
}
