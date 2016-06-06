package com.chatus.service;

import com.chatus.domain.Message;
import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
public interface MessageService {

    /**
     * 保存消息
     * @param message
     */
    public void insert(Message message);

    /**
     * 查询用户和好友的聊天记录列表
     * @param fromId
     * @param toId
     * @return
     */
    public List<Message> getMessageListByIds(Integer fromId, Integer toId);
}
