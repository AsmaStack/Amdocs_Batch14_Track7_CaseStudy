package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String order_name;
	private Long order_quantity;
	private String order_status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Long getorderId() {
		return orderId;
	}

	public void setorderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public Long getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Long order_quantity) {
		this.order_quantity = order_quantity;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
