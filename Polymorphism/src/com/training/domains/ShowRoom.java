package com.training.domains;

import com.training.ifaces.IAutomobile;
import java.util.*;

public class ShowRoom {

	public static void main(String args[]) {

		String choice = "y";
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Enter the code [1 - Car, 2 - Bike, 3 - Tractor]: ");
			int key = sc.nextInt();
			QuoteManager quote = new UpdatedQuoteManager();

			IAutomobile auto = quote.getModel(key);

			quote.printQuote(auto);

			System.out.println("Enter Y to continue, N to stop: ");
			choice = sc.next();

		} while (!choice.equals("N") && !choice.equals("n"));

		sc.close();

	}

}
