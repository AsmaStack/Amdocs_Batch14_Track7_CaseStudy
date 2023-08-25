package com.OrderingAPI.OrderingAPIApplication;




import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.OrderingAPI.OrderingAPIApplication.controller.OrderingAppRESTController;
import com.OrderingAPI.OrderingAPIApplication.model.Orders;
import com.OrderingAPI.OrderingAPIApplication.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(com.OrderingAPI.OrderingAPIApplication.controller.OrderingAppRESTController.class)
public class ControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private com.OrderingAPI.OrderingAPIApplication.service.OrderService orderService;

	    @Test
	    public void testGetAllBooks() throws Exception {
	        List<Orders> mockOrders = new ArrayList<>();
	        // Add mock Book objects to mockBooks list

	        Mockito.when(orderService.getAllOrder()).thenReturn(mockOrders);

	        mockMvc.perform(get("/api/order/allorders"))
	            .andExpect(status().isOk())
	            .andExpect((ResultMatcher) jsonPath("$", hasSize(mockOrders.size())));
	    }

	    private Object hasSize(int size) {
			// TODO Auto-generated method stub
			return null;
		}


	    @Test
	    public void testCreateOrder() throws Exception {
	        Orders mockOrder= new Orders();
	        // Set properties of mockBook

	        Mockito.when(orderService.createOrder(Mockito.any(Orders.class))).thenReturn(mockOrder);

	        mockMvc.perform(post("/api/orders")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(asJsonString(mockOrder)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.id", is(mockOrder.getOrder_id())));
	            // Add more assertions for other properties
	    }

	  
	

	    // Helper method to convert objects to JSON string
	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }}