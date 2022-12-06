package com.product.productSorting;

import java.util.Comparator;

import com.product.model.Product;

public class ProductSortOnPriceAsc implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		
		return o1.getPrice() > o2.getPrice() ? 1:-1;
	}

}
