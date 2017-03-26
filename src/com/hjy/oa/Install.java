package com.hjy.oa;

import com.hjy.oa.entity.Privilege;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by sheeran on 2017/3/21.
 * 进行安装操作，初始化数据
 */
@Component
@Transactional
public class Install {
    private HibernateTemplate hibernateTemplate;

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void install() {
//        Privilege sysytemPri=new Privilege("系统管理",null,"FUNC20082.gif",null);
//        Privilege positionPri=new Privilege("岗位管理","/position_list",null,sysytemPri);
//        Privilege userPri=new Privilege("用户管理","/user_list",null,sysytemPri);
//        Privilege departmentPri=new Privilege("部门管理","/department_list",null,sysytemPri);
//
//        hibernateTemplate.save(sysytemPri);
//        hibernateTemplate.save(positionPri);
//        hibernateTemplate.save(userPri);
//        hibernateTemplate.save(departmentPri);
//
//        User admin=new User();
//        admin.setLoginname("admin");
//        admin.setPassword(Mymd5.doMD5("admin"));
//        admin.setName("超级管理员");
//
//        hibernateTemplate.save(admin);
//
//        hibernateTemplate.save(new Privilege("岗位列表", "position_list", null, positionPri));
//        hibernateTemplate.save(new Privilege("岗位增加", "postion_add", null, positionPri));
//        hibernateTemplate.save(new Privilege("岗位删除", "position_del", null, positionPri));
//        hibernateTemplate.save(new Privilege("岗位修改", "position_edit", null, positionPri));
//
//        hibernateTemplate.save(new Privilege("用户列表","user_list",null,userPri));
//        hibernateTemplate.save(new Privilege("用户增加","user_add",null,userPri));
//        hibernateTemplate.save(new Privilege("用户删除","user_del",null,userPri));
//        hibernateTemplate.save(new Privilege("用户修改","user_edit",null,userPri));
//
//        hibernateTemplate.save(new Privilege("部门列表","department_list",null,departmentPri));
//        hibernateTemplate.save(new Privilege("部门增加","department_add",null,departmentPri));
//        hibernateTemplate.save(new Privilege("部门删除","department_del",null,departmentPri));
//        hibernateTemplate.save(new Privilege("部门修改","department_edit",null,departmentPri));
        Privilege menu = new Privilege("网上交流", null, "FUNC20064.gif", null);
        Privilege menu1 = new Privilege("论坛管理", "forumManageAction_list", null, menu);
        Privilege menu2 = new Privilege("论坛", "forumAction_list", null, menu);
        hibernateTemplate.save(menu);
        hibernateTemplate.save(menu1);
        hibernateTemplate.save(menu2);

    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Install is = (Install) ac.getBean("install");
        is.install();
    }
}
