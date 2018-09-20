package com.training;

import java.util.List;

import com.training.domains.Employee;
import com.training.domains.RangeCheckException;

public class CollectionApplication {

	public static void main(String[] args) {

		try {

			Employee suresh = new Employee(101, "Stalin", 42);
			Employee sudeesh = new Employee(102, "Hitler", 45);
			Employee sumesh = new Employee(103, "Mao", 50);

			EmployeeService empService = new EmployeeService();

			// empService.add(suresh);
			// empService.add(sudeesh);
			// empService.add(sumesh);
			empService.add(suresh, sudeesh, sumesh);

			// List<Employee> empList = empService.findAll();
			Employee.sortOrder = "asc";

			List<Employee> empList = empService.sortByAge();
			// empList.forEach(System.out::println);
			printEmployee(empList);

			System.out.println();

			List<Employee> empListByName = empService.sortByName();
			// empListByName.forEach(System.out::println);
			printEmployee(empListByName);

		} catch (RangeCheckException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public static void printEmployee(List<Employee> empList) {
		empList.forEach(System.out::println);
	}

}
