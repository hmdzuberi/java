package com.training.domains;

import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		AddNumber<Double, String> marks = new AddNumber<>();
		marks.setDigit(97.8);
		marks.addObject("Ramesh");

		AddNumber<Integer, String> age = new AddNumber<>();
		age.setDigit(21);
		age.addObject("John");

		System.out.println(marks.getList() + "," + marks.getDigit());
		System.out.println(age.getList() + "," + age.getDigit());

		List<Integer> englishMarks = Arrays.asList(20, 30, 40);
		List<Double> mathMarks = Arrays.asList(20.03, 30.40, 40.5);

		System.out.println(showNumbers(englishMarks));
		System.out.println(showNumbers(mathMarks));

		List<Object> studentList = Arrays.asList(new Boolean(true), new Boolean(false), new Boolean(true));

		print(studentList);
		print(englishMarks);
		print(mathMarks);

		printList(englishMarks);
		printList(mathMarks);
		// printList(studentList);

		addToList(englishMarks);
		// addToList(mathMarks);
		addToList(studentList);

	}

	// Generic Method 1
	public static <T> T showNumbers(List<T> numberList) {

		return numberList.get(2);
	}

	// Generic Method 2
	public static void print(List<?> list) {

		list.forEach(System.out::println);
	}

	// Generic Method 3 - Producer
	public static void printList(List<? extends Number> list) {

		list.forEach(System.out::println);
	}

	// Generic Method 4 - Consumer
	public static void addToList(List<? super Integer> list) {

		list.set(2, 7);
	}

}
