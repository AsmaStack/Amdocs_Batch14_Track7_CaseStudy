package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.OrderRepo;

@Service
public class OrderService {
	private OrderRepo orepo;
	private CustomerRepo crepo;
	
	@Autowired
	public OrderService(OrderRepo orepo,CustomerRepo customerRepo) {
		this.orepo=orepo;
		this.crepo=customerRepo;
	}
	public List<Orders> getAllOrders(){
		return orepo.findAll();

	}
	public Orders addOrder(Long customer_id,Orders order) {
		Customer customer = crepo.findById(customer_id).orElse(null);
		order.setCustomer(customer);
		return orepo.save(order);
	}
	public Orders getOrderById(Long customer_id) {
		return orepo.findById(customer_id).orElse(null);
	}
	public Orders updateOrder(Long id, Orders order) { 
		Orders existingOrder = orepo.findById(id).orElse(null);
		if (existingOrder != null) {		
			existingOrder.setorderId (order.getorderId()); 
			existingOrder.setOrder_name (order.getOrder_name());
			existingOrder.setOrder_quantity(order.getOrder_quantity());
			return orepo.save (existingOrder);
		}

		return null;
	}
	public Orders updateOrder(Long customerId, Long orderId, Orders updatedOrder) {
		Customer customer = crepo.findById(customerId).orElse(null);

		Orders existingOrder = orepo.findByCustomerAndOrderId(customer, orderId);
		if(existingOrder != null) {
			existingOrder.setOrder_status(updatedOrder.getOrder_status());

			return orepo.save(existingOrder);
		}
		return null;
	}

	public List<Orders> getOrdersByCustomerId(Long customerId) {
		Customer customer = crepo.findById(customerId).orElse(null);
		return orepo.findByCustomer(customer);

	}

	public void deleteOrder (Long id) { 
		orepo.deleteById(id);
	}
}



