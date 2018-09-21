package com.training.domains;

public class PrintString {

	public static synchronized void print(String str1, String str2) {

		System.out.println(str1);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(str2);
	}

}
