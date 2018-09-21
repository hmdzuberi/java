package com.training.domains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObjectHandling {

	public boolean saveObject(Object obj) {

		boolean status = false;
		ObjectOutputStream outStream = null;

		try {
			outStream = new ObjectOutputStream(new FileOutputStream(new File("customer.ser")));

			outStream.writeObject(obj);
			status = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return status;

	}

	public Object loadObject() {

		Object obj = null;
		ObjectInputStream inStream = null;

		try {
			inStream = new ObjectInputStream(new FileInputStream("customer.ser"));
			obj = inStream.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return obj;

	}

	public boolean writeToTextFile(Customer customer) {

		boolean result = false;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileWriter(new File("Customer.txt"), true));
			writer.println(customer.toString());
			result = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			writer.close();
		}

		return result;

	}

	public List<Customer> readFromTextFile(File file) {

		List<Customer> customerList = new ArrayList<>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String customerAsString;

			while ((customerAsString = reader.readLine()) != null) {

				String[] items = customerAsString.split(",");

				Customer customer = new Customer(Long.parseLong(items[0]), items[1], Long.parseLong(items[2]));

				customerList.add(customer);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return customerList;

	}

}
