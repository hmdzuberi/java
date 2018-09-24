package com.training.entity;

import java.util.List;

public class Course {

	private long courseID;
	private String courseName;
	private List<Student> studentList;

	public Course() {
		super();
	}

	public Course(long courseID, String courseName, List<Student> studentList) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.studentList = studentList;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
