package com.training;

public class QuickStart {

	public String getMessage() {

		return "Hello".toUpperCase();
	}

	public double calculateDiscount(double amount) throws RuntimeException {

		double discount;

		if (amount < 0) {
			throw new RuntimeException();
		} else if (amount < 5000) {
			discount = 0.10;
		} else {
			discount = 0.15;
		}

		return discount;
	}

}
