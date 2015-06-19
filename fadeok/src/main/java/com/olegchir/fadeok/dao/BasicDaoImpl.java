package com.olegchir.fadeok.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Repository
public class BasicDaoImpl<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Autowired
    public void setSearchProcessor(JPASearchProcessor searchProcessor) {
        super.setSearchProcessor(searchProcessor);
    }
}
