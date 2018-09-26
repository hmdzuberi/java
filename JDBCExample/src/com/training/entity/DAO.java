package com.training.entity;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	public int add(T movie) throws SQLException;

	public T findByPrimaryKey(long movieID) throws SQLException;

	public List<T> findAll() throws SQLException;

	public int remove(long movieID) throws SQLException;

}
