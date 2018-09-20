package com.training.domains;

import com.training.ifaces.IAutomobile;

public class MarutiCar implements IAutomobile {

	@Override
	public String getModel() {
		return "Swift Dzire";
	}

	@Override
	public String getColor() {
		return "Silver";
	}

	@Override
	public double getPrice() {
		return 700000.0;
	}

}
