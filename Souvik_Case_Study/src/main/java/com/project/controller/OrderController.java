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

import com.project.exception.OrderDoesNotExistException;
import com.project.model.Customer;
import com.project.model.Orders;
import com.project.service.CustomerService;
import com.project.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	private OrderService order_service;
	private CustomerService cust_service;

	@Autowired
	public OrderController(OrderService order_service, CustomerService cust_service) {
//		super();
		this.order_service = order_service;
		this.cust_service = cust_service;
	}

	@GetMapping("/order/allorders")
	public List<Orders> getAllOrder() {
		return order_service.getAllOrder();
	}
	
	@GetMapping("/order/{id}")
	public Orders getOrderById(@PathVariable Long id) {
		try {
			return order_service.getOrderById(id);
		} catch (Exception e) {
			System.out.println("Custom Exception");
		}
		return null;
	}

	@GetMapping("/customer/allcustomers")
	public List<Customer> getAllCustomer() {
		return cust_service.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustById(Long id) {
		try {
			return cust_service.getCustById(id);
		} catch (Exception e) {
			System.out.println("Custom Exception: Customer Id Does Not Exist !!");
		}
		return null;
	}

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer cust) {
		return cust_service.createCustomer(cust);
	}

	@PostMapping("/insertorder/{id}")
	public Orders createOrder(@PathVariable Long id, @RequestBody Orders order) {
		return order_service.createOrder(id, order);
	}

	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		return cust_service.updateCust(id, customer);
	}

	@PutMapping("/order{id}")
	public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
		return order_service.updateOrder(id, order);
	}

	@PutMapping("/order/status/{id}")
	public Orders updateOrderStatus(@PathVariable Long id, @RequestBody Orders order) {
		return order_service.updateOrderStatus(id, order);
	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		cust_service.deleteCustomer(id);
	}

	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable Long id) {
		order_service.deleteOrder(id);
	}
}
