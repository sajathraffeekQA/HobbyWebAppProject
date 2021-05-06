package com.qa.movies.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.movies.domain.Movies;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MoviesControllerIntergrationTesting {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Movies batman = new Movies("Batman", 2006, 90, "Action"); //create entry
		String batmanAsJSON = this.mapper.writeValueAsString(batman); //convert to JSON
		RequestBuilder mockRequest = post("/create") ///build the mock request
				.contentType(MediaType.APPLICATION_JSON)
				.content(batmanAsJSON);
		
		Movies savedBatman = new Movies(1L, "Batman", 2006, 90, "Action"); ///create saved entry
		String savedBatmanAsJSON = this.mapper.writeValueAsString(savedBatman); ///convert to JSON
		
		ResultMatcher matchStatus = status().isCreated(); ///check if status 201 is created
		
		ResultMatcher matchBody = content().json(savedBatmanAsJSON); ///check if response body is correct
	
	this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	
	}
}
