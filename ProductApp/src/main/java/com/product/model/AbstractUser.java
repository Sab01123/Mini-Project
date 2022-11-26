package com.product.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AbstractUser {

	private String name;
	private String email;
	@Column(unique = true)
	private String mobile;
	private String password;
}
