package com.product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.AdminLogInDTO;
import com.product.exception.AdminException;
import com.product.model.Admin;
import com.product.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	
	@PostMapping("/create")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		
		Admin newAdmin = adminServiceImpl.createAdmin(admin);
		
		return new ResponseEntity<Admin>(newAdmin, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLogInDTO adminDTO) throws AdminException{
	
		String adminlogIn = adminServiceImpl.logIn(adminDTO);
		return new ResponseEntity<String>(adminlogIn, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
}
