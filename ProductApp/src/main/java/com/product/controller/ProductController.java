package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.exception.CategoryException;
import com.product.exception.ProductException;
import com.product.model.Product;
import com.product.service.ProductServiceImpl;

@RestController
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl; 

	@PostMapping("/addProduct/{uuid}")
	public ResponseEntity<Product> addNewProduct(@PathVariable("uuid") String uuid,@RequestBody Product product) throws ProductException, CategoryException{
		
		Product addProduct = productServiceImpl.addProduct(uuid, product);
		return new ResponseEntity<Product>(addProduct, HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
