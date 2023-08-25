package com.project;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.controller.OrderController;
import com.project.model.Orders;
import com.project.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	@Test
	public void testGetAllOrder() throws Exception {
		List<Orders> mockOrders = new ArrayList<>();
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
		Long id = 8L;
        Orders mockOrder = new Orders();
        // Set properties of mockBook

        Mockito.when(orderService.createOrder(id, Mockito.any(Orders.class))).thenReturn(mockOrder);

        mockMvc.perform(post("/api/insertorder/{id}")
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
    }

}
