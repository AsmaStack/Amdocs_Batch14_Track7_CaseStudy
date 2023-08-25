package com.amdocs.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.orders.model.Customers;
import com.amdocs.orders.model.Orders;
import com.amdocs.orders.repository.CustomerRepository;
import com.amdocs.orders.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class OrderService {

  
    private OrderRepository orderRepository;

    
    private CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
		super();
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
	}

	public Orders createOrder(Long cid, Orders order) {
        // Check if the customer exists
        Customers customer = customerRepository.findById(cid)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

      
        return orderRepository.save(order);
    }

    public List<Orders> getAllOrdersForCustomer(Long cid) {
        // Check if the customer exists
        customerRepository.findById(cid)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        return orderRepository.findByCustomerId(cid);
    }

    public Orders getOrderById(Long oid) {
        return orderRepository.findById(oid)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public Orders updateOrder(Long cid, Long oid, Orders updatedOrder) throws AccessDeniedException {
        // Check if the customer exists
        customerRepository.findById(cid)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        // Check if the order exists and is associated with the customer
        Orders existingOrder = orderRepository.findById(oid)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        if (!existingOrder.getId().equals(cid)) {
            throw new AccessDeniedException("Access to the order is denied");
        }

        // Update order details
        existingOrder.setOrderName(updatedOrder.getOrderName());
        // Update other order attributes as needed
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
