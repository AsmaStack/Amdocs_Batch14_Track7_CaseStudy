package com.case_study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.case_study.model.Customer;
import com.case_study.repo.CustomerRepo;

@Service
public class CustomerService {
	
	private CustomerRepo crepo;
	
	@Autowired
	public CustomerService(CustomerRepo crepo) {
		this.crepo = crepo;
	}
	
	public List<Customer> getAllCustomer() {
		return crepo.findAll();
	}
	
	public Customer getCustomerById(Long id) {
		return crepo.findById(id).orElse(null);
	}
	
	public Customer createCustomer(Customer customer) {
		return crepo.save(customer);
	}
	
	public Customer updateCustomer(Long id, Customer customer) {
		Customer existingCustomer = crepo.findById(id).orElse(null);
		if (existingCustomer != null) {
			existingCustomer.setCustomer_name(customer.getCustomer_name());
			System.out.println("Successfully Updated the Customer Name wtih Customer id: "+id);
			return crepo.save(existingCustomer);
		}
		return null;
	}
	
	public void deleteCustomer(Long id) {
		crepo.deleteById(id);
	}
}
