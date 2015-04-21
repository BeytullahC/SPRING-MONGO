package com.beto.project.sm.dao.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
	public T saveUser(T t) throws Exception;

	public T updateUser(T t) throws Exception;

	public boolean deleteUser(T t) throws Exception;

	public T findUser(Serializable id) throws Exception;

	public List<T> findAll() throws Exception;
}
