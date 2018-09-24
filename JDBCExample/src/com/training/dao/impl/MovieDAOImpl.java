package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Movie;
import com.training.entity.MovieDAO;
import com.training.utils.DbConnection;

public class MovieDAOImpl implements MovieDAO {

	private Connection con;

	public MovieDAOImpl() {
		super();

		con = DbConnection.getOracleConnection();
	}

	private Movie convertToObject(ResultSet rs) throws SQLException {

		long movieID = rs.getLong("movieID");
		String movieName = rs.getString("movieName");
		String director = rs.getString("director");
		String genre = rs.getString("genre");
		double rating = rs.getDouble("rating");

		return new Movie(movieID, movieName, director, genre, rating);
	}

	@Override
	public Movie findByPrimaryKey(long movieID) throws SQLException {
	
		Movie movie = null;
		String sql = "select * from moviehz where movieID = ?";
		PreparedStatement pstmnt = null;
	
		pstmnt = con.prepareStatement(sql);
		pstmnt.setLong(1, movieID);
	
		ResultSet rs = pstmnt.executeQuery();
	
		if (rs.next()) {
	
			movie = convertToObject(rs);
		}
	
		pstmnt.close();
	
		return movie;
	}

	@Override
	public List<Movie> findAll() throws SQLException {

		Movie movie = null;
		List<Movie> movieList = new ArrayList<>();
		String sql = "select * from moviehz";
		PreparedStatement pstmnt = null;

		pstmnt = con.prepareStatement(sql);

		ResultSet rs = pstmnt.executeQuery();

		while (rs.next()) {

			movie = convertToObject(rs);

			movieList.add(movie);
		}

		pstmnt.close();

		return movieList;
	}

	@Override
	public int addMovie(Movie movie) throws SQLException {
	
		int rowAdded = 0;
		String sql = "insert into moviehz values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
	
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, movie.getMovieID());
		pstmt.setString(2, movie.getMovieName());
		pstmt.setString(3, movie.getDirector());
		pstmt.setString(4, movie.getGenre());
		pstmt.setDouble(5, movie.getRating());
	
		rowAdded = pstmt.executeUpdate();
	
		pstmt.close();
	
		return rowAdded;
	}

	@Override
	public int updateRating(long movieID, double currentRating) throws SQLException {

		int movieUpdated = 0;
		String sql = "update moviehz set rating = ? where movieID = ?";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, currentRating);
		pstmt.setLong(2, movieID);

		movieUpdated = pstmt.executeUpdate();

		pstmt.close();

		return movieUpdated;
	}

	@Override
	public int remove(long movieID) throws SQLException {

		int rowDeleted = 0;
		String sql = "delete from moviehz where movieID = ?";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, movieID);

		rowDeleted = pstmt.executeUpdate();

		pstmt.close();

		return rowDeleted;
	}

	public void closeConnection() {
	
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
