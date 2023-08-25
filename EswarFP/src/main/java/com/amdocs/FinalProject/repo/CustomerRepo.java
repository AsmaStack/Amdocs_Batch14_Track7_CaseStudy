package com.amdocs.FinalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.FinalProject.model.customer;

@Repository
public interface CustomerRepo extends JpaRepository<customer, Long> {

}
