package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.model.Customer;
import com.project.repo.CustomerRepo;

@Service
public class CustomerService {
	private CustomerRepo custRepo;

	@Autowired
	public CustomerService(CustomerRepo custRepo) {
//		super();
		this.custRepo = custRepo;
	}
	
	public List<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

	public Customer getCustById(Long id) {
		return custRepo.findById(id).orElse(null);
	}
	
	public Customer createCustomer(Customer cust) {
		return custRepo.save(cust);
	}
	
	public Customer updateCust(Long id, Customer cust) {
		Customer existingCust = custRepo.findById(id).orElse(null);
		if (existingCust != null) {
			existingCust.setCust_id(cust.getCust_id());
			existingCust.setCust_name(cust.getCust_name());
			return custRepo.save(existingCust);
		}
		return null;

	}

	public void deleteCustomer(Long id) {
		custRepo.deleteById(id);
	}
	
}
