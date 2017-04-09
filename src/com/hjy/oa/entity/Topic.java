package com.hjy.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sheeran on 2017/3/26.
 */
public class Topic extends Article{
    private static final int TYPE_NORMAL=0;
    private static final int TYPE_WONDFUL=1;
    private static final int TYPE_TOP=2;
    private int id;
    private int type;
    private int replyCount;
    private Date lasetUpdate;
    private Set<Reply> replySet=new HashSet<Reply>();
    private Forum forum;
    private Reply lastReply;

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Date getLasetUpdate() {
        return lasetUpdate;
    }

    public void setLasetUpdate(Date lasetUpdate) {
        this.lasetUpdate = lasetUpdate;
    }

    public Set<Reply> getReplySet() {
        return replySet;
    }

    public void setReplySet(Set<Reply> replySet) {
        this.replySet = replySet;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
