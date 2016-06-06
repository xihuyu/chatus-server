package com.chatus.dao.impl;

import com.chatus.base.dao.impl.BaseDaoImpl;
import com.chatus.dao.FriendsDao;
import com.chatus.domain.Friends;
import com.chatus.util.CommonUtil;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaopan on 16/6/5.
 */
@Repository("friendsDao")
public class FriendsDaoImpl extends BaseDaoImpl<Friends> implements FriendsDao {

    public List<Friends> getFriendsById(Integer id) {
        return super.getSessionTemplate().selectList(CommonUtil.getStatementId(Friends.class, "findUserByUserId"), id);
    }
}
