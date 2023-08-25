package com.amdocs.FinalProject.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customer_id;
	private String customer_name;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Orders> orders = new HashSet<>();

	public customer() {
		// TODO Auto-generated constructor stub
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

}
