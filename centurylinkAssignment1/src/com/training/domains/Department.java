package com.training.domains;

import java.util.ArrayList;

public class Department {

	private int departmentCode;
	private String departmentName;
	private ArrayList<Student> studentList = new ArrayList<>();
	private double departmentAverage;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentCode, String departmentName, ArrayList<Student> studentList) {

		super();
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.studentList = studentList;
		this.departmentAverage = 0.0;

		if (studentList != null) {

			for (Student student : studentList) {
				this.departmentAverage += student.getStudentAvgMarks();
			}

			this.departmentAverage /= studentList.size();

		}

	}

	public int getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public double getDepartmentAverage() {
		return departmentAverage;
	}

	@Override
	public String toString() {
		return "\n Department: " + departmentCode + " - " + departmentName + "\n List of Students: " + studentList
				+ "\n Department Average: " + departmentAverage;
	}

}
