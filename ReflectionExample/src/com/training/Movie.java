package com.training;

public class Movie {

	private long movieID;
	private String movieName;

	public Movie() {
		super();
	}

	public Movie(long movieID, String movieName) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
	}

	public long getMovieID() {

		return movieID;
	}

	public void setMovieID(long movieID) {

		this.movieID = movieID;
	}

	public String getMovieName() {

		return movieName;
	}

	public void setMovieName(String movieName) {

		this.movieName = movieName;
	}

	@Override
	public String toString() {

		return "Movie [movieID=" + movieID + ", movieName=" + movieName + "]";
	}

}
