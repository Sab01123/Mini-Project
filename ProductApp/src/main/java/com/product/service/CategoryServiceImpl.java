package com.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.AdminException;
import com.product.model.Category;
import com.product.model.CurrentAdminSession;
import com.product.repository.CategoryDao;
import com.product.repository.CurrentAdminSessionDao;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private	CategoryDao categoryDao;
	@Autowired
	private	CurrentAdminSessionDao currentAdminSessionDao;

	@Override
	public Category addCategory(String uuid, Category category) throws AdminException {

		CurrentAdminSession findByUuid = currentAdminSessionDao.findByUuid(uuid);

		if(findByUuid==null) {
			throw new AdminException("kindly login as Admin");
		}

		category.setProducts(new ArrayList<>());
		
		Category saveCategory = categoryDao.save(category);

		return saveCategory;
	}

}
