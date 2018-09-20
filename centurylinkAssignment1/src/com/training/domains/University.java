package com.training.domains;

import java.util.ArrayList;
import java.util.Scanner;

public class University {

	public static void main(String[] args) {

		ArrayList<Department> departmentList = initialize();

		Scanner sc = new Scanner(System.in);
		String choice;
		int departmentCode;
		boolean found;

		do {

			try {

				found = false;

				System.out.print("Enter the Department Code: ");
				departmentCode = Integer.parseInt(sc.nextLine());

				for (Department department : departmentList) {
					if (department.getDepartmentCode() == departmentCode) {
						System.out.println(department);
						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("Department not found!");
				}
			} catch (NumberFormatException e) {
				System.err.println("Error: Invalid Department Code.");
			}

			System.out.print("\nDo you want to look for more departments? (Press n to exit): ");
			choice = sc.nextLine();

		} while (!choice.equals("n"));

		sc.close();

	}

	public static ArrayList<Department> initialize() {

		ArrayList<Student> studentList1 = new ArrayList<>();
		ArrayList<Student> studentList2 = new ArrayList<>();
		ArrayList<Department> departmentList = new ArrayList<>();

		Student student1 = new Student(101, "John", 75, 80, 85);
		Student student2 = new Student(102, "Frank", 76, 79, 86);
		Student student3 = new Student(103, "Munroe", 71, 60, 95);
		Student student4 = new Student(104, "Jerry", 65, 92, 82);
		Student student5 = new Student(105, "Tom", 90, 86, 71);
		Student student6 = new Student(106, "Ramesh", 79, 82, 81);

		studentList1.add(student1);
		studentList1.add(student2);
		studentList1.add(student3);
		studentList2.add(student4);
		studentList2.add(student5);
		studentList2.add(student6);

		Department englishDepartment = new Department(1001, "English Department", studentList1);
		Department mathDepartment = new Department(1002, "Math Department", studentList2);

		departmentList.add(englishDepartment);
		departmentList.add(mathDepartment);

		return departmentList;

	}

}
