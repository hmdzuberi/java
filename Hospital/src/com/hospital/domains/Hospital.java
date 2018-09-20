package com.hospital.domains;

import java.util.HashMap;
import java.util.HashSet;

public class Hospital {

	private String hospitalName;
	private HashSet<Doctor> setOfDoctors = new HashSet<>();
	private HashMap<Doctor, HashSet<Patient>> appointments = new HashMap<>();
	private HashMap<String, HashSet<Doctor>> specializations = new HashMap<>();

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String hospitalName) {
		super();
		this.hospitalName = hospitalName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public HashSet<Doctor> getSetOfDoctors() {
		return setOfDoctors;
	}

	public HashMap<Doctor, HashSet<Patient>> getAppointments() {
		return appointments;
	}

	public HashMap<String, HashSet<Doctor>> getSpecializations() {
		return specializations;
	}

	public String addDoctor(Doctor doctor) {

		if (!this.setOfDoctors.add(doctor)) {
			return "Failed to add doctor";
		}

		String spec = doctor.getSpecialization();
		HashSet<Doctor> setOfDoctors = new HashSet<>();

		if (this.specializations.containsKey(spec)) {

			setOfDoctors = this.specializations.get(spec);
		}

		boolean var1 = setOfDoctors.add(doctor);
		HashSet<Doctor> var2 = this.specializations.put(doctor.getSpecialization(), setOfDoctors);

		if (var1 && var2 == null) {
			return "Doctor added and specialization updated";
		} else {
			return "Doctor added but failed to update specialization";
		}

	}

	public String fixAppointment(Doctor doctor, Patient patient, String appointmentTime) {

		patient.setAppointmentTime(appointmentTime);

		if (this.setOfDoctors.contains(doctor)) {

			HashSet<Patient> setOfPatients = new HashSet<>();

			if (this.appointments.containsKey(doctor)) {
				setOfPatients = this.appointments.get(doctor);
				
				boolean var1 = setOfPatients.add(patient);
				HashSet<Patient> var2 = this.appointments.put(doctor, setOfPatients);

				if (var1 && var2 != null) {
					return "Appointment added";
				} else {
					return "Failed to add apointment";
				}
			}

			boolean var1 = setOfPatients.add(patient);
			HashSet<Patient> var2 = this.appointments.put(doctor, setOfPatients);

			if (var1 && var2 == null) {
				return "Appointment added";
			} else {
				return "Failed to add apointment";
			}

		} else {
			return "Doctor doesn't exist";
		}

	}

}
