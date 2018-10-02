package com.training.entity;

public class ContactNumber {

	private String contactType;
	private long phoneNumber;

	public ContactNumber(String contactType, long phoneNumber) {
		super();
		this.contactType = contactType;
		this.phoneNumber = phoneNumber;
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

		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {

		return "ContactNumber [contactType=" + contactType + ", phoneNumber=" + phoneNumber + "]";
	}

}
