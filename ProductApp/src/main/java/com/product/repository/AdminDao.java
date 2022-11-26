package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.product.model.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	
	public  Admin findByMobile(String mobile);
}
