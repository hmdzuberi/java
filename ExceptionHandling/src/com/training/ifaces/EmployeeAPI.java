package com.training.ifaces;

import java.util.List;

import com.training.domains.Employee;

public interface EmployeeAPI {

	public boolean add(Employee... employees);

	public List<Employee> findAll();

	public List<Employee> sortByAge();

	public List<Employee> sortByName();

}
