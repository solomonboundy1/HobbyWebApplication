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
import com.qa.springbootsw.domain.SheetMusic;
import com.qa.springbootsw.domain.Shop;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {"classpath:sql-schema.sql", "classpath:sql-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class SheetMusicControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Shop shop = new Shop(1l, "shopname", "shopaddress");
		SheetMusic sheetMusic = new SheetMusic("music title", "music author", "music genre", 10.99, shop);
		String sheetMusicAsJSON = this.mapper.writeValueAsString(sheetMusic);
		RequestBuilder request = post("/sheetmusic/create").contentType(MediaType.APPLICATION_JSON).content(sheetMusicAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		SheetMusic sheetMusicSaved = new SheetMusic(2, "music title", "music author", "music genre", 10.99, shop);
		String sheetMusicSavedAsJSON = this.mapper.writeValueAsString(sheetMusicSaved);
		
		ResultMatcher checkBody = content().json(sheetMusicSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testCreate2() throws Exception {
		Shop shop = new Shop(1l, "shopname", "shopaddress");
		SheetMusic sheetMusic = new SheetMusic("music title", "music author", "music genre", 10.99, shop);
		String sheetMusicAsJSON = this.mapper.writeValueAsString(sheetMusic);
		RequestBuilder request = post("/sheetmusic/create").contentType(MediaType.APPLICATION_JSON).content(sheetMusicAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		SheetMusic sheetMusicSaved = new SheetMusic(2, "music title", "music author", "music genre", 10.99, shop);
		String sheetMusicSavedAsJSON = this.mapper.writeValueAsString(sheetMusicSaved);
		
		ResultMatcher checkBody = content().json(sheetMusicSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testReadAll() throws Exception {
		Shop shop = new Shop(1l, "MusicRoom Argents", "11 Denmark Street");
		SheetMusic sheet = new SheetMusic(1l, "OSCAR PETERSON: THE VERY BEST OF OSCAR PETERSON: PIANO SOLO", "Oscar Peterson", "Jazz", 10.99, shop);
		String sheetAsJSON = this.mapper.writeValueAsString(List.of(sheet));
		RequestBuilder request = get("/sheetmusic/getAll").contentType(MediaType.APPLICATION_JSON).content(sheetAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(sheetAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	@Test
	void testReadOne() throws Exception {
		
		Shop shop = new Shop(1l, "MusicRoom Argents", "11 Denmark Street");
		SheetMusic sheet = new SheetMusic(1l, "OSCAR PETERSON: THE VERY BEST OF OSCAR PETERSON: PIANO SOLO", "Oscar Peterson", "Jazz", 10.99, shop);
		String sheetAsJSON = this.mapper.writeValueAsString(sheet);
		RequestBuilder request = get("/sheetmusic/getOne/1").contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(sheetAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdate() throws Exception {
		
		Shop shop = new Shop(1l, "MusicRoom Argents", "11 Denmark Street");
		SheetMusic sheet = new SheetMusic(1l, "OSCAR PETERSON:ON THE SUNNY SIDE OF THE STREET", "Oscar P", "Jazzy", 11.99, shop);
		
		String sheetAsJSON = this.mapper.writeValueAsString(sheet);
		
		RequestBuilder request = put("/sheetmusic/update/1").contentType(MediaType.APPLICATION_JSON).content(sheetAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(sheetAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		
		RequestBuilder request = delete("/sheetmusic/delete/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(request).andExpect(checkStatus);
		
	}

}
