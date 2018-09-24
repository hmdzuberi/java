package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

	@Override
	public int addMovie(Movie movie) {

		int rowAdded = 0;
		String sql = "insert into moviehz values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setLong(1, movie.getMovieID());
			pstmt.setString(2, movie.getMovieName());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getGenre());
			pstmt.setDouble(5, movie.getRating());

			rowAdded = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowAdded;
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeConnection() {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int remove(long movieID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRating(long movieID, double currentRating) {
		// TODO Auto-generated method stub
		return 0;
	}

}
