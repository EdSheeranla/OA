package com.hjy.oa.action;

import com.hjy.oa.entity.Position;
import com.hjy.oa.entity.Privilege;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sheeran on 2017/3/17.
 */
@Component("positionAction")
@Scope("prototype")
public class PositionAction extends BasicAction<Position> {
    private int[] privilegeIds;

    public int[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(int[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    public String list() {
        findAllPosition();
        return "list";
    }


    public String addUI() {
        return "addUI";
    }

    public String add() {
        if (model == null) {
            this.addActionError("提交表单不能为空");
            return "addUI";
        }
        positionService.add(model);
        return "tolist";
    }

    public String del() {
        positionService.del(model);
        return "tolist";
    }

    public String editUI() {
        Position editPosition = positionService.findById(model.getPid());
        return "editUI";
    }

    public String edit() {
        positionService.update(model);
        return "tolist";
    }

    public String privilegeUI() {
        Position position = positionService.findById(model.getPid());
        ActionContext.getContext().put("position", position);

        List<Privilege> topPrivilegeList = privilegeService.findAllTop();
        ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);

        // 准备回显的数据
        privilegeIds = new int[position.getPrivilegeSet().size()];
        int index = 0;
        for (Privilege privilege : position.getPrivilegeSet()) {
            privilegeIds[index++] = privilege.getId();
        }
        return "privilegeUI";
    }

    public String savePrivilege() {
//        System.out.println(model.getPid());
        Position position = positionService.findById(model.getPid());
        List<Privilege> privilegeList = new ArrayList<Privilege>();
        for (int id : privilegeIds) {
            Privilege privilege = privilegeService.findById(id);
            privilegeList.add(privilege);
        }
        position.setPrivilegeSet(new HashSet<Privilege>(privilegeList));
        positionService.update(position);
        return "tolist";
    }
}
