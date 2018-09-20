package com.training.domains;

public class BookManager {
	public void display(Book ...books) {
		displayBooks(books);
	}
	
	private void displayBooks(Book[] bookList) {
		for(Book eachBook : bookList) {
			double discount = eachBook.findDiscount();
			double amount = eachBook.getRatePerUnit();
			double netAmount = amount * (1 - discount);
			
			System.out.println("Book Name: " + eachBook.getBookName());
			System.out.println("Author: " + eachBook.getAuthor());
			System.out.println("Book Price: " + eachBook.getRatePerUnit());
			System.out.println("After discount: " + netAmount);
			System.out.println("Publisher: " + Book.publisher);
			System.out.println();
		}
	}
}
