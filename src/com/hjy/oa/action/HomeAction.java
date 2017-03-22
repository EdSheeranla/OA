package com.hjy.oa.action;

import com.hjy.oa.entity.Privilege;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/3/20.
 */
@Component("homeAction")
@Scope("prototype")
public class HomeAction extends BasicAction<Privilege>{
    /**
     * 这里进入首页面；需要进行权限拦截
     */
    public String index(){


        return "index";
    }
    public String bottom(){
        return "bottom";
    }

    /**
     * 这里需要选出用户对应权限
     * @return
     */
    public String left() {
        List<Privilege> topPrivilegeList=privilegeService.findAllTop();
        ServletActionContext.getServletContext().setAttribute("topPrivilegeList",topPrivilegeList);
        return "left";
    }
    public String right(){
        return "right";
    }
    public String top(){
        return "top";
    }

}
