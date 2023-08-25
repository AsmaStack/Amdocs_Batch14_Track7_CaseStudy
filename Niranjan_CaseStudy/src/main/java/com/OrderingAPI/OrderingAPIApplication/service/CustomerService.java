package com.OrderingAPI.OrderingAPIApplication.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderingAPI.OrderingAPIApplication.model.Customer;
import com.OrderingAPI.OrderingAPIApplication.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo crepo;
	
	@Autowired
	public CustomerService(CustomerRepo crepo) {
		
		this.crepo = crepo;
	}
	
	
	   public List<Customer> getAllCustomers() {
	        return crepo.findAll();
	    }
	   

	    public Customer getCustomerById(Long id) {
	        return crepo.findById(id).orElse(null);
	    }

	    public Customer createCustomer(Customer customer) {
	        return crepo.save(customer);
	    }

	 
	    public void deleteCustomer(Long id) {
	        crepo.deleteById(id);
	    }
	
}
