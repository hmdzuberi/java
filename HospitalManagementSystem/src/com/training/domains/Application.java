package com.training.domains;

public class Application {

	public static void main(String[] args) {
		Book hFirst = new Book(101, "Head First Java", "Kathy Sierra", 450);
		Book thinkFirst = new Book(102, "Thinking in Java", "Bruce Erikel", 850);
		Book effJava = new Book(103, "Effective Java", "Joshua Bloch", 750);
		
		Book[] bookList = new Book[3];
		
		bookList[0] = hFirst;
		bookList[1] = thinkFirst;
		bookList[2] = effJava;
		
		BookManager mgr = new BookManager();
		
		mgr.display(bookList);
		System.out.println();
		mgr.display(hFirst, thinkFirst);
		mgr.display(new Book(104, "Abc", "Pqr"));
	}

}
