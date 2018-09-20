package com.training.domains;

public class Employee implements Comparable<Employee> {

	private int employeeNumber;
	private String employeeName;
	private int employeeAge;
	public static String sortOrder;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeNumber, String employeeName, int employeeAge) throws RangeCheckException {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;

		if (employeeAge < 18 || employeeAge > 58) {
			throw new RangeCheckException("Range not valid. Age should be between 18-58.");
		} else {
			this.employeeAge = employeeAge;
		}

		this.employeeAge = employeeAge;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {

		try {
			if (employeeAge < 18 || employeeAge > 58) {
				throw new RangeCheckException("Range not valid. Age should be between 18-58.");
			} else {
				this.employeeAge = employeeAge;
			}
		} catch (RangeCheckException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeAge;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + employeeNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeAge != other.employeeAge)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeNumber != other.employeeNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", employeeAge="
				+ employeeAge + "]";
	}

	@Override
	public int compareTo(Employee otherEmployee) {

		if (sortOrder.equalsIgnoreCase("asc")) {
			if (this.employeeAge > otherEmployee.employeeAge)
				return -1;
			if (this.employeeAge < otherEmployee.employeeAge)
				return 1;
			return 0;
		} else {
			if (this.employeeAge > otherEmployee.employeeAge)
				return 1;
			if (this.employeeAge < otherEmployee.employeeAge)
				return -1;
			return 0;
		}
	}

}
