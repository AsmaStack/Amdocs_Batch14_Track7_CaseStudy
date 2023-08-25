package com.OrderingAPI.OrderingAPIApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderingAPI.OrderingAPIApplication.model.Customer;
import com.OrderingAPI.OrderingAPIApplication.model.Orders;
import com.OrderingAPI.OrderingAPIApplication.repo.CustomerRepo;
import com.OrderingAPI.OrderingAPIApplication.repo.OrderRepo;


@Service
public class OrderService {
	private CustomerRepo crepo;
	private OrderRepo orepo;
//	public List<Customer> customerList;
	@Autowired
	public OrderService(OrderRepo orepo) {
		
		this.orepo = orepo;
	}
	
	
	   public List<Orders> getAllOrder() {
	        return orepo.findAll();
	    }
	   

	    public Orders getOrderById(Long id) {
	        return orepo.findById(id).orElse(null);
	    }
//	    
//	    public Customer getOrderByCustomerId(Long id) {
//	         crepo.findById(id).orElse(null);
//	    }

	    public Orders createOrder(Orders order) {
	        return orepo.save(order);
	    }

	    public Orders updateOrder(Long id, Orders order) {
	        Orders existingOrder = orepo.findById(id).orElse(null);
	        if (existingOrder != null) {
	            existingOrder.setOrder_id(order.getOrder_id());
	              return orepo.save(existingOrder);
	        }
	        return null;
	    }
	    
//	    public Customer getCustomerByOrderCId(Long id){
//	    	 return crepo.findById(id).orElse(null);	    	
//	    }
//	    
//	    public List<Customer> getCustomerByOrderId(Long id){
//	    	customerList.add(getCustomerByOrderCId(id));
//	    	return customerList;
//	    }
	    
	    
	   
	    public void deleteOrder(Long id) {
	        orepo.deleteById(id);
	    }
	
	
	
}