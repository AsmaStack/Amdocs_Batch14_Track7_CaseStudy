package com.OrderingAPI.OrderingAPIApplication.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderingAPI.OrderingAPIApplication.model.Customer;
import com.OrderingAPI.OrderingAPIApplication.model.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
//		public List<Customer> getCustomerByOrderId(Long id);
}