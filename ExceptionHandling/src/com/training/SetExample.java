package com.training;

import java.util.Set;
import java.util.TreeSet;

import com.training.domains.Employee;

public class SetExample {

	public static void main(String[] args) {

		try {

			Employee sumesh = new Employee(200, "Sumesh", 42);
			Employee anand = new Employee(201, "Anand", 32);
			Employee baskar = new Employee(202, "Baskar", 22);

			Employee.sortOrder = "asc";
			Set<Employee> empList = new TreeSet<>();

			System.out.println(empList.add(sumesh));
			System.out.println(empList.add(anand));
			System.out.println(empList.add(baskar));
			System.out.println(empList.add(sumesh));

			empList.forEach(System.out::println);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
