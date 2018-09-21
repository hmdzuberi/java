package com.training.domains;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 8L;
	private long customerId;
	private String customerName;
	private Address address;
	private transient long mobileNumber;

	public Customer() {
		super();
	}

	public Customer(long customerId, String customerName, long mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}

	public Customer(long customerId, String customerName, Address address, long mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		Customer customer = (Customer) obj;
		return (this.customerId == customer.customerId && this.customerName.equals(customer.customerName));

	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Customer Object Garbage Collected: " + this.customerId);
	}

	@Override
	public String toString() {
		return customerId + "," + customerName + "," + mobileNumber;
	}

	private void readObject(ObjectInputStream in) {
		try {
			in.defaultReadObject();
			this.mobileNumber = (long) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void writeObject(ObjectOutputStream out) {
		try {
			out.defaultWriteObject();
			out.writeObject(this.mobileNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
