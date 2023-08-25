package com.example.demo.controller;

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

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

	private OrderService oservice;
	private CustomerService cservice;


	@Autowired
	public OrderController(OrderService oservice, CustomerService cservice) {
		this.oservice = oservice;
		this.cservice = cservice;
	}

	@GetMapping("/allOrders")
	public List<Orders> getAllOrders(){
		return oservice.getAllOrders();
	}
	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomers(){
		return cservice.getAllCustomers();
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return cservice.createCustomer(customer);
	}
	@PutMapping("/customer/{customer_id}")
	public Customer updateCustomer(@PathVariable Long customer_id, @RequestBody Customer customer) {
		return cservice.updateCustomer(customer_id, customer);
	}
	@GetMapping("/customer/{customer_id}")
	public List<Orders> getOrdersByCustomerId(@PathVariable Long customer_id)
	{
		return  oservice.getOrdersByCustomerId(customer_id);
	}
	@GetMapping("/{orderId}")
	public Orders getOrderById(@PathVariable Long orderId) {
		return oservice.getOrderById(orderId);
	}

	@PostMapping("/create/{customer_id}")
	public Orders addOrder(@PathVariable Long customer_id, @RequestBody Orders order)
	{
		return oservice.addOrder(customer_id,order);
	}

	@PutMapping("/{customer_id}/{orderId}")
	public Orders updateOrder(@PathVariable Long customer_id ,@PathVariable Long orderId, @RequestBody Orders order)
	{
		return oservice.updateOrder(customer_id,orderId,order);
	}
	@DeleteMapping("/{customer_id}")
	public void deleteCustomer(@PathVariable Long customer_id) {
		cservice.deleteCustomer(customer_id);
	}

	@DeleteMapping("/{customer_id}/{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		oservice.deleteOrder(orderId);
	}
}

