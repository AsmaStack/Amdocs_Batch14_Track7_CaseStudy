package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService {
	private CustomerRepo crepo;
    @Autowired
    public CustomerService(CustomerRepo crepo) {
   	 this.crepo=crepo;
    }
	public List<Customer> getAllCustomers(){
		return crepo.findAll();
		 
	 }
	public Customer createCustomer(Customer customer) {
		 return crepo.save(customer);
	 }
	public Customer getCustomerById(Long id) {
		 return crepo.findById(id).orElse(null);
	 }
	public Customer updateCustomer(Long customer_id, Customer customer) { 
		Customer existingCustomer = crepo.findById(customer_id).orElse(null);
		if (existingCustomer != null) {		
			existingCustomer.setCustomer_id (customer.getCustomer_id()); 
			existingCustomer.setCustomer_name (customer.getCustomer_name());		
			return crepo.save (existingCustomer);
	}
	
		return null;
	}
	public void deleteCustomer (Long customer_id) { 
	     crepo.deleteById(customer_id);
   }
}

