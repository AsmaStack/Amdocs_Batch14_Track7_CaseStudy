package com.amdocs.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.amdocs")
public class OrderingApiApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(OrderingApiApplication.class, args);
	}

}
