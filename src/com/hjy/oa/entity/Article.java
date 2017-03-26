package com.hjy.oa.entity;

import java.util.Date;

/**
 * Created by sheeran on 2017/3/26.
 */
public class Article {
    private int id;
    private String content;
    private Date pushTime;
    private String ipAddres;
    private String emoji;
    private User author;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getIpAddres() {
        return ipAddres;
    }

    public void setIpAddres(String ipAddres) {
        this.ipAddres = ipAddres;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
