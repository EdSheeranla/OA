package com.hjy.oa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sheeran on 2017/3/17.
 */
public class Position implements Serializable {
    private int pid;
    private String name;
    private String description;
    private Set<User> userSet=new HashSet<User>();
    private Set<Privilege> privilegeSet=new HashSet<Privilege>();

    public Set<Privilege> getPrivilegeSet() {
        return privilegeSet;
    }

    public void setPrivilegeSet(Set<Privilege> privilegeSet) {
        this.privilegeSet = privilegeSet;
    }

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
