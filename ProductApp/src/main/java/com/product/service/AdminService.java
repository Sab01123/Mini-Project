package com.product.service;
import com.product.dto.AdminLogInDTO;
import com.product.exception.AdminException;
import com.product.model.Admin;

public interface AdminService {

	public Admin createAdmin(Admin admin);
	
	public String logIn(AdminLogInDTO dto) throws AdminException;
}
