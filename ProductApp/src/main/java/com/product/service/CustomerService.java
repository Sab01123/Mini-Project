package com.product.service;

import com.product.dto.CustomerDTO;
import com.product.exception.CustomerException;
import com.product.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);  
	
	public String logInCustomer(CustomerDTO customerDTO) throws CustomerException;
}
