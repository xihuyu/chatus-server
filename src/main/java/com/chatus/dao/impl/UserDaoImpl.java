package com.chatus.dao.impl;

import com.chatus.base.dao.impl.BaseDaoImpl;
import com.chatus.dao.UserDao;
import com.chatus.domain.User;
import com.chatus.util.CommonUtil;

import org.springframework.stereotype.Repository;

/**
 * Created by gaopan on 16/6/5.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public User findUserByName(String uName) {
    	String statementId = CommonUtil.getStatementId(User.class, "findUserByName");
        return super.getSessionTemplate().selectOne(statementId, uName);
    }

	public User findUserById(Integer userId) {
		String statementId = CommonUtil.getStatementId(User.class, "findUserById");
		return super.getSessionTemplate().selectOne(statementId, userId);
	}
}
