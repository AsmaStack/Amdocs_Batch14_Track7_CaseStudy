package com.amdocs.FinalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.FinalProject.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

}
