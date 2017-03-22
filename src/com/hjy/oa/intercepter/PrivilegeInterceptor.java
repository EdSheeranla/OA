package com.hjy.oa.intercepter;

import com.hjy.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by sheeran on 2017/3/22.
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user= (User) ActionContext.getContext().getSession().get("user");
        return user==null ? "loginUI": actionInvocation.invoke() ;
    }
}
