package com.amdocs.FinalProject.controller;

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

import com.amdocs.FinalProject.model.Orders;
import com.amdocs.FinalProject.model.customer;
import com.amdocs.FinalProject.service.CustomerService;
import com.amdocs.FinalProject.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	private OrderService oservice;
	private CustomerService cservice;

	@Autowired
	public OrderController(OrderService oservice, CustomerService cservice) {
		this.oservice = oservice;
		this.cservice = cservice;
	}

	@GetMapping("/orders/allorders")
	public List<Orders> getAllOrders() {
		return oservice.getAllOrders();
	}

	@GetMapping("/customers/allcustomers")
	public List<customer> getAllCustomers() {
		return cservice.getAllCustomers();
	}

	@PostMapping("/insertorder/{id}")
	public Orders createOrder(@PathVariable long id,@RequestBody Orders order) {
		return oservice.createOrder(id,order);
	}

	@PostMapping("/customers")
	public customer createCustomer(@RequestBody customer customer) {
		return cservice.createCustomer(customer);
	}
	
	@PutMapping("/customers/{id}")
	public customer updateCustomer(@PathVariable Long id, @RequestBody customer customer) {
		return cservice.updateCustomer(id, customer);
	}
	
	@PutMapping("/orders/{id}")
	public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
		return oservice.updateOrder(id, order);
	}
	
	@PutMapping("/order/status/{id}")
	public Orders updateOrderStatus(@PathVariable Long id, @RequestBody Orders order) {
		return oservice.updateOrderStatus(id, order);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		cservice.deleteCustomer(id);
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable Long id) {
		oservice.deleteOrder(id);
	}
	
	public Orders getOrderById(Long id) throws Exception {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if(existingOrder == null) {
			throw new OrderDoesNotExistException();
		}
		else {
			return existingOrder;
		}
	}
	
	
}


