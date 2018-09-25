package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.dao.StudentDAO;
import com.training.entity.Course;
import com.training.entity.Student;
import com.training.utils.DbConnection;

public class StudentDAOImpl implements StudentDAO {

	private Connection con;

	public StudentDAOImpl() {
		super();

		con = DbConnection.getOracleConnection();
	}

	private Student convertToObject(ResultSet rs) throws SQLException {

		Student student = new Student();
		Course course = new Course();

		student.setStudentID(rs.getLong("studentID"));
		student.setStudentName(rs.getString("studentName"));
		// course.set
		return student;
	}

	@Override
	public Student getStudent(long studentID) throws SQLException {

		Student student = null;
		String sql = "select * from hz_students natural join hz_courses where studentID = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setLong(1, studentID);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			student = convertToObject(rs);
		}

		return student;
	}

	@Override
	public int addStudent(Student student) throws SQLException {

		int studentAdded = 0;
		String sql = "insert into hz_students values (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setLong(1, student.getStudentID());
		// pstmt.setString(2, student.getStudentName());
		// pstmt.setLong(3, student.getCourse().getCourseID());

		studentAdded = pstmt.executeUpdate();

		return studentAdded;
	}

	@Override
	public int removeStudent(long studentID) throws SQLException {

		return 0;
	}

}
