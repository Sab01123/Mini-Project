package com.product.service;

import com.product.exception.AdminException;
import com.product.model.Category;

public interface CategoryService {

	public Category addCategory(String uuid, Category category)throws AdminException;
}
