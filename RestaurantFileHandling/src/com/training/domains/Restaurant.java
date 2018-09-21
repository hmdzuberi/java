package com.training.domains;

import java.io.Serializable;

public class Restaurant implements Serializable, Comparable<Restaurant> {

	private static final long serialVersionUID = 1L;
	private String restaurantName;
	private String location;
	private long phoneNumber;
	private double rating;

	public Restaurant() {

		super();
	}

	public Restaurant(String restaurantName, String location, long phoneNumber, double rating) {

		super();
		this.restaurantName = restaurantName;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {

		return restaurantName + "," + location + "," + phoneNumber + "," + rating;
	}

	@Override
	public int compareTo(Restaurant other) {

		if (this.rating > other.rating)
			return -1;
		else if (this.rating < other.rating)
			return 1;
		else
			return 0;
	}

}
