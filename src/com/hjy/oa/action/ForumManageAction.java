package com.hjy.oa.action;

import com.hjy.oa.entity.Forum;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/3/26.
 */
@Component("forumManageAction")
@Scope("prototype")
public class ForumManageAction extends BasicAction<Forum>{
    public String list(){
        List<Forum> forumList=forumManageService.findAll();
        ActionContext.getContext().getValueStack().set("forumList",forumList);
        return "list";
    }
    public String add(){
        forumManageService.add(model);
        return "tolist";
    }
    public String addUI(){
        return "addUI";
    }
    public String del(){
        return "del";
    }

    public String moveUp(){
        Forum forum=forumManageService.findById(model.getId());
        forumManageService.moveUp(forum);
        return "tolist";

    }
    public String moveDown(){
        Forum forum=forumManageService.findById(model.getId());
        forumManageService.moveDown(forum);
        return "tolist";
    }
}
