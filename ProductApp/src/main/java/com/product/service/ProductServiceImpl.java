package com.product.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.product.exception.CategoryException;
import com.product.exception.CustomerException;
import com.product.exception.ProductException;
import com.product.model.Category;
import com.product.model.CurrentAdminSession;
import com.product.model.CurrentCustomerSession;
import com.product.model.Product;
import com.product.productSorting.ProductSortOnPriceAsc;
import com.product.productSorting.ProductSortOnPriceDesc;
import com.product.repository.CategoryDao;
import com.product.repository.CurrentAdminSessionDao;
import com.product.repository.CurrentCustomerSessionDao;
import com.product.repository.CustomerDao;
import com.product.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private CurrentAdminSessionDao currAdminSessionDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CurrentCustomerSessionDao currentCustomerSessionDao;

	@Override
	public Product addProduct(String uuid, Product product) throws ProductException, CategoryException {
		
		CurrentAdminSession existedAdmin = currAdminSessionDao.findByUuid(uuid);
		
		if( existedAdmin == null) {
			throw new ProductException("You are not loggedIn, Please logIn !");
		}
			
		Optional<Category> findByCategoryName = categoryDao.findById(product.getCategory().getCategoryId());
		if(!findByCategoryName.isPresent()) {
			throw new CategoryException("Category does not exsist");
		}
		
	     List<Product>	listproduct = findByCategoryName.get().getProducts();
		 listproduct.add(product);
		
		return productDao.save(product);
	}

	@Override
	public List<Product> searchProduct(String uuid, String productName)throws CustomerException, ProductException {
		
		CurrentCustomerSession customer = currentCustomerSessionDao.findByUuid(uuid);
		
		if(customer == null) {
			throw  new CustomerException("You are not loggedIn");
		}
		
		List<Product> products = productDao.findByProductName(productName);
		
		if(products.size()==0) {
			throw new ProductException("There is no products available");
		}
		return products;
	}

	@Override
	public List<Product> viewProducts(String uuid, String sortingOrder,int pageSize,int pageNumber) throws CustomerException,ProductException {
	CurrentCustomerSession customer = currentCustomerSessionDao.findByUuid(uuid);
		
		if(customer == null) {
			throw  new CustomerException("You are not loggedIn");
		}
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		Page<Product> productPage = productDao.findAll(page);
		
		List<Product> products = productPage.getContent();
		
		
		if(products.size()==0) {
			throw new ProductException("There is no products available");
		}
		if(sortingOrder.equalsIgnoreCase("low-high")) {
			Collections.sort(products,new ProductSortOnPriceAsc());
		}
		else if(sortingOrder.equalsIgnoreCase("high-low")) {
			Collections.sort(products,new ProductSortOnPriceDesc());
		}
		
		return  products;
		
	}

	@Override
	public List<Product> searchProductByCategory(String uuid, String categoryName) throws CustomerException, ProductException {
	CurrentCustomerSession customer = currentCustomerSessionDao.findByUuid(uuid);
		
		if(customer == null) {
			throw  new CustomerException("You are not loggedIn");
		}
		
		Category category = categoryDao.findByCategoryName(categoryName);
		List<Product> products = category.getProducts();
		
		if(products.size()==0) {
			throw new ProductException("There is no products available");
		}
		return products;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
