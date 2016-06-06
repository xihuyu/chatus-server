package com.chatus.service.impl;

import com.chatus.dao.FriendsDao;
import com.chatus.domain.Friends;
import com.chatus.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
@Service("friendsService")
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsDao friendsDao;

    public void insert(Friends friends) {
        friendsDao.insert(friends);
    }

    public List<Friends> findFriends(Integer uId) {
        return friendsDao.getFriendsById(uId);
    }
}
