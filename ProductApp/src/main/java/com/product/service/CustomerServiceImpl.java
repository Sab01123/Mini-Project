package com.product.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.CustomerDTO;
import com.product.exception.CustomerException;
import com.product.model.CurrentCustomerSession;
import com.product.model.Customer;
import com.product.repository.CurrentCustomerSessionDao;
import com.product.repository.CustomerDao;

import net.bytebuddy.utility.RandomString;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CurrentCustomerSessionDao currCustomerSessiondao;

	@Override
	public Customer registerCustomer(Customer customer) {

		if(customer==null) {
			throw new IllegalArgumentException("Please enter valid details");
		}
		Customer registerNewCustomer = customerDao.save(customer);

		return registerNewCustomer;
	}

	@Override
	public String logInCustomer(CustomerDTO customerDTO) throws CustomerException {

		Customer customer = customerDao.findByMobile(customerDTO.getCustomerMobile());
		if(customer==null) {

			throw new CustomerException("You have to register first");
		}

		Optional<CurrentCustomerSession> findById = currCustomerSessiondao.findById(customer.getCustomerId());

		if(findById.isPresent()) {
			throw new CustomerException("Hi "+customer.getName()+" you are already loggedIn");
		}
		if(!customer.getPassword().equals(customerDTO.getPassword())) {
			throw new CustomerException("Password is incorrect");
		}
		String key = RandomString.make(10);

		CurrentCustomerSession customerSession = new CurrentCustomerSession(customer.getCustomerId(),LocalDateTime.now(),key);

		currCustomerSessiondao.save(customerSession);

		return "Customer LogIn Successfully";
	}



}
