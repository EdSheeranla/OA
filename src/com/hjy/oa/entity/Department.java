package com.hjy.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sheeran on 2017/3/17.
 */
public class Department {
    private int did;
    private String name;
    private String description;
    private Department parent;
    private Set<Department>  children=new HashSet<Department>();
    private Set<User> userSet =new HashSet<User>();

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
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

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Set<Department> getChildren() {
        return children;
    }

    public void setChildren(Set<Department> children) {
        this.children = children;
    }
}
