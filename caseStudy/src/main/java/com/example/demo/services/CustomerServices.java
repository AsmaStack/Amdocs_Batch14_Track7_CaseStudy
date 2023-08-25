package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.models.Customers;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.services.*;


@Component
public class CustomerServices {
	@Autowired
	CustomerRepo customerRepository;

//	OrderServices products = new OrderServices();
	// create customer and store in the database
	public Customers saveCustomer(Customers consumer) {
		return customerRepository.save(consumer);
	}

	// view all customers
	public List<Customers> getAllCustomers(Customers customers) {
		List<Customers> allCustomers = customerRepository.findAll();
		return allCustomers;

	}

	public Optional<Customers> getCustomerById(long id) {
		Optional<Customers> customerById = customerRepository.findById(id);
		return customerById;
	}

	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	// update customer
	// optional type has various methods
	public Customers updateCustomer(Long id,Customers cus) {
		// find entity details by id and store into entity object
		Customers customer = customerRepository.findById(id).orElse(null);

		if(customer != null) {
			// modify entity informations
			customer.setCustomerName(cus.getCustomerName());
			customer.setCustomerPlace(cus.getCustomerPlace());
			
		}
	

		// save updated entity into database
		return customerRepository.save(customer);

	}
	public Customers updateCustomerPlace(Long id,Customers cus) {
		// find entity details by id and store into entity object
		Customers customer = customerRepository.findById(id).orElse(null);

		if(customer != null) {
			// modify entity informations
			
			customer.setCustomerPlace(cus.getCustomerPlace());
			
		}
		return customerRepository.save(customer);

	}

}
