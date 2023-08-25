package com.amdocs.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.FinalProject.Exception.OrderDoesnotExistException;
import com.amdocs.FinalProject.model.Orders;
import com.amdocs.FinalProject.repo.OrderRepo;

@Service
public class OrderService {
	private OrderRepo orepo;

	@Autowired
	public OrderService(OrderRepo orepo) {
		this.orepo = orepo;
	}

	public List<Orders> getAllOrders() {
		return orepo.findAll();
	}

	public Orders getOrderById(Long id) {
		return orepo.findById(id).orElse(null);
	}

	public Orders createOrder(long id,Orders order) {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if(existingOrder == null) {
			return orepo.save(order);
		}
		return null;
	}

	public Orders updateOrder(Long id, Orders order) {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if (existingOrder != null) {
			existingOrder.setOrder_id(order.getOrder_id());
			existingOrder.setCustomer(order.getCustomer());
			existingOrder.setOrder_item(order.getOrder_item());
			existingOrder.setOrder_date(order.getOrder_date());
			return orepo.save(existingOrder);
		}
		return null;
	}
	
	public Orders updateOrderStatus(Long id, Orders order) {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if(existingOrder != null) {
			existingOrder.setOrder_status(order.getOrder_status());
			return orepo.save(existingOrder);
		}
		return null;
	}

	public void deleteOrder(Long id) {
		orepo.deleteById(id);
	}
	
	public Orders getOrderById1(Long id) throws Exception {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if(existingOrder == null) {
			throw new OrderDoesnotExistException();
		}
		else {
			return existingOrder;
		}
	}

}
