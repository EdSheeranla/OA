package com.hjy.oa.action;

import com.hjy.oa.entity.Reply;
import com.hjy.oa.entity.Topic;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sheeran on 2017/4/12.
 */
@Component
@Scope("prototype")
public class ReplyAction extends BasicAction<Reply>{
    private int topicId;

    public String addUI() {
        Topic topic=topicService.findById(topicId);
        ActionContext.getContext().put("topic",topic);
        return "addUI";
    }


    public String add(){
        Topic topic=topicService.findById(topicId);
        model.setPushTime(new Date());
        model.setTopic(topic);
        model.setAuthor(getCurrentUser());
        model.setIpAddres(ServletActionContext.getRequest().getRemoteAddr());
        replyService.add(model);
        return "add";
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}
