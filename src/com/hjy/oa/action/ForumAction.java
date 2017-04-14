package com.hjy.oa.action;

import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Forum;
import com.hjy.oa.entity.Topic;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
@Component
@Scope("prototype")
public class ForumAction extends BasicAction<Forum> {
    private int pageNow;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    private static final int PAGESIZE =25;
    public String list() {
        List<Forum> forumList = forumManageService.findAll();
        ActionContext.getContext().put("forumList", forumList);
        return "list";
    }

    /**
     * 查询指定Id的forum版块
     * @return
     */
    public String show() {
        Forum forum = forumService.findById(model.getId());
        ActionContext.getContext().put("forum", forum);
        //分页查找指定id的topic集合
        PageBean<Topic> pageBean=new PageBean<Topic>(pageNow,PAGESIZE);
        pageBean=topicService.findByPage(model,pageBean);

        ActionContext.getContext().put("pageBean",pageBean);
        return "show";
    }

}
