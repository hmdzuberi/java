package com.training.domains;

import java.io.IOException;

public class JoinExample {

	public static void main(String[] args) {

		System.out.println("Main Started");

		Thread thread = new Thread() {

			@Override
			public void run() {

				System.out.println("Reading");

				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("Finished Reading");
			}
		};

		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Finish");
	}

}
