package com.training;

import java.util.Iterator;

public class Application {

	public static void main(String[] args) {
		MyArrayList<String> str = new MyArrayList<>();

		System.out.println(str.add("Hello"));
		System.out.println(str.add("Hamaad"));
		System.out.println(str.add("CenturyLink"));
		System.out.println(str);

		Iterator<String> it = str.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(str.get(2));

		str.remove(1);
		System.out.println(str);

	}

}
