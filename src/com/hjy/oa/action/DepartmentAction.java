package com.hjy.oa.action;

import com.hjy.oa.entity.Department;
import com.hjy.oa.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sheeran on 2017/3/18.
 */
@Component("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    private DepartmentService departmentService;
    private int parentid;

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    @Resource
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private Department department = new Department();

    public String list() {
        findAll();
        return "list";
    }

    public String addUI() {
        findAll();
        return "addUI";
    }

    private void findAll() {
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("departmentList", departmentList);
    }

    public String add() {
        Department parent=departmentService.finById(parentid);
        department.setParent(parent);
        departmentService.add(department);
        return "tolist";
    }

    public String editUI(){
        Department editDepartment=departmentService.finById(department.getDid());
        findAll();
        ActionContext.getContext().getValueStack().set("editDepartment",editDepartment);
        return "editUI";
    }
    @Override
    public Department getModel() {
        return department;
    }
}
