package com.amdocs.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.orders.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> 
{
	
}