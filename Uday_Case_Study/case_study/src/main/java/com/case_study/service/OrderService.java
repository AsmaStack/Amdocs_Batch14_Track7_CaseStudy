package com.case_study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.case_study.model.Orders;
import com.case_study.repo.OrderRepo;

@Service
public class OrderService {
	
	private OrderRepo orepo;
	
	@Autowired
	public OrderService(OrderRepo orepo) {
//		super();
		this.orepo = orepo;
	}
	
	public List<Orders> getAllOrders() {
		return orepo.findAll();
	}
	
	public Orders getOrderById(Long id) {
		return orepo.findById(id).orElse(null);
	}

	public Orders createOrder(Long id, Orders order) {
		Orders existOrder = orepo.findById(id).orElse(null);
		if(existOrder == null) {
			return orepo.save(order);
		}
		return null;
	}
	
	public Orders updateOrderCustId(Long id, Orders order) {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if (existingOrder != null) {
			existingOrder.setCustomer(order.getCustomer());
			System.out.println("Successfully Updated the Customer Info for Order id: "+id);
			return orepo.save(existingOrder);
		}
		return null;
	}
	/*
	 * json Format
	 * 
	 * {
	 * 	"customer": {
	 * 		"customer_id":1
	 * 	}
	 * }
	 * 
	 */
	
	public Orders updateOrderStatus(Long id, Orders order) {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if (existingOrder != null) {
			existingOrder.setOrder_status(order.getOrder_status());
			System.out.println("Successfully Updated the Order Status with Order id: "+id);
			return orepo.save(existingOrder);
		}
		return null;
	}
	/*
	 * json Format
	 * {
	 * 	"order_status":"Shipped"
	 * }
	 */
	
	public Orders updateOrderDate(Long id, Orders order) {
		Orders existingOrder = orepo.findById(id).orElse(null);
		if (existingOrder != null) {
			existingOrder.setOrder_date(order.getOrder_date());
			System.out.println("Successfully Updated the Order Date with Order id: "+id);
			return orepo.save(existingOrder);
		}
		return null;
	}
	/*
	 * json Format
	 * {
	 * 	"order_date":"20-09-2022"
	 * }
	 */
	
	public void deleteOrder(Long id) {
		orepo.deleteById(id);
	}
	/*
	 * json Format
	 * {
	 * 	"order_id":1
	 * }
	 */
}
