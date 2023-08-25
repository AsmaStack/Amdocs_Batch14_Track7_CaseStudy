package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToMany
	private Long customerId;
	@Column(nullable = false)
	private String customerName;
public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	private String customerPlace;

	

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPlace() {
		return customerPlace;
	}

	public void setCustomerPlace(String customerPlace) {
		this.customerPlace = customerPlace;
	}

}
