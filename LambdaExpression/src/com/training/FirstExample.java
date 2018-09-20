package com.training;

import java.util.Arrays;
import java.util.List;

import com.training.ifaces.Converter;
import com.training.ifaces.IGreeting;

public class FirstExample {

	public static void main(String[] args) {

		IGreeting greeter = (name) -> {
			return name.toUpperCase();
		};

		System.out.println(greeter.greet("Hamaad"));

		Converter convert = (dollarAmount) -> {
			return dollarAmount * 72.0;
		};

		System.out.println(convert.dollarToINR(15));

		// Old way
		String[] names = { "Ramesh", "Suresh", "Magesh" };

		for (String name : names) {
			System.out.println(name);
		}

		// New way - Java 8
		List<String> nameList = Arrays.asList("Ramesh", "Suresh", "Magesh");

		nameList.forEach(System.out::println);

	}

}
