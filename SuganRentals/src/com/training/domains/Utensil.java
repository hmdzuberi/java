package com.training.domains;

public class Utensil extends Item {

	public Utensil() {
		super();
	}

	public Utensil(int itemQuantity, int rentalDuration) {
		super("Utensil", 15.0, itemQuantity, rentalDuration);
	}

}
