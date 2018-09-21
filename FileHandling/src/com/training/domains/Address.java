package com.training.domains;

import java.io.Serializable;

public class Address implements Serializable {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private long pinCode;

	public Address() {
		super();
	}

	public Address(String addressLine1, String addressLine2, String city, long pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;

		if (pinCode < 0) {
			try {
				throw new Exception("Pincode should be a positive number");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			this.pinCode = pinCode;
		}

	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) throws Exception {

		if (pinCode < 0) {
			throw new Exception("Pincode should be a positive number");
		} else {
			this.pinCode = pinCode;
		}

	}

	@Override
	public String toString() {
		return addressLine1 + ", " + addressLine2 + ", " + city + " " + pinCode;
	}

}
