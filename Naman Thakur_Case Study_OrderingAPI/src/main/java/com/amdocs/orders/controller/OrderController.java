package com.amdocs.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.orders.model.Customers;
import com.amdocs.orders.model.Orders;
import com.amdocs.orders.service.CustomerService;
import com.amdocs.orders.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController 
{

    
    private final CustomerService customerService;
    
    
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderservice,CustomerService customerService) {
		this.customerService = customerService;
		this.orderService =orderservice;
		// TODO Auto-generated constructor stub
	}
    // Create a new customer
    @PostMapping("/customers/create")
    public Customers createCustomer(@RequestBody Customers customer) {
        return customerService.createCustomer(customer);
    }

    // Get all customers
    @GetMapping("/customers/list")
    public List<Customers> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/customers/{customerId}")
    public Customers getCustomerById(@PathVariable Long cid) {
        return customerService.getCustomerById(cid);
    }

    // Update customer by ID
    @PutMapping("/customers/{customerId}/update")
    public Customers updateCustomer(@PathVariable Long cid, @RequestBody Customers updatedCustomer) {
        return customerService.updateCustomer(cid, updatedCustomer);
    }

    // Delete customer by ID
    @DeleteMapping("/customers/{customerId}/delete")
    public void deleteCustomer(@PathVariable Long cid) {
        customerService.deleteCustomer(cid);
    }

    // Create a new order for a customer
    @PostMapping("/orders/create/{cid}")
    public Orders createOrder(@PathVariable Long cid, @RequestBody Orders order) {
    	
        return orderService.createOrder(cid, order);
    }

    // Get all orders for a customer
    @GetMapping("/orders/customer/{customerId}")
    public List<Orders> getAllOrdersForCustomer(@PathVariable Long cid) {
        return orderService.getAllOrdersForCustomer(cid);
    }

    // Get order by ID
    @GetMapping("/orders/{orderId}")
    public Orders getOrderById(@PathVariable Long oid) {
        return orderService.getOrderById(oid);
    }

    // Update order by ID
    @PutMapping("/orders/{orderId}/update")
    public Orders updateOrder(@PathVariable Long cid, @PathVariable Long oid, @RequestBody Orders updatedOrder) throws AccessDeniedException {
        return orderService.updateOrder(cid, oid, updatedOrder);
    }

    // Delete order by ID
    @DeleteMapping("/orders/{orderId}/delete")
    public void deleteOrder(@PathVariable Long oid) {
        orderService.deleteOrder(oid);
    }
}
