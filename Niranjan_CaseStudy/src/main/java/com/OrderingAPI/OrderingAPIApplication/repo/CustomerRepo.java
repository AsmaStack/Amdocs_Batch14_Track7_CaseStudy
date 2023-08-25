package com.OrderingAPI.OrderingAPIApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderingAPI.OrderingAPIApplication.model.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
	

}
