package com.training.domains;

public class Student {

	private int studentNumber;
	private String studentName;
	private double marks1;
	private double marks2;
	private double marks3;
	private double studentAvgMarks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentNumber, String studentName, int marks1, int marks2, int marks3) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;

		this.studentAvgMarks = (marks1 + marks2 + marks3) / 3;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getMarks1() {
		return marks1;
	}

	public void setMarks1(double marks1) {
		this.marks1 = marks1;
	}

	public double getMarks2() {
		return marks2;
	}

	public void setMarks2(double marks2) {
		this.marks2 = marks2;
	}

	public double getMarks3() {
		return marks3;
	}

	public void setMarks3(double marks3) {
		this.marks3 = marks3;
	}

	public double getStudentAvgMarks() {
		return studentAvgMarks;
	}

	@Override
	public String toString() {
		return "\n " + studentName + " (" + studentNumber + ") - Marks are " + marks1 + ", " + marks2 + ", " + marks3;
	}

}
