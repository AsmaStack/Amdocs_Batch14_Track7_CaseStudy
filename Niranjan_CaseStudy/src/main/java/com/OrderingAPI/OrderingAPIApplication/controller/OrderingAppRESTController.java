package com.OrderingAPI.OrderingAPIApplication.controller;

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

import com.OrderingAPI.OrderingAPIApplication.model.Customer;
import com.OrderingAPI.OrderingAPIApplication.model.Orders;
import com.OrderingAPI.OrderingAPIApplication.service.CustomerService;
import com.OrderingAPI.OrderingAPIApplication.service.OrderService;


@RestController
@RequestMapping("/api/customers")
public class OrderingAppRESTController {

	private OrderService orderservice;
	private CustomerService customerservice;

	@Autowired
	public OrderingAppRESTController(CustomerService customerservice,OrderService orderservice) {
		
		this.customerservice = customerservice;
		this.orderservice = orderservice;
	}
	
	//select *From book;
    //http://localhost:8085/api/books/allbooks

    @GetMapping("/allcustomers")
    public List<Customer> getAllCustomers() {
        return customerservice.getAllCustomers();
    }
    
    //select *From book where book_id=121;
    //http://localhost:8085/api/books/121
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerservice.getCustomerById(id);
    }

   

 @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerservice.createCustomer(customer);
    }

//    @PutMapping("/{id}")
//    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
//        return customerservice.updateCustomer(id, customer);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Long id) {
//        orderservice.deleteCustomer(id);
//    }
//    
    ////////////////////////////////////////////////////

//	@Autowired
//	public OrderingAppRESTController(OrderService orderservice) {
//		
//		this.orderservice = orderservice;
//	}
//	
	//select *From book;
    //http://localhost:8085/api/books/allbooks

    @GetMapping("/allorders")
    public List<Orders> getAllOrders() {
        return orderservice.getAllOrder();
    }
    
    //select *From book where book_id=121;
    //http://localhost:8085/api/books/121
    @GetMapping("/order/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return orderservice.getOrderById(id);
    }

   

 @PostMapping("/create")
    public Orders createOrder(@RequestBody Orders order) {
        return orderservice.createOrder(order);
    }

    @PutMapping("/order/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
        return orderservice.updateOrder(id, order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderservice.deleteOrder(id);
    }
	
	
	
}