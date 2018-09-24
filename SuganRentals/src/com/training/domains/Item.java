package com.training.domains;

import java.io.Serializable;

import com.training.interfaces.Billable;

public abstract class Item implements Billable, Serializable {

	private String itemName;
	private double perDayRent;
	private int itemQuantity;
	private int rentalDuration;

	public Item() {
		super();
	}

	public Item(String itemName, double perDayRent, int itemQuantity, int rentalDuration) {
		super();
		this.itemName = itemName;
		this.perDayRent = perDayRent;
		this.itemQuantity = itemQuantity;
		this.rentalDuration = rentalDuration;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getRentalPrice() {
		return perDayRent;
	}

	public void setRentalPrice(double perDayRent) {
		this.perDayRent = perDayRent;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + rentalDuration;
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
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.itemName + "," + this.itemQuantity + "," + this.rentalDuration + "," + this.perDayRent;
	}

	@Override
	public double getPrice() {

		double price = this.perDayRent * this.rentalDuration * this.itemQuantity;

		if (this.rentalDuration > 5) {
			price *= 0.9;
			System.out.println("discount for " + this);
		}

		return price;
	}

}
