package com.chatus.dao;

import com.chatus.base.dao.BaseDao;
import com.chatus.domain.Message;
import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
public interface MessageDao extends BaseDao<Message> {

    /**
     * 根据发送消息和接受消息的人的id查询消息列表
     * @param fromId
     * @param toId
     * @return
     */
     public List<Message> findMessageByFromAndToIds(Integer fromId, Integer toId);
}
