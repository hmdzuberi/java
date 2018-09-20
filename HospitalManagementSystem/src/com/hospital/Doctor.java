package com.hospital;

public class Doctor {
	private long doctorID;
	private String doctorName;
	private String department;
	private String specialization;
	private long phoneNumber;
	private String location;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(long doctorID, String doctorName, String department, String specialization, long phoneNumber,
			String location) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.department = department;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String analyseReports() {
		return "Reports Analyzed.";
	}
	
	public String checkPatient() {
		return "Patient checked.";
	}
	
	public String prescribeMedicines() {
		return "Medicines prescribed";
	}
	
	public String doResearch() {
		return "Research ongoing";
	}
	
}
