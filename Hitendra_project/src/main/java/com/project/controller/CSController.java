package com.project.controller;


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

import com.project.customExceptions.CutomerNotExistingException;
import com.project.customExceptions.ExistingCustomerException;
import com.project.customExceptions.ExistingOrderException;
import com.project.customExceptions.OrderNotExistingException;
import com.project.repo.CustomerRepo;
import com.project.repo.OrderRepo;
import com.project.model.Customer;
import com.project.model.Orders;
import com.project.service.CustomerService;
import com.project.service.OrderService;

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
		return oservice.getAllOrder();
	}
	
	// displaying the list based on id
	@GetMapping("/order/display/{id}")
	public Orders getOrderById(@PathVariable Long id) {
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderNotExistingException();
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
	public Orders createOrder(@PathVariable Long id, @RequestBody Orders order) throws ExistingCustomerException {
		Orders o = orepo.findById(id).orElse(null);
		if(o != null) {
			try {
				throw new ExistingOrderException();
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
				throw new OrderNotExistingException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.updateOrder(id, order);
		}
		return null;
	}
	
	// updating the order status by id
	@PutMapping("/order/update/status/{id}")
	public Orders updateOrderstatus(@PathVariable Long id, @RequestBody Orders order) {
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderNotExistingException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.updateOrder(id, order);
		}
		return null;
	}
	
	// updating the order date by id
	@PutMapping("/order/update/date/{id}")
	public Orders updateOrderDate(@PathVariable Long id, @RequestBody Orders order) throws OrderNotExistingException{
		Orders o = orepo.findById(id).orElse(null);
		if(o == null) {
			try {
				throw new OrderNotExistingException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Order ID!!!");
			}
		}
		else {
			return oservice.updateOrder(id, order);
		}
		return null;
	}
	
	// deleting the order by id
	@DeleteMapping("/order/delete/{id}")
	public void deleteOrder(@PathVariable Long id) throws OrderNotExistingException{
		Orders o = orepo.findById(id).orElse(null);
		if (o == null) {
			try {
				throw new OrderNotExistingException();
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
	public Customer getCustomerById(@PathVariable Long id) throws CutomerNotExistingException{
		Customer c = crepo.findById(id).orElse(null);
		if(c == null) {
			try {
				throw new CutomerNotExistingException();
			}
			catch (Exception e) {
				System.out.println(e+": Invalid Customer ID!!!");
			}
		}
		else {
			return cservice.getCustById(id);
		}
		return null;
	}
	
	// creating new customer
	@PostMapping("/customer/create/{id}")
	public Customer createCustomer(@PathVariable Long id, @RequestBody Customer customer) throws ExistingCustomerException{
		Customer c = crepo.findById(id).orElse(null);
		if(c != null) {
			try {
				throw new ExistingCustomerException();
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
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) throws CutomerNotExistingException{
		Customer c = crepo.findById(id).orElse(null);
		if(c == null) {
			try {
				throw new CutomerNotExistingException();
			}
			catch (Exception e) {
				System.out.println(e+" : Invalid Customer ID!!!");
			}
		}
		else {
			return cservice.updateCust(id, customer);
		}
		return null;
	}
	
	// deleting the customer by id
	@DeleteMapping("/customer/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) throws CutomerNotExistingException{
		Customer c = crepo.findById(id).orElse(null);
		if (c == null) {
			try {
				throw new CutomerNotExistingException();
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
