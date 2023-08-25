package com.amdocs.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.orders.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> 
{

	List<Orders> findByCustomerId(Long cid);

}
