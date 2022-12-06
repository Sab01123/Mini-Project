package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.CurrentCustomerSession;
@Repository
public interface CurrentCustomerSessionDao extends JpaRepository<CurrentCustomerSession, Integer>{

	public CurrentCustomerSession findByUuid(String uuid);
}
