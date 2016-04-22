package com.hloong.androidherotest.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/4/22.
 */
public class FeedBack extends BmobObject{
    private String feedback;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
