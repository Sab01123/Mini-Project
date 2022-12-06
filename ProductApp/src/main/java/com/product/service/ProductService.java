package com.product.service;
import java.util.List;

import com.product.exception.CategoryException;
import com.product.exception.CustomerException;
import com.product.exception.ProductException;
import com.product.model.Product;
public interface ProductService {

	public Product addProduct(String uuid, Product product) throws ProductException,CategoryException;

	public List<Product> searchProduct(String uuid, String productName)throws CustomerException, ProductException;

	public List<Product> viewProducts(String uuid, String sortingOrder,int pageSize,int pageNumber)throws CustomerException, ProductException;

	public List<Product> searchProductByCategory(String uuid, String productName)throws CustomerException, ProductException;

}
