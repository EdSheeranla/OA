package com.hjy.oa.action;

import com.hjy.oa.entity.Forum;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
@Component
@Scope("prototype")
public class ForumAction extends BasicAction<Forum> {

    public String list(){
        List<Forum> forumList=forumManageService.findAll();
        ActionContext.getContext().put("forumList",forumList);
        return "list";
    }

    /**
     * 查询指定Id的forum版块
     * @return
     */
    public String show(){
        Forum forum=forumService.findById(model.getId());
        ActionContext.getContext().put("forum",forum);
        return "show";
    }

}
