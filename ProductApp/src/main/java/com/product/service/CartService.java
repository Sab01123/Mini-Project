package com.product.service;

import com.product.exception.CustomerException;
import com.product.exception.ProductException;

public interface CartService {

	public String addToCart(String uuid, Integer productId)throws CustomerException,ProductException;
}
