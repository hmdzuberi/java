package com.training.domains;

public class Application {

	public static void main(String[] args) {

		AddNumber<Double, String> marks = new AddNumber<>();
		marks.setDigit(97.8);
		marks.addObject("Ramesh");

		AddNumber<Integer, String> age = new AddNumber<>();
		age.setDigit(21);
		age.addObject("John");

		System.out.println(marks.getDigit());
		System.out.println(age.getDigit());

		System.out.println(marks.getList());
		System.out.println(age.getList());

	}

}
