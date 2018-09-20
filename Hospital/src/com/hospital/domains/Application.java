package com.hospital.domains;

public class Application {

	public static void main(String[] args) {

		Hospital fortis = initialize();

		System.out.println(fortis.getAppointments());
		
		System.out.println();
		
		System.out.println(fortis.getSpecializations());

	}

	public static Hospital initialize() {

		Hospital newHospital = new Hospital("Fortis");

		Doctor doctor1 = new Doctor(101, "John", "ENT");
		Doctor doctor2 = new Doctor(102, "Goku", "Heart");

		Patient patient1 = new Patient(201, "Harry");
		Patient patient2 = new Patient(202, "Ron");
		Patient patient3 = new Patient(203, "Hermione");

		System.out.println(newHospital.addDoctor(doctor1));
		System.out.println(newHospital.addDoctor(doctor2));

		System.out.println();

		System.out.println(newHospital.fixAppointment(doctor1, patient1, "7:00"));
		System.out.println(newHospital.fixAppointment(doctor2, patient2, "7:00"));
		System.out.println(newHospital.fixAppointment(doctor2, patient3, "7:30"));

		return newHospital;

	}

}
