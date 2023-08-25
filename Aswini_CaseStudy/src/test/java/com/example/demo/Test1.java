package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.controller.OrderController;
import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class Test1 {
	
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private OrderService orservice;
        private CustomerService cuservice;
	    @Test
	    public void testGetAllOrders() throws Exception {
	        List<Orders> mockOrders = new ArrayList<>();

	        Mockito.when(orservice.getAllOrders()).thenReturn(mockOrders);

	        mockMvc.perform(get("/api/orders/allorders"))
	            .andExpect(status().isOk())
	            .andExpect((ResultMatcher) jsonPath("$", hasSize(mockOrders.size())));
	    }
	    private Object hasSize(int size) {
			// TODO Auto-generated method stub
			return null;
		}
	    @Test
	    public void testCreateCustomer() throws Exception {
	        Customer mockCustomer = new Customer();
	        // Set properties of mockBook

	        Mockito.when(cuservice.createCustomer(Mockito.any(Customer.class))).thenReturn(mockCustomer);

	        mockMvc.perform(post("/api/orders")
	            .content(asJsonString(mockCustomer)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.customer_id", is(mockCustomer.getCustomer_id())));
	            // Add more assertions for other properties
	    }
	    
	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
}
