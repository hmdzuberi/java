package com.training.domains;

public class Car extends Item {

	public Car() {
		super();
	}

	public Car(int itemQuantity, int rentalDuration) {
		super("Car", 150.0, itemQuantity, rentalDuration);
	}

}
