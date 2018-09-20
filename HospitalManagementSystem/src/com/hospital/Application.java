package com.hospital;

public class Application {

	public static void main(String[] args) {
		
		Doctor doctorHarry = new Doctor();
		
		doctorHarry.setDoctorID(1234);
		doctorHarry.setDoctorName("Harry Potter");
		doctorHarry.setDepartment("Diagnosis Department");
		doctorHarry.setSpecialization("Heart Diagnosis");
		doctorHarry.setPhoneNumber(1231231234);
		
		System.out.println(doctorHarry.getDoctorID());
		System.out.println(doctorHarry.getDoctorName());
		
		doctorHarry.setLocation(args[0]);
		System.out.println(doctorHarry.getLocation());
		
	}

}
