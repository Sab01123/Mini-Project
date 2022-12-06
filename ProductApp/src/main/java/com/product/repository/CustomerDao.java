package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByMobile(String mobile);
	
}
