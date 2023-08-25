package com.amdocs.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.orders.model.Customers;
import com.amdocs.orders.repository.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    
    
@Autowired
    public CustomerService(CustomerRepository customerRepository) {
	
		this.customerRepository = customerRepository;
	}

	public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customers getCustomerById(Long cid) {
        return customerRepository.findById(cid)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public Customers updateCustomer(Long cid, Customers updatedCustomer) {
        // Check if the customer exists
        Customers existingCustomer = customerRepository.findById(cid)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        // Update customer details
        existingCustomer.setName(updatedCustomer.getName());
        // Update other customer attributes as needed
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long cid) {
        customerRepository.deleteById(cid);
    }
}
