package com.hjy.oa.action;

import com.hjy.oa.entity.Department;
import com.hjy.oa.entity.Position;
import com.hjy.oa.entity.Privilege;
import com.hjy.oa.entity.User;
import com.hjy.oa.service.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by sheeran on 2017/3/20.
 * 将Action中的共有属性和方法进行抽取，但是不知道是不是要做成abstract，反射才会生效
 * 不需要做成abstract也能有效
 */
public class BasicAction<T> extends ActionSupport implements ModelDriven {

    @Resource
    protected UserService userService;

    @Resource
    protected PositionService positionService;

    @Resource
    protected DepartmentService departmentService;

    @Resource
    protected PrivilegeService privilegeService;

    @Resource
    protected ForumManageService forumManageService;

    @Resource
    protected ForumService forumService;

    @Resource
    protected TopicService topicService;
    protected T model;

    public BasicAction() {
        Class clazz = null;
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) pt.getActualTypeArguments()[0];
        try {
            model = (T) clazz.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void findAllPosition() {
        java.util.List<Position> positionList=positionService.findAll();
        ActionContext.getContext().getValueStack().set("positionList",positionList);
    }
    protected void findAllDepartment() {
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("departmentList", departmentList);
    }


    protected void findAllUser() {
        List<User> userList=userService.findAll();
        ActionContext.getContext().getValueStack().set("userList",userList);
    }

    protected void findAllPrivilege(){
        List<Privilege> privilegeList=privilegeService.findAll();
        ActionContext.getContext().getValueStack().set("privilegeList",privilegeList);
    }

//    protected  void findAll
    @Override
    public Object getModel() {
        return model;
    }
}
