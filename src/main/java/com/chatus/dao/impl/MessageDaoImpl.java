package com.chatus.dao.impl;

import com.chatus.base.dao.impl.BaseDaoImpl;
import com.chatus.domain.Message;
import com.chatus.util.CommonUtil;
import com.chatus.dao.MessageDao;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

    public List<Message> findMessageByFromAndToIds(Integer fromId, Integer toId) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("fromId", fromId);
        params.put("toId", toId);
        List<Message> messages = super.getSessionTemplate().selectList(CommonUtil.getStatementId(Message.class, "findMessageById"), params);
        return messages;
    }
}
