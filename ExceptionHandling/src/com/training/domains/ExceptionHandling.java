package com.training.domains;

public class ExceptionHandling {

	public static void main(String[] args) {

		catchWithJava8();

	}

	public static String handle() {

		try {

			int marksScored = 450;
			String args = "45";

			int age = Integer.parseInt(args);
			int average = marksScored / 0;

			System.out.println(age);
			System.out.println(average);

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Requires Command Line argument");

		} catch (NumberFormatException e) {

			System.out.println("Requires positive Command Line argument");

		} catch (ArithmeticException e) {

			System.out.println("Cannot divide by 0");
			return "Bye Bye";

		} finally {

			System.out.println("Inside Finally");

		}

		System.out.println("Done");
		return "Bye";

	}

	public static String catchWithJava8() {

		try {

			int marksScored = 450;
			String args = "45";

			int age = Integer.parseInt(args);
			int average = marksScored / 5;

			System.out.println(age);
			System.out.println(average);

		} catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {

			System.out.println("Requires valid Command Line argument");
			System.out.println(e.getClass());
			return "Bye Bye";

		} finally {

			System.out.println("Inside Finally");

		}

		System.out.println("Done");
		return "Bye";

	}

}
