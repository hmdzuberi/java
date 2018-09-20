package com.training;

public class Outer {

	public static void main(String[] args) {

		Outer obj = new Outer();
		String[] names = { "Gaurav", "Aneesh", "Magesh" };

		obj.show(names, "");

	}

	public void show(String[] data, String condition) {

		Filter obj = new Filter() {

			@Override
			public String filter(String[] data, String condition) {

				return data[0];
			}

		};

		System.out.println(obj.filter(data, condition));
	}

}
