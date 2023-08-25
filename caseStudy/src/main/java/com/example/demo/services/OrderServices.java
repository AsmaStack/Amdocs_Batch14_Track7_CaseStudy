package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Orders;
import com.example.demo.repository.OrdersRepo;

@Controller
public class OrderServices {

	private OrdersRepo orderrepository;

	@Autowired
	public OrderServices(OrdersRepo repo) {
		this.orderrepository = repo;
	}

	// create order
	public Orders createOrder(Long id,Orders order) {
		return orderrepository.save(order);
	}
	//

	public List<Orders> getOrders() {
		return orderrepository.findAll();
	}

	public Optional<Orders> getOrderById(long id) {
		
		return orderrepository.findById(id);
	}

	public Orders updateOrderName(long id, @RequestBody Orders ord) {
		Orders orderFound = orderrepository.findById(id).orElse(null);
		if (orderFound != null) {
//			orderFound.setProductQuantity(ord.getProductQuantity());
//			orderFound.setProductPrice(ord.getProductPrice());
			orderFound.setProductName(ord.getProductName());
		}
		// save entity to database
		return orderrepository.save(orderFound);
	}

	// update order
	public Orders updateOrder(long id, @RequestBody Orders ord) {
		Orders orderFound = orderrepository.findById(id).orElse(null);
		if (orderFound != null) {
			orderFound.setProductQuantity(ord.getProductQuantity());
			orderFound.setProductPrice(ord.getProductPrice());
		}
		// save entity to database
		return orderrepository.save(orderFound);
	}



}
