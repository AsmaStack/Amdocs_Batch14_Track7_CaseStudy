package com.project.exception;

public class OrderDoesNotExistException extends Exception{
	public OrderDoesNotExistException() {
		System.out.println("Order Id Does Not Exist !!");
	}
}
