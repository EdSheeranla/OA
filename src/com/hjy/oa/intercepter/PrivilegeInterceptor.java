package com.hjy.oa.intercepter;

import com.hjy.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by sheeran on 2017/3/22.
 * todo 怎么感觉加了拦截器之后响应速度变慢了
 */
public class PrivilegeInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user= (User) ActionContext.getContext().getSession().get("user");
        String url= actionInvocation.getProxy().getActionName();

        if(user==null){
            if(url.startsWith("user_loginUI")||url.startsWith("user_login")){
                return actionInvocation.invoke();
            }else{
                return "login";
            }
        }else
        {
            return actionInvocation.invoke();
        }

    }
}
