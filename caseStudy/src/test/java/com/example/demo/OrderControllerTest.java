package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.controllers.Controllers;
import com.example.demo.models.Orders;
import com.example.demo.services.OrderServices;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@RunWith(SpringRunner.class)
@WebMvcTest(Controllers.class)
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OrderServices orderServices;

	@Test
	public void testOrders() throws Exception {
		List<Orders> mockBooks = new ArrayList<>();
		// Add mock Book objects to mockBooks list

		Mockito.when(orderServices.getOrders()).thenReturn(mockBooks);

		mockMvc.perform(get("/api/books/allbooks")).andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("$", hasSize(mockBooks.size())));
	}

}
