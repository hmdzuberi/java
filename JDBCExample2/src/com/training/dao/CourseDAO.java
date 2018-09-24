package com.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.entity.Course;

public interface CourseDAO {

	public ResultSet getCourse(long courseID) throws SQLException;

	public int addCourse(Course course) throws SQLException;

	public int removeCourse(long courseID) throws SQLException;

}
