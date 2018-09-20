package com.training.domains;

public class Application {

	public static void main(String[] args) {

		Address address1 = new Address("Gandhi Street", "Nehru Nagar", "Chennai", -600117);
		Address address2 = new Address("Rajiv Street", "Indira Nagar", "Chennai", 500007);

		Customer ramesh1 = new Customer(101, "Ramesh Babu", address1, 12341234);
		Customer ramesh2 = new Customer(101, "Ramesh Babu", address2, 12341234);

		ramesh2 = null;
		// System.gc();

		System.out.println("Are they equal: " + ramesh1.equals(ramesh2));

		Customer ramesh3 = null;

		System.out.println("Is it not Cautious: " + ramesh1.equals(ramesh3));

		String ramesh4 = "Ramesh";

		System.out.println("Checking differant type: " + ramesh1.equals(ramesh4));
		System.out.println("Checking identity: " + ramesh1.equals(ramesh1));

		try {
			ramesh1.getAddress().setPinCode(-5050);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
