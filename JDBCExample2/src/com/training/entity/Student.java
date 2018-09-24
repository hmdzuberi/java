package com.training.entity;

public class Student {

	private long studentID;
	private String studentName;

	public Student() {
		super();
	}

	public Student(long studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + "]";
	}

}
