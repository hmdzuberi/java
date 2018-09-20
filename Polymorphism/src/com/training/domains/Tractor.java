package com.training.domains;

import com.training.ifaces.IAutomobile;

public class Tractor implements IAutomobile {

	@Override
	public String getModel() {
		return "John Deer";
	}

	@Override
	public String getColor() {
		return "Red";
	}

	@Override
	public double getPrice() {
		return 1300000.0;
	}

}
