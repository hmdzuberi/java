package com.training.entity;

import java.util.List;

public interface MovieDAO {

	public int addMovie(Movie movie);

	public List<Movie> findAll();

	public int remove(long movieID);

	public int updateRating(long movieID, double currentRating);

}
