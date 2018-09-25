package com.training.dao;

import java.sql.SQLException;

import com.training.entity.Student;

public interface StudentDAO {

	public Student getStudent(long studentID) throws SQLException;

	public int addStudent(Student student) throws SQLException;

	public int removeStudent(long studentID) throws SQLException;

}
