package com.chatus.domain;

import com.chatus.base.BaseEntity;

/**
 * 消息实体类
 * Created by gaopan on 16/6/4.
 */
public class Message extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 发送消息的人
     */
    private Integer fromId;

    /**
     * 接收消息的人的id
     */
    private Integer toId;

    /**
     * 消息的内容
     */
    private String message;

    public Message(){}

    public Integer getFromId() {
        return fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public String getMessage() {
        return message;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
