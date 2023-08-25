package com.amdocs.SpringBootCustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.SpringBootCustomer.model.Customers;
import com.amdocs.SpringBootCustomer.model.Orders;
import com.amdocs.SpringBootCustomer.repo.CustomerRepo;
import com.amdocs.SpringBootCustomer.repo.OrderRepo;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private CustomerRepo customerRepository;

    public Orders createOrder(Long customerId, Orders order) {
        Customers customer = customerRepository.findById(customerId).orElse(null);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    public Orders updateOrder(Long customerId, Long orderId, Orders updatedOrder) {
        Customers customer = customerRepository.findById(customerId).orElse(null);

        Orders existingOrder = orderRepository.findByCustomerAndOrderId(customer, orderId);
        if(existingOrder != null) {
        existingOrder.setTime_of_order(updatedOrder.getTime_of_order());
        existingOrder.setOrder_cost(updatedOrder.getOrder_cost());
        existingOrder.setOrder_status(updatedOrder.getOrder_status());

        return orderRepository.save(existingOrder);
        }
        return null;
    }

    public List<Orders> getOrdersByCustomerId(Long customerId) {
        Customers customer = customerRepository.findById(customerId).orElse(null);
        return orderRepository.findByCustomer(customer);
    }

    public Orders getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public String getOrderStatus(Long orderId) {
        Orders order = orderRepository.findById(orderId).orElse(null);
        return order.getOrder_status();
    }
}
