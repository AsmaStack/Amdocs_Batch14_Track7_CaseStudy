package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long>{

}
