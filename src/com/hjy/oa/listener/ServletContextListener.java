package com.hjy.oa.listener;

import com.hjy.oa.entity.Privilege;
import com.hjy.oa.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.List;

/**
 * Created by sheeran on 2017/3/22.
 *
 * 这个listener没有用处，没有将需要的数据单放置到我需要的地方，可以删除
 */
public class ServletContextListener implements javax.servlet.ServletContextListener{
    private ApplicationContext ac=null;
    private PrivilegeService privilegeService=null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();

        // 得到Service的实例对象
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
        PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");

        // 准备所有顶级权限的集合（顶级菜单）
        List<Privilege> topPrivilegeList = privilegeService.findAllTop();
        application.setAttribute("topPrivilegeList", topPrivilegeList);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
