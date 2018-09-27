package com.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Application {

	public static void main(String[] args) {

		try {
			Class<?> cls = Class.forName("com.training.Movie");
			Movie diamond = (Movie) cls.newInstance();

			diamond.setMovieID(203);
			diamond.setMovieName("Titanic");
			System.out.println(diamond);

			Constructor<?>[] constructorList = cls.getDeclaredConstructors();
			for (Constructor<?> constructor : constructorList) {
				System.out.println("Name: " + constructor.getName());
				System.out.println("Parameter Count: " + constructor.getParameterCount());
			}

			Method addRatingMethod = cls.getDeclaredMethod("addRating", int.class);
			System.out.println("Add Rating Method Reference: " + addRatingMethod);

			String result = (String) addRatingMethod.invoke(cls, new Integer(20));
			System.out.println(result);

			Method[] methodList = cls.getDeclaredMethods();
			for (Method eachMethod : methodList) {
				System.out.println(eachMethod.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
