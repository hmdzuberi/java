package com.training.domains;

import com.training.ifaces.IAutomobile;

public class BajajBike implements IAutomobile {

	@Override
	public String getModel() {
		return "Pulsar";
	}

	@Override
	public String getColor() {
		return "Blue";
	}

	@Override
	public double getPrice() {
		return 125000.0;
	}

}
