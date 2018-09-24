package com.training;

import com.training.dao.StudentDAO;
import com.training.dao.impl.StudentDAOImpl;
import com.training.entity.Student;
import com.training.utils.DbConnection;

public class Application {

	public static void main(String[] args) {

		int key = 2;
		StudentDAO studentDao = new StudentDAOImpl();

		try {

			System.out.println(DbConnection.getOracleConnection());

			switch (key) {
			case 1:
				Student student1 = new Student(101, "John");

				int studentAdded = studentDao.addStudent(student1);

				System.out.println(studentAdded + " student(s) added");

				break;

			case 2:
				Student student = studentDao.getStudent(101);

				System.out.println(student);

				break;

			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
