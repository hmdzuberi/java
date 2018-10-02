package com.training.entity;

import java.util.ArrayList;
import java.util.List;

public class Contact {

	private long contactID;
	private String contactName;
	private String emailID;
	private String relation;
	private List<ContactNumber> contactNumbers;

	public Contact() {
		super();
		contactNumbers = new ArrayList<>();
	}

	public Contact(long contactID, String contactName, String emailID, String relation,
			List<ContactNumber> contactNumbers) {

		this.contactID = contactID;
		this.contactName = contactName;
		this.emailID = emailID;
		this.relation = relation;
		this.contactNumbers = contactNumbers;
	}

	public long getContactID() {

		return contactID;
	}

	public void setContactID(long contactID) {

		this.contactID = contactID;
	}

	public String getContactName() {

		return contactName;
	}

	public void setContactName(String contactName) {

		this.contactName = contactName;
	}

	public String getEmailID() {

		return emailID;
	}

	public void setEmailID(String emailID) {

		this.emailID = emailID;
	}

	public String getRelation() {

		return relation;
	}

	public void setRelation(String relation) {

		this.relation = relation;
	}

	public List<ContactNumber> getContactNumbers() {

		return contactNumbers;
	}

	public void setContactNumbers(List<ContactNumber> contactNumbers) {

		this.contactNumbers = contactNumbers;
	}

	public void addContactNumber(ContactNumber contactNumber) {

		this.contactNumbers.add(contactNumber);
	}

	@Override
	public String toString() {

		return "\nContact Name: " + contactName + ", Email ID: " + emailID + ", Relation: " + relation
				+ "\nContact Numbers: " + contactNumbers + "\n";
	}

}
