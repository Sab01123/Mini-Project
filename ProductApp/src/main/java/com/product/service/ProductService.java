package com.product.service;

import com.product.exception.CategoryException;
import com.product.exception.ProductException;
import com.product.model.Product;

public interface ProductService {

	public Product addProduct(String uuid, Product product) throws ProductException,CategoryException;
}
