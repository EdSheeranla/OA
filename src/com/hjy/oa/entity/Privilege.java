package com.hjy.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sheeran on 2017/3/20.
 * 权限实体
 */
public class Privilege {
    private int id;
    private String url;
    private String name;
    private String icon;
    private Set<Position> positionSet= new HashSet<Position>();
    private Privilege parent;
    private Set<Privilege> children =new HashSet<Privilege>();

    public Privilege() {
    }

    public Privilege(String name,String url,  String icon, Privilege parent) {
        this.url = url;
        this.name = name;
        this.icon = icon;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public Set<Privilege> getChildren() {
        return children;
    }

    public void setChildren(Set<Privilege> children) {
        this.children = children;
    }
}
