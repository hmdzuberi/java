package com.training;

import java.sql.SQLException;
import java.util.List;

import com.training.dao.impl.MovieDAOImpl;
import com.training.entity.Movie;
import com.training.entity.MovieDAO;
import com.training.utils.DbConnection;

public class Application {

	public static void main(String[] args) {

		System.out.println(DbConnection.getOracleConnection());

		int key = 5;
		MovieDAO dao = new MovieDAOImpl();

		try {
			switch (key) {
			case 1:
				Movie gold = new Movie(101, "Gold", "Reema Kagti", "Historical", 4.8);
				Movie sholay = new Movie(103, "Sholay", "Ramesh Sippy", "Action-Adventure", 4.9);

				int rowAdded = dao.addMovie(gold);
				rowAdded += dao.addMovie(sholay);

				System.out.println(rowAdded + ": Row Added");

				break;

			case 2:
				List<Movie> movieList = dao.findAll();

				movieList.forEach(System.out::println);

				break;

			case 3:
				Movie movie = dao.findByPrimaryKey(101);

				System.out.println(movie);

				break;

			case 4:
				int rowDeleted = dao.remove(103);

				System.out.println(rowDeleted + ": Row Deleted");

				break;

			case 5:
				int rowUpdated = dao.updateRating(101, 5);

				System.out.println(rowUpdated + ": Row updated");

				break;

			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		MovieDAOImpl obj = (MovieDAOImpl) dao;
		obj.closeConnection();

	}

}
