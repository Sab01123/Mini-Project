package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.CategoryException;
import com.product.exception.ProductException;
import com.product.model.Category;
import com.product.model.CurrentAdminSession;
import com.product.model.Product;
import com.product.repository.CategoryDao;
import com.product.repository.CurrentAdminSessionDao;
import com.product.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private CurrentAdminSessionDao currAdminSessionDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Product addProduct(String uuid, Product product) throws ProductException, CategoryException {
		
		CurrentAdminSession existedAdmin = currAdminSessionDao.findByUuid(uuid);
		
		if( existedAdmin == null) {
			throw new ProductException("You are not loggedIn, Please logIn !");
		}
		
		
		Category findByCategoryName = categoryDao.findByCategoryName(product.getCategoryName());
		if(findByCategoryName==null) {
			throw new CategoryException("Category does not exsist");
		}
		
		product.setProductId(findByCategoryName.getCategoryId());
		
//		Category product2 = product.getProduct();
//		product.setProduct(product2);
		
	     List<Product>	listproduct = findByCategoryName.getProducts();
		 listproduct.add(product);
		
		return productDao.save(product);
	}

}
