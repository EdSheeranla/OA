package com.hjy.oa.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by sheeran on 2017/3/20.
 */
public class HomeAction extends ActionSupport{
    public String index(){
        return "index";
    }
    public String bottom(){
        return "bottom";
    }
    public String left(){
        return "left";
    }
    public String right(){
        return "right";
    }
    public String top(){
        return "top";
    }

}
