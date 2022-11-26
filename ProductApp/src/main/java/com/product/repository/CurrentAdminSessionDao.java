package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.CurrentAdminSession;

public interface CurrentAdminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{

}
