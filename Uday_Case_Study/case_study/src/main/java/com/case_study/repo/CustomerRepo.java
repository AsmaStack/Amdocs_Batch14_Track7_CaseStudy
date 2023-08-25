package com.case_study.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.case_study.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
