package com.hjy.oa.action;

import com.hjy.oa.entity.Department;
import com.hjy.oa.entity.Position;
import com.hjy.oa.entity.User;
import com.hjy.oa.util.Mymd5;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
     * @return
     */
    public String add() {

        setDepartment();
        setPositionSet();
        generatePassword();
        userService.add(model);
        return "tolist";
    }

    public String initPassword(){
        generatePassword();
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
        String[] pidstr = pids.split("\\, ");
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
    public String edit() {
        return "tolist";
    }

    public String editUI() {
        return "editUI";
    }


}
