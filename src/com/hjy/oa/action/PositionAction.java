package com.hjy.oa.action;

import com.hjy.oa.entity.Position;
import com.hjy.oa.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("positionAction")
@Scope("prototype")
public class PositionAction extends ActionSupport {
    private PositionService positionService;
    private Position position;

    public String list(){
        java.util.List<Position> positionList=positionService.findAll();
        ActionContext.getContext().getValueStack().set("positionList",positionList);
        return "list";
    }

    public String addUI(){
        return "addUI";
    }

    public String add(){

        positionService.add(position);
        return "tolist";
    }

    public String del(){
        return "del";
    }

    public String editUI(){
        return "editUI";
    }

    public String edit(){

        return "tolist";
    }
    @Resource
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
