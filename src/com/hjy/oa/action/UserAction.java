package com.hjy.oa.action;

import com.hjy.oa.entity.User;
import com.hjy.oa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by sheeran on 2017/3/18.
 */
public class UserAction extends ActionSupport implements ModelDriven{
    private UserService userService;
    private User user= new User();

    public String add(){
        return "tolist";
    }
    public String addUI(){
        return "addUI";
    }

    public String list(){
        return "list";
    }


    public String edit(){
        return "tolist";
    }
    public String editUI(){
        return "editUI";
    }
    @Override
    public Object getModel() {
        return user;
    }
}
