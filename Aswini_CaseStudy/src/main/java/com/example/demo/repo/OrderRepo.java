package com.example.demo.repo;
import com.example.demo.model.Customer;
import com.example.demo.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public interface OrderRepo extends JpaRepository<Orders, Long>{
    List<Orders> findByCustomer(Customer customer);
    Orders findByCustomerAndOrderId(Customer customer, Long order_id);

}
