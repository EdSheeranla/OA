package com.hjy.oa.intercepter;

import com.hjy.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by sheeran on 2017/3/22.
 */
public class PrivilegeInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user= (User) ActionContext.getContext().getSession().get("user");
        String url=null;
//        actionInvocation.getProxy().getNamespace();
        actionInvocation.getProxy().getActionName();
        if(user==null){
            if(url.startsWith("user_loginUI"));
        }else
        {

            return actionInvocation.invoke();
        }
        return null;
    }
}
