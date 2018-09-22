package com.training.domains;

public class Application {

	public static void main(String[] args) {

		BillManager billManager = new BillManager();

		Customer cust = new Customer("Hamaad", 1231231234);

		Furniture item1 = new Furniture(2, 3);
		Car item2 = new Car(1, 5);
		Fan item3 = new Fan(2, 8);
		Utensil item4 = new Utensil(5, 15);
		Car item5 = new Car(2, 30);

		Bill bill = new Bill(1234);

		bill.addItemInBill(item1);
		bill.addItemInBill(item2);
		bill.addItemInBill(item3);
		bill.addItemInBill(item4);
		bill.addItemInBill(item5);
		System.out.println(bill);

		System.out.println(bill.getTotal());

		System.out.println(billManager.attachBillToCustomer(cust, bill));

		System.out.println(billManager.printBill(bill));
		//
		// System.out.println(billManager.storeBillsInFile());

		// System.out.println(billManager.getBillFromFile());
		//
		// System.out.println(billManager);

	}

}
