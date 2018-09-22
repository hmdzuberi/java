package com.training.domains;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class BillManager {

	HashMap<Customer, HashSet<Bill>> customerMap;

	public BillManager() {
		customerMap = new HashMap<>();
	}

	@Override
	public String toString() {
		return "BillManager [customerSet=" + customerMap + "]";
	}

	public boolean printBill(Bill bill) {

		boolean result = false;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileWriter(new File("Bill.txt"), true));

			writer.println("Bill Invoice Number: " + bill.getInvoiceNo() + "\n");

			int count = 1;
			for (Item item : bill.getItemSet()) {
				writer.println(count + ". " + item.getItemName() + " - Quantity: " + item.getItemQuantity()
						+ ", Rented for " + item.getRentalDuration() + " days. Price: " + item.getPrice());
				count++;
			}

			writer.println("\nTotal: " + bill.getTotal());

			result = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			writer.close();
		}

		return result;

	}

	public boolean attachBillToCustomer(Customer customer, Bill bill) {

		boolean result = false;
		boolean isBillAdded = false;

		HashSet<Bill> billSet = new HashSet<>();
		HashSet<Bill> oldBillSet = null;

		try {

			if (this.customerMap.containsKey(customer)) {

				billSet = this.customerMap.get(customer);
				isBillAdded = billSet.add(bill);
				oldBillSet = this.customerMap.put(customer, billSet);

				if (isBillAdded && (oldBillSet != null)) {
					result = true;
				}

			} else {

				isBillAdded = billSet.add(bill);
				oldBillSet = this.customerMap.put(customer, billSet);

				if (isBillAdded && (oldBillSet == null)) {
					result = true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean storeBillsInFile() {

		boolean result = false;
		ObjectOutputStream outStream = null;

		try {
			outStream = new ObjectOutputStream(new FileOutputStream(new File("bills.ser")));

			outStream.writeObject(this.customerMap);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean getBillFromFile() {

		boolean result = false;
		Object obj = null;
		ObjectInputStream inStream = null;

		try {

			inStream = new ObjectInputStream(new FileInputStream("bills.ser"));
			obj = inStream.readObject();

			if (obj instanceof HashMap) {
				this.customerMap = (HashMap<Customer, HashSet<Bill>>) obj;
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

}
