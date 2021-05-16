package com.qa.movies.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.movies.domain.Movies;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema.sql", "classpath:data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MoviesControllerIntergrationTesting {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Movies batman = new Movies("Batman", 2006, 90, "Action"); // create entry
		String batmanAsJSON = this.mapper.writeValueAsString(batman); // convert to JSON
		RequestBuilder mockRequest = post("/create") /// build the mock request
				.contentType(MediaType.APPLICATION_JSON).content(batmanAsJSON);

		Movies savedBatman = new Movies(2L, "Batman", 2006, 90, "Action"); /// create saved entry
		String savedBatmanAsJSON = this.mapper.writeValueAsString(savedBatman); /// convert to JSON

		ResultMatcher matchStatus = status().isCreated(); /// check if status 201 is created

		ResultMatcher matchBody = content().json(savedBatmanAsJSON); /// check if response body is correct

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testRead() throws Exception {
		Movies batman = new Movies(1L,"Batman", 2006, 90, "Action");
		
		List<Movies> MovieList = new ArrayList<>();
		MovieList.add(batman);
		String movieListAsJSON = this.mapper.writeValueAsString(MovieList);
		
		
		RequestBuilder mockRequest = get("/getAll");

		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(movieListAsJSON);
		

		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder mockRequest = delete("/remove/1"); // should i add /remove/1 ?

		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().string("false");

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void testUpdate() throws Exception {
		Movies batman = new Movies("Batman", 2012, 80, "Action");
		String batmanAsJSON = this.mapper.writeValueAsString(batman);
		RequestBuilder mockRequest = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(batmanAsJSON);
		

		Movies updatedBatman = new Movies(1L, "Batman", 2012, 80, "Action");
		String updatedBatmanAsJSON = this.mapper.writeValueAsString(updatedBatman);

		ResultMatcher matchStatus = status().isAccepted();
		ResultMatcher matchBody = content().json(updatedBatmanAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}
}

