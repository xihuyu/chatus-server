package com.chatus.base.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * 基础的dao方法涵盖了所有基本数据库表操作的方法
 * Created by gaopan on 16/6/5.
 */
public interface BaseDao<T> {

    /**
     * 插入实体类
     * @param entity
     */
    void insert(T entity);

    /**
     * 根据id 查询对象
     * @param id
     * @return
     */
    T  getById(Integer id);

    public SqlSessionTemplate getSessionTemplate();

    public SqlSession getSqlSession();
}
