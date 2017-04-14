package com.hjy.oa.action;

import com.hjy.oa.dto.PageBean;
import com.hjy.oa.entity.Reply;
import com.hjy.oa.entity.Topic;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by sheeran on 2017/4/9.
 */
@Component
@Scope("prototype")
public class TopicAction extends BasicAction<Topic> {
    private static final int PAGE_SIZE = 8;  //每页显示的数目
    private int forumId;
    private int pageNow;
    private int op;

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    /**
     * 显示指定id的版块下的帖子
     * @return
     */
    public String show() {
        Topic topic = topicService.findById(model.getId());
        PageBean<Reply> pageBean = new PageBean<Reply>(pageNow,PAGE_SIZE);
        pageBean=replyService.findByPage(pageBean,model);
        ActionContext.getContext().put("pageBean",pageBean);
        ActionContext.getContext().put("topic", topic);
        return "show";
    }

    public String addUI() {
        ActionContext.getContext().put("forum", forumService.findById(forumId));
        return "addUI";
    }

    public String add() {
        model.setForum(forumManageService.findById(forumId));
        model.setPushTime(new Date());
        model.setAuthor(getCurrentUser());
        model.setIpAddres(ServletActionContext.getRequest().getRemoteAddr());
        topicService.add(model);
        return "add";
    }
    public String modifyType(){
        topicService.modifyType(model,op);
        return "modify";
    }

}
