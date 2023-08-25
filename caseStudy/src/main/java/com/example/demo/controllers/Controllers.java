 package com.example.demo.controllers;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customers;
import com.example.demo.models.Orders;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.services.CustomerServices;
import com.example.demo.services.OrderServices;

@RestController
@RequestMapping("/api")
//only response body then only payload(java object)
// status code+header+body ==== ResponseEntity<className>
public class Controllers {

	CustomerServices customerServices;
	private OrderServices orderService;

	@Autowired
	public Controllers(CustomerServices c, OrderServices o) {
		this.customerServices = c;
		this.orderService = o;

	}

//	//when  hit this end point take order details from user and
	@PostMapping("/createOrder/{id}")
	public Orders createOrder(@PathVariable Long id,@RequestBody Orders order) {
		
		return orderService.createOrder(id,order);
	}
	@GetMapping("/orders")
	public List<Orders> getOrders(){
		return orderService.getOrders();
	}
	@GetMapping("/order/byId/{id}")
	public Optional<Orders> OrderById(@PathVariable long id){
		return orderService.getOrderById(id);
	}
	//
	@PutMapping("/updateOrder/{id}")
	public Orders  updateOrder(@PathVariable long id,@RequestBody Orders ord) {
	return orderService.updateOrder(id, ord);
}
	@PutMapping("/updateOrder/name/{id}")
	public String  updateOrderName(@PathVariable long id,@RequestBody Orders ord) {
		orderService.updateOrderName(id, ord);
		return "order updated successfully "+id;
}

//	//neeed to take orderdetails input from user 
//	//customer details like customer name

	@PostMapping("/createCustomer")
	public Customers customerCreate(@RequestBody Customers customers) {
		return customerServices.saveCustomer(customers);
	}

	// getAllCutomers
	@GetMapping("/allCustomers")
	public List<Customers> GetallCustomers(Customers cust) {

		return customerServices.getAllCustomers(cust);
	}

	// getCustomerById
	@GetMapping("/customerById/{id}")
	public Optional<Customers> getCustomerById(@PathVariable long id) {
		return customerServices.getCustomerById(id);
	}

	// delete customer by id
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable long id) {
		customerServices.deleteCustomer(id);
		return "customer " + id + " deleted successfully";
	}

//updated customer giving id
	@PutMapping("/updateCustomer/{id}")
	public Customers updateCustomers(@PathVariable long id, @RequestBody Customers cust) {

		return customerServices.updateCustomer(id, cust);
	}
	@PutMapping("/updateCustomer/place/{id}")
	public Customers updateCustomerPlace(@PathVariable long id, @RequestBody Customers cust) {

		return customerServices.updateCustomerPlace(id, cust);
	}
	// order create

}
