package com.product.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@OneToOne
	private Customer customer;
	
	@OneToMany
	private List<Product> products;
	
	@OneToOne
	private Orders order;
	
}
