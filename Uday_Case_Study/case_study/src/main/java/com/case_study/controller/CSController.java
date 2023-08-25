package com.case_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.case_study.exception.CustomerAlreadyExistException;
import com.case_study.exception.CustomerDoesNotExistException;
import com.case_study.exception.OrderAlreadyExistException;
import com.case_study.exception.OrderDoesNotExistException;
import com.case_study.model.Customer;
import com.case_study.model.Orders;
import com.case_study.repo.CustomerRepo;
import com.case_study.repo.OrderRepo;
import com.case_study.service.CustomerService;
import com.case_study.service.OrderService;

@RestController
@RequestMapping("/api")
public class CSController {
	private OrderService oservice;
	private CustomerService cservice;
	private OrderRepo orepo;
	private CustomerRepo crepo;
	
	/*
	 * 
	 * 
	 * Controller options for Orders
	 * 
	 * 
	 */
	
	@Autowired
	public CSController(OrderService oservice, CustomerService cservice, OrderRepo orepo, CustomerRepo crepo) {
//		super();
		this.oservice = oservice;
		this.cservice = cservice;
		this.orepo = orepo;
		this.crepo = crepo;
	}
	
	// displaying the list
	@GetMapping("/order/display")
	public List<Orders> getAllOrders() {
		return oservice.getAllOrders();
	}
	
	// displaying the list based on id
	@GetMapping("/order/display/{id}")
	public Orders getOrderById(@PathVariable Long id) {
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.getOrderById(id);
		}
		return null;
	}
	
	// creating new order
	@PostMapping("/order/create/{id}")
	public Orders createOrder(@PathVariable Long id, @RequestBody Orders order) throws OrderAlreadyExistException {
		Orders o = orepo.findById(id).orElse(null);
		if(o != null) {
			try {
				throw new OrderAlreadyExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Already Exists!!!");
			}
		}
		else {
			return oservice.createOrder(id, order);
		}
		return null;
	}
	
	@PutMapping("/order/update/cust/{id}")
	public Orders updateOrderCustId(@PathVariable Long id, @RequestBody Orders order) {
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.updateOrderCustId(id, order);
		}
		return null;
	}
	
	// updating the order status by id
	@PutMapping("/order/update/status/{id}")
	public Orders updateOrderstatus(@PathVariable Long id, @RequestBody Orders order) {
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.updateOrderStatus(id, order);
		}
		return null;
	}
	
	// updating the order date by id
	@PutMapping("/order/update/date/{id}")
	public Orders updateOrderDate(@PathVariable Long id, @RequestBody Orders order) throws OrderDoesNotExistException{
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.updateOrderDate(id, order);
		}
		return null;
	}
	
	// deleting the order by id
	@DeleteMapping("/order/delete/{id}")
	public void deleteOrder(@PathVariable Long id) throws OrderDoesNotExistException{
		Orders o = orepo.findById(id).orElse(null);
		if (o == null) {
			try {
				throw new OrderDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+": Invalid Order ID!!!");
			}
		}
		else {
			oservice.deleteOrder(id);
			System.out.println("Successfully Deleted the Customer wtih id: "+id);
		}
	}
	
	/*
	 * 
	 * 
	 * Controller options for Customer
	 * 
	 * 
	 */
	
	// displaying the list
	@GetMapping("/customer/display")
	public List<Customer> getAllCustomers() {
		return cservice.getAllCustomer();
	}
	
	// displaying the list based on id
	@GetMapping("/customer/display/{id}")
	public Customer getCustomerById(@PathVariable Long id) throws CustomerDoesNotExistException{
		Customer c = crepo.findById(id).orElse(null);
		if(c == null) {
			try {
				throw new CustomerDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+": Invalid Customer ID!!!");
			}
		}
		else {
			return cservice.getCustomerById(id);
		}
		return null;
	}
	
	// creating new customer
	@PostMapping("/customer/create/{id}")
	public Customer createCustomer(@PathVariable Long id, @RequestBody Customer customer) throws CustomerAlreadyExistException{
		Customer c = crepo.findById(id).orElse(null);
		if(c != null) {
			try {
				throw new CustomerAlreadyExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Already Exists!!!");
			}
		}
		else {
			return cservice.createCustomer(customer);
		}
		return null;
	}
	
	// updating the customer by id
	@PutMapping("/customer/update/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) throws CustomerDoesNotExistException{
		Customer c = crepo.findById(id).orElse(null);
		if(c == null) {
			try {
				throw new CustomerDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Customer ID!!!");
			}
		}
		else {
			return cservice.updateCustomer(id, customer);
		}
		return null;
	}
	
	// deleting the customer by id
	@DeleteMapping("/customer/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) throws CustomerDoesNotExistException{
		Customer c = crepo.findById(id).orElse(null);
		if (c == null) {
			try {
				throw new CustomerDoesNotExistException();
			}
			catch (Exception e) {
				System.out.println(e+": Invalid Customer ID!!!");
			}
		}
		else {
			cservice.deleteCustomer(id);
			System.out.println("Successfully Deleted the Customer wtih id: "+id);
		}
	}
}
