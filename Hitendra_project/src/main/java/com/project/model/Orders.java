package com.project.model;


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
	private Long order_id;
//	private String product_name;
	private String order_date;
	private String order_status;
	
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
//	private Long cust_id;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

//	public String getProduct_name() {
//		return product_name;
//	}
//	
//	public void setProduct_name(String product_name) {
//		this.product_name = product_name;
//	}
	
	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public String getOrder_status() {
		return order_status;
	}
	
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Customer getCust() {
		return customer;
	}

	public void setCust(Customer customer) {
		this.customer = customer;
	}
	
	

//	public Long getCust_id() {
//		return cust_id;
//	}
//	
//	public void setCust_id(Long cust_id) {
//		this.cust_id = cust_id;
//	}
}
