package com.hjy.oa.action;

import com.hjy.oa.entity.Department;
import com.hjy.oa.entity.Position;
import com.hjy.oa.entity.Privilege;
import com.hjy.oa.entity.User;
import com.hjy.oa.util.Mymd5;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by sheeran on 2017/3/18.
 */
@Component("userAction")
@Scope("prototype")
public class UserAction extends BasicAction<User> {
    private int did;

    private String pids;

    public void setPids(String pids) {
        this.pids = pids;
    }

    public void setDid(int did) {
        this.did = did;
    }

    /**
     * 向完成基础的添加操作，AJAX的异步校验之后在添加
     *
     * @return
     */
    public String add() {

        setDepartment();
        setPositionSet();
        generatePassword();
        userService.add(model);
        return "tolist";
    }

    public String initPassword() {
        User user=userService.findById(model.getUid());
        user.setPassword(Mymd5.doMD5("1234"));
        userService.update(user);
        return "tolist";
    }

    //初始化密码为1234;
    private void generatePassword() {
        model.setPassword(Mymd5.doMD5("1234"));
    }

    private void setDepartment() {
        Department department = departmentService.findById(did);
        /**
         * 这里添加和保存顺序？同样这里不需要添加和保存
         * org.hibernate.PersistentObjectException : uninitialized proxy passed to save()；
         * 这里错误的原因是由于数据库的mapping有问题
         */
        model.setDepartment(department);
    }

    private void setPositionSet() {
        String[] pidstr = pids.split(", ");
        for (String pid : pidstr) {
            System.out.println(pid);
            Position position = positionService.findById(Integer.parseInt(pid));
            /**
             * 这里添加和保存顺序？ 这里不需要添加和保存，贼蠢
             */
            model.getPositionSet().add(position);
        }
    }

    /**
     * 这里需要查出所有的岗位和部门
     *
     * @return
     */
    public String addUI() {
        findAllDepartment();
        findAllPosition();
        return "addUI";

    }

    public String list() {
        findAllUser();
        return "list";
    }

    /**
     *  AJAX异步校验用户名是否可用
     * @throws IOException
     */
    public String check() throws IOException {
        String loginname = model.getLoginname();
        User user = userService.checkloginname(loginname);
        if (user == null) {
            ServletActionContext.getResponse().getWriter().print("<font color='green'>登录名可以使用</font>");
        } else {
            try {
                ServletActionContext.getResponse().getWriter().print("<font color='red'>登录名已经被使用</font>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return NONE;
    }

    /**
     * 用户的登陆登出操作
     */
    public String loginUI(){
        return "loginUI";
    }
    public String login(){
        String password = model.getPassword();
        model.setPassword(Mymd5.doMD5(password));
        User user = userService.loginCheck(model);
        if(user==null){
            this.addActionError("用户名或者密码错误");
            return "loginUI";
        }
        ActionContext.getContext().getSession().put("user",user);
        return "login";

    }
    public String logout(){
        ActionContext.getContext().getSession().remove("user");
        return "logout";
    }
    public String edit() {
        return "tolist";
    }

    public String editUI() {
        return "editUI";
    }


}
