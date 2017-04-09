package com.hjy.oa.action;

import com.hjy.oa.entity.Topic;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by sheeran on 2017/4/9.
 */
public class TopicAction extends BasicAction<Topic> {
    /**
     * 查询指定id的Topic
     * @return
     */
    public String show(){
        Topic topic=topicService.findById(model.getId());
        ActionContext.getContext().getValueStack().push(topic);
        return "show";
    }
}
