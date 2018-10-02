package com.training.entity;

public class ContactNumber {

	private String contactType;
	private long phoneNumber;

	public ContactNumber(String contactType, long phoneNumber) {

		if (validPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
			this.contactType = contactType;
		} else {
			System.out.println("Invalid Phone Number");
		}

	}

	private boolean validPhoneNumber(Long phoneNumber) {

		boolean isValid = false;

		if (phoneNumber.toString().length() == 10) {
			isValid = true;
		}

		return isValid;
	}

	public ContactNumber() {
		super();
	}

	public String getContactType() {

		return contactType;
	}

	public void setContactType(String contactType) {

		this.contactType = contactType;
	}

	public long getPhoneNumber() {

		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {

		if (validPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			System.out.println("Invalid Phone Number");
		}
	}

	@Override
	public String toString() {

		return "(" + contactType + ": " + phoneNumber + ")";
	}

}
