package com.chatus.domain;

import com.chatus.base.BaseEntity;

/**
 * 好友信息
 * Created by gaopan on 16/6/4.
 */
public class Friends extends BaseEntity {

    /**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 67281534690175568L;

	/**
     * 用户id
     */
    private Integer fromId;

    /**
     * 朋友列表
     */
    private Integer toId;

	public Integer getFromId() {
		return fromId;
	}

	
	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	
	public Integer getToId() {
		return toId;
	}

	
	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public Friends() {}
}
