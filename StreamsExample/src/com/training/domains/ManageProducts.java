package com.training.domains;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManageProducts {

	public void printProductByCategory(String category, List<Product> productList) {

		List<Product> catalog = productList.stream().filter(eachProduct -> eachProduct.getCategory().equals(category))
				.collect(Collectors.toList());

		catalog.forEach(System.out::println);
	}

	public void printProductNames(List<Product> productList) {

		productList.stream().map(product -> product.getProductName()).forEach(System.out::println);
	}

	public void printCategory(List<Product> productList) {

		Set<String> category = productList.stream().map(product -> product.getCategory()).distinct()
				.collect(Collectors.toSet());

		category.forEach(System.out::println);
	}

	public void printSortedList(List<Product> productList) {

		// productList.stream().sorted().forEach(System.out::println);
		productList.stream().sorted(Comparator.comparing(Product::getRatePerUnit)).forEach(System.out::println);
	}

}
