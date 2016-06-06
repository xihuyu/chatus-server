package com.chatus.base.dao.impl;

import com.chatus.base.BaseEntity;
import com.chatus.base.dao.BaseDao;
import com.chatus.constant.StatementConstant;
import com.chatus.util.CommonUtil;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gaopan on 16/6/5.
 */
public class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void insert(T entity) {
        sqlSessionTemplate.insert(CommonUtil.getStatementId(this.getClass(), StatementConstant.INSERT));
    }

    public T getById(Integer id) {
        return null;
    }

    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    public SqlSessionTemplate getSessionTemplate() {
        return sqlSessionTemplate;
    }
}
