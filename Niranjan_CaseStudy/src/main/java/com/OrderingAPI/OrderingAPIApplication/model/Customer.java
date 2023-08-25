package com.OrderingAPI.OrderingAPIApplication.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String name;
    
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<Orders> orders = new HashSet<>();

   public Customer() {
	// TODO Auto-generated constructor stub
}
   
   
public void setCid(Long cid) {
	this.cid = cid;
}


public void setName(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public Long getCid() {
	return cid;
}
}