package com.hjy.oa.entity;

/**
 * Created by sheeran on 2017/3/26.
 * 论坛版块管理
 */
public class Forum {
    private int id;
    private String name;
    private String description;

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

}
