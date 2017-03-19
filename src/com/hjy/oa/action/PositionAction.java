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
public class PositionAction extends ActionSupport implements ModelDriven<Position> {
    private PositionService positionService;
    private Position position=new Position();

    public String list(){
        java.util.List<Position> positionList=positionService.findAll();
        ActionContext.getContext().getValueStack().set("positionList",positionList);
        return "list";
    }

    public String addUI(){
        return "addUI";
    }

    public String add(){
        if(position==null){
            this.addActionError("提交表单不能为空");
            return "addUI";
        }
        positionService.add(position);
        return "tolist";
    }

    public String del(){

        positionService.del(position);

        return "tolist";
    }

    public String editUI(){
        Position editPosition=positionService.findById(position.getPid());
        ActionContext.getContext().getValueStack().set("editPosition",editPosition);
        return "editUI";
    }

    public String edit(){

        positionService.edit(position);
        return "tolist";
    }
    @Resource
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @Override
    public Position getModel() {
        return position;
    }
}
