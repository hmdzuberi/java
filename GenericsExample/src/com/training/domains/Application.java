package com.training.domains;

import java.util.ArrayList;
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

		List<Integer> englishMarks = new ArrayList<>();
		List<Double> mathMarks = new ArrayList<>();

		englishMarks.add(20);
		englishMarks.add(27);

		// System.out.println(showNumbers(englishMarks));
		// System.out.println(showNumbers(mathMarks));

		// List<Object> studentList = Arrays.asList(new Boolean(true), new
		// Boolean(false), new Boolean(true));
		List<Object> studentList = new ArrayList<>();

		studentList.add(new Boolean(true));
		studentList.add(new Boolean(false));

		print(studentList);
		print(englishMarks);
		print(mathMarks);

		printList(englishMarks);
		printList(mathMarks);
		// printList(studentList);

		addToList(englishMarks);
		// addToList(mathMarks);
		// addToList(studentList);

		System.out.println(englishMarks);

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

		list.add(32);
	}

}
