package com.hjy.oa.action;

import com.hjy.oa.entity.Position;
import com.hjy.oa.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("positionAction")
@Scope("prototype")
public class PositionAction extends BasicAction<Position>{

    public String list(){
        findAllPosition();
        return "list";
    }



    public String addUI(){
        return "addUI";
    }

    public String add(){
        if(model==null){
            this.addActionError("提交表单不能为空");
            return "addUI";
        }
        positionService.add(model);
        return "tolist";
    }

    public String del(){

        positionService.del(model);

        return "tolist";
    }

    public String editUI(){
        Position editPosition=positionService.findById(model.getPid());
        ActionContext.getContext().getValueStack().set("editPosition",editPosition);
        return "editUI";
    }

    public String edit(){

        positionService.update(model);
        return "tolist";
    }
}
