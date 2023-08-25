package com.project.exception;

public class CustomerDoesNotExistException extends Exception {

	public CustomerDoesNotExistException() {
		System.out.println("Customer Id Does Not Exist !!");
	}
}
