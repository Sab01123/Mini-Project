package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.CustomerDTO;
import com.product.exception.CustomerException;
import com.product.model.Customer;
import com.product.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer registerCustomer = customerServiceImpl.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(registerCustomer, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody CustomerDTO customerDto) throws CustomerException{
		String logInCustomer = customerServiceImpl.logInCustomer(customerDto);
		
		return new ResponseEntity<String>(logInCustomer, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
