package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.OrderDoesNotExistException;
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
	
	public Orders getOrderById(Long id) throws Exception {
		Orders existingOrder = orderRepo.findById(id).orElse(null);
		if(existingOrder == null) {
			throw new OrderDoesNotExistException();
		}
		else {
			return existingOrder;
		}
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
	
	public Orders updateOrderStatus(Long id, Orders order) {
		Orders existingOrder = orderRepo.findById(id).orElse(null);
		if(existingOrder != null) {
			existingOrder.setOrder_status(order.getOrder_status());
			return orderRepo.save(existingOrder);
		}
		return null;
	}
	
	
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
	}
}
