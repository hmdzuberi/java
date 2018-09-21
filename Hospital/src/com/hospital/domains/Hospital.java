package com.hospital.domains;

import java.util.HashMap;
import java.util.HashSet;

public class Hospital {

	private String hospitalName;
	private HashSet<Doctor> setOfDoctors;
	private HashMap<Doctor, HashSet<Patient>> appointments;
	private HashMap<String, HashSet<Doctor>> specializations;

	public Hospital() {
		super();
		this.hospitalName = "New Hospital";
		init();
	}

	public Hospital(String hospitalName) {
		super();
		this.hospitalName = hospitalName;
		init();
	}

	private void init() {
		this.setOfDoctors = new HashSet<>();
		this.appointments = new HashMap<>();
		this.specializations = new HashMap<>();
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

			boolean isDoctorAdded = setOfDoctors.add(doctor);
			HashSet<Doctor> oldDoctorSet = this.specializations.put(doctor.getSpecialization(), setOfDoctors);

			if (isDoctorAdded && oldDoctorSet != null) {
				return "Doctor added and specialization updated";
			} else {
				return "Doctor added but failed to update specialization";
			}

		} else {

			boolean isDoctorAdded = setOfDoctors.add(doctor);
			HashSet<Doctor> oldDoctorSet = this.specializations.put(doctor.getSpecialization(), setOfDoctors);

			if (isDoctorAdded && oldDoctorSet == null) {
				return "Doctor added and specialization updated";
			} else {
				return "Doctor added but failed to update specialization";
			}

		}

	}

	public String fixAppointment(String doctorName, Patient patient, String appointmentTime) {

		patient.setAppointmentTime(appointmentTime);

		boolean contains = false;
		Doctor doctorAppt = new Doctor();
		// this.setOfDoctors.contains(doctor)

		for (Doctor doctor : this.setOfDoctors) {
			if (doctor.getDoctorName().equals(doctorName)) {
				doctorAppt = doctor;
				contains = true;
			}
		}

		if (contains) {

			HashSet<Patient> setOfPatients = new HashSet<>();

			if (this.appointments.containsKey(doctorAppt)) {
				setOfPatients = this.appointments.get(doctorAppt);

				boolean isPatientAdded = setOfPatients.add(patient);
				HashSet<Patient> oldDoctorAppointmentSet = this.appointments.put(doctorAppt, setOfPatients);

				if (isPatientAdded && oldDoctorAppointmentSet != null) {
					return "Appointment added";
				} else {
					return "Failed to add apointment";
				}

			} else {

				boolean isPatientAdded = setOfPatients.add(patient);
				HashSet<Patient> oldDoctorAppointmentSet = this.appointments.put(doctorAppt, setOfPatients);

				if (isPatientAdded && oldDoctorAppointmentSet == null) {
					return "Appointment added";
				} else {
					return "Failed to add apointment";
				}

			}

		} else {
			return "Doctor doesn't exist";
		}

	}

}
