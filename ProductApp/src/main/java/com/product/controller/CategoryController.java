package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.exception.AdminException;
import com.product.model.Category;
import com.product.service.CategoryServiceImpl;

@RestController
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@PostMapping("/addcategory/{uuid}")
	public ResponseEntity<Category> addNewCategory(@PathVariable("uuid") String uuid,@RequestBody Category category) throws AdminException{
		
		Category addCategory = categoryServiceImpl.addCategory(uuid, category);
		
	return	new ResponseEntity<>(addCategory, HttpStatus.CREATED);
		
	}
}
