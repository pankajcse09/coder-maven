package com.coder.generic.dao;

import java.util.List;

import com.coder.exception.ApplicationException.DAOException;

public interface GenericDAO<T> {

	public void insert(T t) throws DAOException;

	public void insertNamedParameter(T t) throws DAOException;

	public void insertBatch(List<T> t) throws DAOException;

	public void insertBatchNamedParameter(List<T> t) throws DAOException;

	public void insertBatchSQL(String sql) throws DAOException;

	public T findById(int custId) throws DAOException;

	public List<T> findAll() throws DAOException;

	public String findNameById(int custId) throws DAOException;

	public int findTotalCount() throws DAOException;
}
