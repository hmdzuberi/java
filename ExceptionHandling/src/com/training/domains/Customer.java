package com.training.domains;

public class Customer {

	private long customerId;
	private String customerName;
	private Address address;
	private long mobileNumber;

	public Customer() {
		super();
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

}
