package com.qa.springbootsw.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.qa.springbootsw.domain.Shop;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {"classpath:sql-schema.sql", "classpath:sql-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ShopControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Shop shop = new Shop("shopName", "shopAddress");
		String shopAsJSON = this.mapper.writeValueAsString(shop);
		RequestBuilder request = post("/shop/create").contentType(MediaType.APPLICATION_JSON).content(shopAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Shop shopSaved = new Shop(2, "shopName", "shopAddress");
		String shopSavedAsJSON = this.mapper.writeValueAsString(shopSaved);
		
		ResultMatcher checkBody = content().json(shopSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testCreate2() throws Exception {
		Shop shop = new Shop("shopName", "shopAddress");
		String shopAsJSON = this.mapper.writeValueAsString(shop);
		RequestBuilder request = post("/shop/create").contentType(MediaType.APPLICATION_JSON).content(shopAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Shop shopSaved = new Shop(2, "shopName", "shopAddress");
		String shopSavedAsJSON = this.mapper.writeValueAsString(shopSaved);
		
		ResultMatcher checkBody = content().json(shopSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReadAll() throws Exception {
		
		Shop shop = new Shop(1l, "MusicRoom Argents", "11 Denmark Street");
		String shopAsJSON = this.mapper.writeValueAsString(List.of(shop));
		RequestBuilder request = get("/shop/getAll").contentType(MediaType.APPLICATION_JSON).content(shopAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(shopAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	@Test
	void testReadOne() throws Exception {
		
		Shop shop = new Shop(1, "MusicRoom Argents", "11 Denmark Street");
		String shopAsJSON = this.mapper.writeValueAsString(shop);
		RequestBuilder request = get("/shop/getOne/1").contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(shopAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdate() throws Exception {
		
		Shop shop = new Shop(1, "shoppppp", "addddd");
		
		String shopAsJSON = this.mapper.writeValueAsString(shop);
		
		RequestBuilder request = put("/shop/update/1").contentType(MediaType.APPLICATION_JSON).content(shopAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(shopAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		
		RequestBuilder request = delete("/shop/delete/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(request).andExpect(checkStatus);
		
	}
	
	
}
