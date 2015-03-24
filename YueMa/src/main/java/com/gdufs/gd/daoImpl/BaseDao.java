package com.gdufs.gd.daoImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {
	public BaseDao() {
		super();
	}

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
