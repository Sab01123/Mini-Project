package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.exception.CategoryException;
import com.product.exception.CustomerException;
import com.product.exception.ProductException;
import com.product.model.Product;
import com.product.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl; 

	@PostMapping("/admin/addProduct/{uuid}")
	public ResponseEntity<Product> addNewProduct(@PathVariable("uuid") String uuid,@RequestBody Product product) throws ProductException, CategoryException{
		
		Product addProduct = productServiceImpl.addProduct(uuid, product);
		return new ResponseEntity<Product>(addProduct, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customer/search/{uuid}/{productName}")
	public ResponseEntity<List<Product>> searchProductHandler(@PathVariable("uuid") String uuid,@PathVariable("productName") String productName) throws CustomerException, ProductException{
		List<Product> searchProduct = productServiceImpl.searchProduct(uuid, productName);
		return new ResponseEntity<List<Product>>(searchProduct, HttpStatus.OK);
	}
	
	@GetMapping("/customer/searchAll/{uuid}")
	public ResponseEntity<List<Product>> viewProductsHandler(@PathVariable("uuid") String uuid,
			@RequestParam(value = "sort",required = false, defaultValue = "no") String sortByPrice,
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize
			) throws CustomerException, ProductException{
		List<Product> products = productServiceImpl.viewProducts(uuid,sortByPrice,pageSize,pageNumber);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	// localhost:8888/customer/searchAll/987?sort=high-low
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
