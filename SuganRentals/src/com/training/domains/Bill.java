package com.training.domains;

import java.io.Serializable;
import java.util.HashSet;

public class Bill implements Serializable {

	private long invoiceNo;
	private HashSet<Item> itemSet;

	public Bill(long invoiceNo) {

		this.invoiceNo = invoiceNo;
		this.itemSet = new HashSet<>();
	}

	public Bill(long invoiceNo, HashSet<Item> itemSet) {

		this.invoiceNo = invoiceNo;
		this.itemSet = itemSet;
	}

	public long getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public HashSet<? extends Item> getItemSet() {
		return itemSet;
	}

	public void setItemSet(HashSet<Item> itemSet) {
		this.itemSet = itemSet;
	}

	public boolean addItemInBill(Item item) {

		return this.itemSet.add(item);
	}

	public double getTotal() {

		double totalPrice = 0;

		for (Item item : this.itemSet) {

			totalPrice += item.getPrice();
		}

		return totalPrice;
	}

	@Override
	public String toString() {
		return "Bill [invoiceNo=" + invoiceNo + ", itemSet=" + itemSet + "]";
	}

}
