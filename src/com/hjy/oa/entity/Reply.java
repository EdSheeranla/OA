package com.hjy.oa.entity;

/**
 * Created by sheeran on 2017/3/26.
 */
public class Reply extends Article{
    private int id ;
    private Topic topic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
