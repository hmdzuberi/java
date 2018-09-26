package com.training;

public class Application {

	public static void main(String[] args) {

		MyMap<Integer, String> myMap = new MyMap<>();

		System.out.println(myMap.put(1, "Hello"));
		System.out.println(myMap.put(2, "Hamaad"));
		System.out.println(myMap.put(3, "CenturyLink"));

		System.out.println(myMap);

		System.out.println(myMap.get(1));

		System.out.println(myMap.convertToSet());
	}

}
