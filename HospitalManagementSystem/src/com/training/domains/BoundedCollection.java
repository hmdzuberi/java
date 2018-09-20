package com.training.domains;

import java.util.ArrayList;
import java.util.List;

import com.training.insurance.Insurance;
import com.training.insurance.LifeInsurance;
import com.training.insurance.VehicleInsurace;

public class BoundedCollection {

	public static void main(String[] args) {

		LifeInsurance rakesh = new LifeInsurance(192939, "Rakesh", 14);

		List<LifeInsurance> life = new ArrayList<>();
		life.add(rakesh);

		display(life);

		VehicleInsurace marutiCar = new VehicleInsurace(4949229, "Suresh", "Car", 2017);

		List<VehicleInsurace> car = new ArrayList<>();
		car.add(marutiCar);

		display(car);
	}

	public static void display(List<? extends Insurance> insurance) {

		System.out.println(insurance.get(0).calculatePremium());
	}

}
