package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Orders;
import com.project.repo.OrderRepo;

@Service
public class OrderService {
	
	private OrderRepo orderRepo;

	@Autowired
	public OrderService(OrderRepo orderRepo) {
//		super();
		this.orderRepo = orderRepo;
	}
	
	public List<Orders> getAllOrder() {
		return orderRepo.findAll();
	}
	
	public Orders getOrderById(Long id) {
		return orderRepo.findById(id).orElse(null);
	}
	
	public Orders createOrder(Long id, Orders order) {
		Orders existingorder = orderRepo.findById(id).orElse(null);
		if(existingorder == null) {
			return orderRepo.save(order);
		}
		return null;
//		return orderRepo.save(order);
	}
	
	public Orders updateOrder(Long id, Orders order) {
		Orders existingorder = orderRepo.findById(id).orElse(null);
		if(existingorder != null) {
			existingorder.setOrder_id(order.getOrder_id());
			existingorder.setOrder_date(order.getOrder_date());
			existingorder.setCust(order.getCust());
			return orderRepo.save(existingorder);
		}
		return null;
	}
	
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
	}
}
