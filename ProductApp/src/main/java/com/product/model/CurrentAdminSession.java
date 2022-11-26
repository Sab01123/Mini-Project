package com.product.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CurrentAdminSession {

	@Id
	private Integer adminId;

	private LocalDateTime time;

	@Column(unique = true)
	private String uuid;
}
