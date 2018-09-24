package com.training.domains;

public class Furniture extends Item {

	public Furniture() {
		super();
	}

	public Furniture(int itemQuantity, int rentalDuration) {
		super("Furniture", 75.0, itemQuantity, rentalDuration);
	}

}
