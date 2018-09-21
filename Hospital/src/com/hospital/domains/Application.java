package com.hospital.domains;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Hospital fortis = initialize();
		String choice = null;

		System.out.println("Welcome to Fortis Hospital!");

		do {
			System.out.println("\n\n1. Fix an appointment");
			System.out.println("2. Show all appointments");
			System.out.println("3. Show all doctors");
			System.out.print("\nYour choice (Press n to exit): ");
			try {
				choice = sc.nextLine();
				switch (choice) {
				case "1":
					Patient newPatient = new Patient();
					String doctorName = null;

					System.out.print("\nPatient ID: ");
					newPatient.setPatientId(Integer.parseInt(sc.nextLine()));

					System.out.print("Patient's name: ");
					newPatient.setPatientName(sc.nextLine());

					System.out.print("Doctor's name: ");
					doctorName = sc.nextLine();

					System.out.print("Appointment Time: ");

					System.out.println(fortis.fixAppointment(doctorName, newPatient, sc.nextLine()));
					break;
				case "2":
					System.out.println(fortis.getAppointments());
					break;
				case "3":
					System.out.println(fortis.getSetOfDoctors());
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!choice.equals("n"));

		sc.close();

	}

	public static Hospital initialize() {

		Hospital newHospital = new Hospital("Fortis");

		Doctor doctor1 = new Doctor(101, "John", "ENT");
		Doctor doctor2 = new Doctor(102, "Goku", "Heart");
		Doctor doctor3 = new Doctor(103, "Gohan", "Heart");

		// Patient patient1 = new Patient(201, "Harry");
		// Patient patient2 = new Patient(202, "Ron");
		// Patient patient3 = new Patient(203, "Hermione");

		newHospital.addDoctor(doctor1);
		newHospital.addDoctor(doctor2);
		newHospital.addDoctor(doctor3);

		// System.out.println(newHospital.fixAppointment(doctor1, patient1,
		// "7:00"));
		// System.out.println(newHospital.fixAppointment(doctor2, patient2,
		// "7:00"));
		// System.out.println(newHospital.fixAppointment(doctor2, patient3,
		// "7:30"));

		return newHospital;

	}

}
