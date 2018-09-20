package com.training.domains;

public class Company {

	public static void main(String[] args) {

		Employee newEmployee1 = new Employee();

		newEmployee1.setEmployeeAge(60);

		try {
			Employee newEmployee2 = new Employee(101, "Hamaad", 17);
		} catch (RangeCheckException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
