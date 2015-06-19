package com.olegchir.fadeok.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.olegchir.fadeok.model.FadeokTask;
import com.olegchir.fadeok.model.FadeokUser;
import org.springframework.stereotype.Repository;

@Repository
public interface FadeokUserDao extends GenericDAO<FadeokUser, Long> {

}
