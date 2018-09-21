package com.training.domains;

public class Calculate implements Runnable {

	private int count;

	public Calculate(int count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName());

		long fact = 1;

		for (int i = this.count; i > 0; i--) {
			fact *= i;
		}

		System.out.println(fact);
	}

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());

		Calculate fiveFactorial = new Calculate(5);
		Thread thread = new Thread(fiveFactorial);

		thread.setName("Five Factorial");
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Calculate fourFactorial = new Calculate(4);
		Thread thread2 = new Thread(fourFactorial, "Four Factorial");

		thread2.start();

		System.out.println("Bye");
	}

}
