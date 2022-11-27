package com.product.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.dto.AdminLogInDTO;
import com.product.exception.AdminException;
import com.product.model.Admin;
import com.product.model.CurrentAdminSession;
import com.product.repository.AdminDao;
import com.product.repository.CurrentAdminSessionDao;
import net.bytebuddy.utility.RandomString;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CurrentAdminSessionDao currAdminSessionDao;
	
	@Override
	public Admin createAdmin(Admin admin) {
		return adminDao.save(admin);
	}

	@Override
	public String logIn(AdminLogInDTO dto) throws AdminException{
   
	Admin admin  =	adminDao.findByMobile(dto.getMobile());
		
	if(admin==null) {
		throw new AdminException("Invalid Mobile Number");
	}
	Optional<CurrentAdminSession> exsistId = currAdminSessionDao.findById(admin.getAdminId());
	
	if(exsistId.isPresent()) {
		throw new AdminException("You have been already loggedIn..");
	}
	if(!admin.getPassword().equals(dto.getPassword())) {
		throw new AdminException("Wrong password entered !");
	}
	
	String key = RandomString.make(10);
	CurrentAdminSession newAdminLogin = new CurrentAdminSession(admin.getAdminId(), LocalDateTime.now(), key);
	currAdminSessionDao.save(newAdminLogin);
	
		return "You have been Successfully loggedIn...!";
	}

}
