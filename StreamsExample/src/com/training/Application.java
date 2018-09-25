package com.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.domains.ManageProducts;
import com.training.domains.Product;

public class Application {

	public static void main(String[] args) {

		Product sonyTV = new Product(101, "Sony TV", "TV", 45000);
		Product samsungTV = new Product(102, "Samsung TV", "TV", 55000);
		Product hitachiTV = new Product(103, "Hitachi TV", "TV", 65000);
		Product lgFridge = new Product(201, "LG Fridge", "Fridge", 25000);
		Product samsungFridge = new Product(202, "Samsung Fridge", "Fridge", 35000);
		Product haierFridge = new Product(101, "Haier Fridge", "Fridge", 20000);

		List<Product> productList = new ArrayList<>();

		productList.add(sonyTV);
		productList.add(samsungTV);
		productList.add(hitachiTV);
		productList.add(lgFridge);
		productList.add(samsungFridge);
		productList.add(haierFridge);

		ManageProducts mgr = new ManageProducts();

		// mgr.printProductByCategory("TV", productList);
		// mgr.printProductNames(productList);
		// mgr.printCategory(productList);
		// mgr.printSortedList(productList);

		// System.out.println(mgr.countProducts(productList));
		// System.out.println(mgr.findMinPricedProduct(productList));
		// System.out.println(mgr.findMaxPricedProduct(productList));
		// System.out.println(mgr.findMinMax(productList, true));
		// System.out.println(mgr.findMinMax(productList, false));

		Map<String, Double> priceList = mgr.getPriceList(productList);
		// System.out.println(priceList.get("Samsung TV"));

		Set<Map.Entry<String, Double>> items = priceList.entrySet();
		for (Map.Entry<String, Double> eachItem : items) {

			System.out.println(eachItem.getKey());
			System.out.println(eachItem.getValue());
		}

	}

}
