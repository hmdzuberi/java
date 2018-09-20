package com.training.insurance;

public class InsuranceAgent {
	
	// Parameter passing -> instead SuperType can also pass SubType 
	public static void findPremium(Insurance insurance) {
		System.out.println(insurance.calculatePremium());
	}
	
	public static void main(String[] args) {
		
		VehicleInsurace pulsarBike = new VehicleInsurace(393939, "Ramesh", "Bike", 2013);
		findPremium(pulsarBike);
		
		// superClassType = subClassType
		Insurance marutiCar = new VehicleInsurace(494949, "Suresh", "Car", 2017);
		findPremium(marutiCar);
		
		// Life Insurance
		LifeInsurance xyz = new LifeInsurance(123123, "Hamaad", 21);
		findPremium(xyz);

	}

}
