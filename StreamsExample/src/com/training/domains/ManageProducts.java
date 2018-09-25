package com.training.domains;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ManageProducts {

	public void printProductNames(List<Product> productList) {

		productList.stream().map(product -> product.getProductName()).forEach(System.out::println);
	}

	public void printProductByCategory(String category, List<Product> productList) {

		List<Product> catalog = productList.stream().filter(eachProduct -> eachProduct.getCategory().equals(category))
				.collect(Collectors.toList());

		catalog.forEach(System.out::println);
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

	public double findMaxPricedProduct(List<Product> productList) {

		double maxPrice = 0.0;

		Optional<Product> product = productList.stream().max(Comparator.comparing(Product::getRatePerUnit));

		if (product.isPresent()) {
			maxPrice = product.get().getRatePerUnit();
		}

		return maxPrice;
	}

	public double findMinPricedProduct(List<Product> productList) {

		double minPrice = 0.0;

		Optional<Product> product = productList.stream().min(Comparator.comparing(Product::getRatePerUnit));

		if (product.isPresent()) {
			minPrice = product.get().getRatePerUnit();
		}

		return minPrice;
	}

	public double findMinMax(List<Product> productList, boolean isMin) {

		double price = 0.0;
		Optional<Product> product = null;

		if (isMin) {
			product = productList.stream().min(Comparator.comparing(Product::getRatePerUnit));
		} else {
			product = productList.stream().max(Comparator.comparing(Product::getRatePerUnit));
		}

		if (product.isPresent()) {
			price = product.get().getRatePerUnit();
		}

		return price;
	}

	public long countProducts(List<Product> productList) {

		return productList.stream().count();
	}

	public Map<String, Double> getPriceList(List<Product> productList) {

		// Map<String, Double> priceList = productList.stream().filter(product
		// -> product.getCategory().equals("Fridge"))
		// .collect(Collectors.toMap(Product::getProductName,
		// Product::getRatePerUnit));
		return productList.stream().collect(Collectors.toMap(Product::getProductName, Product::getRatePerUnit));
	}

	public double maxAmount(List<Product> productList) {

		Optional<Double> result = productList.parallelStream().map(e -> e.getRatePerUnit())
				.reduce((p1, p2) -> p1 > p2 ? p1 : p2);

		return result.get().doubleValue();
	}

	public double totalAmount(List<Product> productList) {

		return productList.parallelStream().map(p -> p.getRatePerUnit()).reduce(0.0, (p1, p2) -> {
			p1 += p2;
			return p1;
		});
	}
}
