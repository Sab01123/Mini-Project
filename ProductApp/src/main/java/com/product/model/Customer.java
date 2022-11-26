package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
}
