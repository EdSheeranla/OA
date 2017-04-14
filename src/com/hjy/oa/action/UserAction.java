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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String add() {
        setDepartment();
        setPositionSet();
        model.setPassword(Mymd5.doMD5("1234"));
        userService.add(model);
        return "tolist";
    }

    public String initPassword() {
        User user=userService.findById(model.getUid());
        user.setPassword(Mymd5.doMD5("1234"));
        userService.update(user);
        return "tolist";
    }


    private void setDepartment() {
        Department department = departmentService.findById(did);
        model.setDepartment(department);
    }

    private void setPositionSet() {
        String[] pidstr = pids.split(", ");
        for (String pid : pidstr) {
            System.out.println(pid);
            Position position = positionService.findById(Integer.parseInt(pid));
            model.getPositionSet().add(position);
        }
    }

    /**
     * 这里需要查出所有的岗位和部门
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
        model.setPassword(Mymd5.doMD5(model.getPassword()));
        User user = userService.loginCheck(model);
        if(user==null){
            this.addActionError("用户名或者密码错误");
            return "loginfail";
        }else{
            if(isExist(user)) {
                this.addActionError("不能重复登陆");
                return "loginfail";
            }
            addOnlineNum(user);
            ActionContext.getContext().getSession().put("user",user);
            return "login";

        }

    }

    /**
     * 采用抢占式的用户防止重复登陆
     * 对于当前登陆用户是否已经登陆了进行校验,将用户的登陆姓名和登陆时间保存
     * 但是和显示当前登陆的用户名称这个功能右冲突
     * @param user
     * @return
     */
    private boolean isExist(User user){

        User existUser = (User) ActionContext.getContext().getSession().get("user");
        if(existUser==null) return false;
        else {
            if (existUser.getLoginname().equals(user.getLoginname())) return true;
            else return false;
        }
    }
    private void addOnlineNum(User user) {
        Map<String,Date> onlineUser = new HashMap<String,Date>();
        onlineUser.put(user.getLoginname(),new Date());
        ServletActionContext.getServletContext().setAttribute("onlineUser",onlineUser);
//        Object attr=ServletActionContext.getServletContext().getAttribute("onlineNum");
//
//        if(attr!=null)    ServletActionContext.getServletContext().setAttribute("onlineNum",(int)attr+1);
//        else              ServletActionContext.getServletContext().setAttribute("onlineNum",1);
    }

    public String logout(){
        ActionContext.getContext().getSession().remove("user");
        lessOnlineNum();
        return "logout";
    }

    /**
     * 更改在线人数，但是这里有一个bug，同一个用户多次进行登陆的时候，在线人数就会混乱
     * 怎样识别同一个电脑上登陆了两个不同的用户：采用Session，第二个登陆的y用户会将前一个用户的session进行覆盖
     */
    private void lessOnlineNum(){

        int onlineNum= (int) ServletActionContext.getServletContext().getAttribute("onlineNum");
        System.out.println(onlineNum);
        ServletActionContext.getServletContext().setAttribute("onlineNum",onlineNum-1);
    }

    public String edit() {
        return "tolist";
    }

    public String editUI() {
        return "editUI";
    }


}
