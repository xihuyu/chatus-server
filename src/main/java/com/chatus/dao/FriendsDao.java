package com.chatus.dao;

import com.chatus.base.dao.BaseDao;
import com.chatus.domain.Friends;

import java.util.List;

/**
 * 好友操作的dao
 * Created by gaopan on 16/6/5.
 */
public interface FriendsDao extends BaseDao<Friends> {

    /**
     * 根据用户id获取用户的好友的列表
     * @param id
     * @return
     */
    public List<Friends> getFriendsById(Integer id);
}
