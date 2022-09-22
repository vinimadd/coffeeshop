package com.example.coffeeshop;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class CoffeeshopApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"))
				.andExpect(content().string(containsString("Welcome to our coffee store!")));
	}

}
