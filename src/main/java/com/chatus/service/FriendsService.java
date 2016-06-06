package com.chatus.service;

import com.chatus.domain.Friends;

import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
public interface FriendsService {

    /**
     * 插入列表
     * @param friends
     */
    public void insert(Friends friends);

    /**
     * 查询用户的好友列表
     * @param uId
     * @return
     */
    public List<Friends> findFriends(Integer uId);
}
