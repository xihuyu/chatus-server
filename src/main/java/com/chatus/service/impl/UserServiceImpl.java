package com.chatus.service.impl;

import com.chatus.dao.UserDao;
import com.chatus.domain.User;
import com.chatus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaopan on 16/6/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void insert(User user) {
        userDao.insert(user);
    }

    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }
    
    public User findUserById(Integer userId) {
    	return userDao.findUserById(userId);
    }
}
