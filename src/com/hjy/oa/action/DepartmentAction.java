package com.hjy.oa.action;

import com.hjy.oa.entity.Department;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/3/18.
 */
@Component("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BasicAction<Department>{
    private int parentid;

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String list() {
        findAllDepartment();
        return "list";
    }

    public String addUI() {
        findAllDepartment();
        return "addUI";
    }


    public String add() {
        Department parent=departmentService.findById(parentid);
        model.setParent(parent);
        departmentService.add(model);
        return "tolist";
    }

    /**
     * 这里需要进行级联删除
     */
    public String del(){
        departmentService.del(model.getDid());

        return "tolist";
    }
    public String editUI(){
        Department editDepartment=departmentService.findById(model.getDid());
        findAllDepartment();
        ActionContext.getContext().getValueStack().set("editDepartment",editDepartment);
        return "editUI";
    }

}
