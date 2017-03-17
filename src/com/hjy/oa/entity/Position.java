package com.hjy.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sheeran on 2017/3/17.
 */
public class Position {
    private int pid;
    private String name;
    private String description;
    private Set<User> userSet=new HashSet<User>();

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
