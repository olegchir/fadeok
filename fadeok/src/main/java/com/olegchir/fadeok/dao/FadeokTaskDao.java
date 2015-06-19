package com.olegchir.fadeok.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.olegchir.fadeok.model.FadeokTask;
import org.springframework.stereotype.Repository;

@Repository
public interface FadeokTaskDao extends GenericDAO<FadeokTask, Long> {

}
