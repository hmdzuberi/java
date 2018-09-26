package com.training.entity;

import java.sql.SQLException;

public interface MovieDAO<T> extends DAO<T> {

	public int updateRating(long movieID, double currentRating) throws SQLException;

}
