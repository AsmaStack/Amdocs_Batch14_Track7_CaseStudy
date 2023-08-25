package com.OrderingAPI.OrderingAPIApplication.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	private String productDescription;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "cid")
    private Customer customer;

	  public Orders(String productDescription, Customer customer) {
	        this.productDescription = productDescription;
	        this.customer = customer;
      
	    }
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getOrder_id() {
		return order_id;
	}
	
	

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }
	    public Customer getCustomer() {
	        return customer;
	    }
//	    public Customer getCustomerByOrderId(Long id) {
//	    	  Customer customer1 = CustomerRepo.getCustomerByOrderId(id); 	 
//	    		 return customer1;
//	    	 
//		     
//	    }
//	
	   public String getProductDescription() {
	        return productDescription;
	    }

	    public void setProductDescription(String productDescription) {
	        this.productDescription = productDescription;
	    }
	    
	    
	    

}