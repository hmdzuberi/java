package com.training;

import com.google.gson.Gson;

public class Application {

	public static void main(String[] args) {

		Gson obj = new Gson();

		Movie diamond = new Movie(101, "Diamond");

		String jsonRep = obj.toJson(diamond);

		System.out.println(jsonRep);

		Movie captured = obj.fromJson(jsonRep, Movie.class);

		System.out.println(captured.getMovieName());

		System.out.println(captured.getMovieID());
	}

}
