package com.training.domains;

import java.io.File;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		Address address1 = new Address("Gandhi Street", "Nehru Nagar", "Chennai", 600117);
		Customer customer1 = new Customer(101, "Ramesh Babu", address1, 1231231234);

		ObjectHandling handler = new ObjectHandling();

		// boolean result = handler.saveObject(customer1);
		// System.out.println(result);

		// Customer customer2 = (Customer) handler.loadObject();
		// System.out.println(customer2);

		// boolean status = handler.writeToTextFile(customer1);
		//
		// if (status) {
		// System.out.println("File Created");
		//
		// } else {
		// System.out.println("Error - See Error Log");
		// }

		List<Customer> customerList = handler.readFromTextFile(new File("Customer.txt"));
		System.out.println(customerList);

	}

}
