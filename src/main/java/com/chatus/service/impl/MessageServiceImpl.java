package com.chatus.service.impl;

import com.chatus.dao.MessageDao;
import com.chatus.domain.Message;
import com.chatus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public void insert(Message message) {
        messageDao.insert(message);
    }

    public List<Message> getMessageListByIds(Integer fromId, Integer toId) {
        return messageDao.findMessageByFromAndToIds(fromId, toId);
    }
}
