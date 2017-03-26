package com.hjy.oa.action;

import com.hjy.oa.entity.Position;
import com.hjy.oa.entity.Privilege;
import com.hjy.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        User user = (User) ActionContext.getContext().getSession().get("user");
    //        这个权限管理还没有做
//            List<Privilege> topPrivilegeList=privilegeService.findAllTopByName(user.getLoginname());
//        Set<Position> positionSet=user.getPositionSet();
//        for(Position postion : positionSet){
//            postion.getPrivilegeSet();
//            Privilege privilege=new Privilege();
//
//        }
        List<Privilege> topPrivilegeList=privilegeService.findAllTop();
        Set<Privilege> allUserPrivilege=new HashSet<Privilege>();
        for(Position position:user.getPositionSet()){
            allUserPrivilege=position.getPrivilegeSet();
        }
        ServletActionContext.getServletContext().setAttribute("allUserPrivilegeList",allUserPrivilege);
        return "left";
    }
    public String right(){
        return "right";
    }
    public String top(){
        return "top";
    }

}
