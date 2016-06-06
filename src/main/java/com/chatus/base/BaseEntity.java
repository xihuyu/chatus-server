package com.chatus.base;

import java.io.Serializable;

/**
 * 基础信息实体类
 * Created by gaopan on 16/6/4.
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
