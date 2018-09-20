package com.training.domains;

import com.training.ifaces.IAutomobile;

public class QuoteManager {

	public void printQuote(IAutomobile polyAuto) {

		if (polyAuto != null) {
			System.out.println(polyAuto.getModel());
			System.out.println(polyAuto.getColor());
			System.out.println(polyAuto.getPrice());
		} else {
			System.out.println("Choice sould be 1 or 2. Try Again.");
		}

	}

	/**
	 * @param key
	 *            Represents the key value 1-3 for the AutoMobile
	 * 
	 * @return The subType of Automobile, a class implementing IAutomobile
	 *         Interface
	 */
	public IAutomobile getModel(int key) {

		switch (key) {
		case 1:
			return new MarutiCar();
		case 2:
			return new BajajBike();
		default:
			return null;
		}

	}

}
