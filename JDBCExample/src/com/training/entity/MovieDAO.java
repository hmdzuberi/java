package com.training.entity;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {

	public int addMovie(Movie movie) throws SQLException;

	public Movie findByPrimaryKey(long movieID) throws SQLException;

	public List<Movie> findAll() throws SQLException;

	public int updateRating(long movieID, double currentRating) throws SQLException;

	public int remove(long movieID) throws SQLException;

}
