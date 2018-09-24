package com.training.domains;

import java.io.Serializable;

public class Customer implements Serializable {

	private String customerName;
	private long contactNumber;

	public Customer() {
		super();
	}

	public Customer(String customerName, long contactNumber) {
		super();
		this.customerName = customerName;
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactNumber ^ (contactNumber >>> 32));
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (contactNumber != other.contactNumber)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.customerName + "," + this.contactNumber;
	}

}
