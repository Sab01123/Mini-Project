package com.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.CustomerException;
import com.product.exception.ProductException;
import com.product.model.CurrentCustomerSession;
import com.product.model.Customer;
import com.product.model.Product;
import com.product.repository.CartDao;
import com.product.repository.CurrentCustomerSessionDao;
import com.product.repository.CustomerDao;
import com.product.repository.ProductDao;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private CurrentCustomerSessionDao customerSessionDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired 
	private  CustomerDao customerDao;
	
	@Override
	public String addToCart(String uuid, Integer productId) throws CustomerException, ProductException {

		CurrentCustomerSession customer = customerSessionDao.findByUuid(uuid);

		if(customer == null) {
			throw  new CustomerException("You are not loggedIn");
		}

		Optional<Product> product = productDao.findById(productId);
		
		if(!product.isPresent()) {
			throw new ProductException("Recently, product is not available");
		}
		
		Optional<Customer> existedCustomer = customerDao.findById(customer.getId());
		
		existedCustomer.get().getCart().getProducts().add(product.get());
		
		return "product added to cart successfully";
	}
   





















}
