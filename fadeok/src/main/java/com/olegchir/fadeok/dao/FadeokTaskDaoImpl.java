package com.olegchir.fadeok.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import com.olegchir.fadeok.model.FadeokTask;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by olegchir on 19.06.2015.
 */
@Repository
public class FadeokTaskDaoImpl extends BasicDaoImpl<FadeokTask, Long> implements FadeokTaskDao {

}
