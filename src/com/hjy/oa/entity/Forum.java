package com.hjy.oa.entity;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sheeran on 2017/3/26.
 * 论坛版块管理
 */
public class Forum {
    private int id;
    private String name;
    private String description;
    private int articleCount;
    private int topicCount;
    private Topic lastTopic;
    private Set<Topic> topicSet =new HashSet<Topic>();

    public Set<Topic> getTopicSet() {
        return topicSet;
    }

    public void setTopicSet(Set<Topic> topicSet) {
        this.topicSet = topicSet;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public Topic getLastTopic() {
        return lastTopic;
    }

    public void setLastTopic(Topic lastTopic) {
        this.lastTopic = lastTopic;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 当增加一个新的topic的时候，更新forum中的topic
     * @param topic
     */
    public void updateLastTopic(Topic topic) {
        if(topic==null) throw new IllegalArgumentException("topic can`t be Null");
        this.setArticleCount(this.getArticleCount()+1);
        this.setTopicCount(this.getTopicCount()+1);
        this.setLastTopic(topic);
    }
}
