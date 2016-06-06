package com.chatus.domain;

import com.chatus.base.BaseEntity;

/**
 * 用户对象
 * Created by gaopan on 16/6/4.
 */
public class User extends BaseEntity {

    /**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1503182757927426294L;

	/**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public User() {}
}
