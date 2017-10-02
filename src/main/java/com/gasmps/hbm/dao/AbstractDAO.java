package com.gasmps.hbm.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

}
