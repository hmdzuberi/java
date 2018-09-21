package com.training.domains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {

		Restaurant restaurant1 = new Restaurant("Kamat Restaurant", "Bangalore", 1231231234, 4);
		Restaurant restaurant2 = new Restaurant("Social", "Delhi", 1231231234, 5);
		Restaurant restaurant3 = new Restaurant("Cafe and Co", "Mumbai", 1231231234, 3);

		// System.out.println(writeToTextFile(restaurant1));
		// System.out.println(writeToTextFile(restaurant2));
		// System.out.println(writeToTextFile(restaurant3));

		TreeSet<Restaurant> restaurantSet = readFromTextFile(new File("Restaurants.txt"));

		for (Restaurant restaurant : restaurantSet) {
			System.out.println(restaurant.getRestaurantName() + " " + restaurant.getRating());
		}

	}

	public static boolean writeToTextFile(Restaurant restaurant) {

		boolean result = false;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileWriter(new File("Restaurants.txt"), true));
			writer.println(restaurant.toString());
			result = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			writer.close();
		}

		return result;
	}

	public static TreeSet<Restaurant> readFromTextFile(File file) {

		TreeSet<Restaurant> restaurantSet = new TreeSet<>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String restaurantAsString;

			while ((restaurantAsString = reader.readLine()) != null) {

				String[] items = restaurantAsString.split(",");

				Restaurant restaurant = new Restaurant(items[0], items[1], Long.parseLong(items[2]),
						Double.parseDouble(items[3]));

				restaurantSet.add(restaurant);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return restaurantSet;
	}

}
