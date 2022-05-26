package com.qa.springbootsw.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.springbootsw.domain.SheetMusic;
import com.qa.springbootsw.domain.Shop;

import com.qa.springbootsw.repo.SheetMusicRepo;
import com.qa.springbootsw.service.SheetMusicService;



@RunWith(MockitoJUnitRunner.class)
public class SheetMusicServiceUnitTest {
	
	@InjectMocks
	private SheetMusicService service;
	
	@Mock
	private SheetMusicRepo repo;
	
	@Test
	public void createTest() {
		Shop shop = new Shop(1l, "blah", "blah"); 
		SheetMusic input = new SheetMusic("Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop);
		SheetMusic output = new SheetMusic("Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop);
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		assertEquals(output, this.service.createSheetMusic(input));
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void getAllTest() {
		Shop shop = new Shop(1l, "blah", "blah"); 
		List<SheetMusic> output = new ArrayList<>();
		output.add(new SheetMusic("Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getOneTest() {
		Long id = 1L;
		Shop shop = new Shop(1l, "blah", "blah"); 
		SheetMusic output = new SheetMusic(1l, "Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(output));
		
		assertEquals(output, this.service.getOne(id));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);	
	}
	
	
	@Test
	public void updateTest() {
		Long id = 1L;
		Shop shop = new Shop(1l, "blah", "blah"); 
		Shop shop1 = new Shop(1l, "blah", "blah");
		SheetMusic oldSheet = new SheetMusic(1l, "Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop);
		SheetMusic newSheet = new SheetMusic(1l, "OSCAR PETERSON: THE VERY BEST OF OSCAR PETERSON: PIANO SOLO", "Oscar Peterson", "Jazz", 10.99, shop1);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldSheet));
		Mockito.when(this.repo.saveAndFlush(oldSheet)).thenReturn(newSheet);
		
		assertEquals(oldSheet, this.service.update(id, newSheet));
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(oldSheet);
	}
	
	@Test
	public void deleteTest() {
		
		long id = 1L;
		boolean deleted = true;
		
		Mockito.when(this.service.deleteSheetMusic(id)).thenReturn(deleted);
		
		assertEquals(deleted, this.repo.existsById(id));
		
	}

}
