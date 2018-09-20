package com.training;

import java.util.HashMap;

import com.training.domains.Employee;
import com.training.domains.RangeCheckException;

public class MapExample {

	public static void main(String[] args) {

		HashMap<Integer, Employee> empList = new HashMap<>();

		try {

			Employee sumesh = new Employee(200, "Sumesh", 42);
			Employee anand = new Employee(201, "Anand", 32);
			Employee baskar = new Employee(202, "Baskar", 22);

			empList.put(1, sumesh);
			empList.put(2, anand);
			empList.put(3, baskar);

			System.out.println(empList.get(1));

		} catch (RangeCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
