package com.amdocs.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.FinalProject.Exception.CustomerDoesnotExistException;
import com.amdocs.FinalProject.model.Orders;
import com.amdocs.FinalProject.model.customer;
import com.amdocs.FinalProject.repo.CustomerRepo;
import com.amdocs.FinalProject.repo.OrderRepo;

@Service
public class CustomerService {

	private CustomerRepo crepo;

	@Autowired
	public CustomerService(CustomerRepo crepo) {
		this.crepo = crepo;
	}

	public List<customer> getAllCustomers() {
		return crepo.findAll();
	}

	public customer getCustomerById(Long id) {
		return crepo.findById(id).orElse(null);
	}

	public customer createCustomer(customer customer) {
		return crepo.save(customer);
	}

	public customer updateCustomer(Long id, customer customer) {
		customer existingCustomer = crepo.findById(id).orElse(null);
		if (existingCustomer != null) {
			existingCustomer.setCustomer_name(customer.getCustomer_name());
			existingCustomer.setCustomer_id(customer.getCustomer_id());
			return crepo.save(existingCustomer);
		}
		return null;
	}

	public void deleteCustomer(Long id) {
		crepo.deleteById(id);
	}
	
	public customer getCustById(Long id) throws Exception {
		customer existingCust = crepo.findById(id).orElse(null);
		if(existingCust == null) {
			throw new CustomerDoesnotExistException();
		}
		else {
			return existingCust;
		}
	}

}
