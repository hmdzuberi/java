package com.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.training.domains.Employee;
import com.training.domains.EmployeeNameComparator;
import com.training.ifaces.EmployeeAPI;

public class EmployeeService implements EmployeeAPI {

	List<Employee> empList;

	public EmployeeService() {
		super();
		empList = new ArrayList<>();
	}

	@Override
	public boolean add(Employee... employees) {

		boolean result = false;
		for (Employee employee : employees) {
			result = empList.add(employee);
		}

		return result;
	}

	@Override
	public List<Employee> findAll() {
		return this.empList;
	}

	@Override
	public List<Employee> sortByAge() {

		Collections.sort(empList);
		return this.empList;
	}

	@Override
	public List<Employee> sortByName() {

		Collections.sort(empList, new EmployeeNameComparator());
		return this.empList;
	}

}
