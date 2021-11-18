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


import com.qa.springbootsw.domain.Shop;
import com.qa.springbootsw.repo.ShopRepo;
import com.qa.springbootsw.service.ShopService;



@RunWith(MockitoJUnitRunner.class)
public class ShopServiceUnitTest {
	
	@InjectMocks
	private ShopService service;
	
	@Mock
	private ShopRepo repo;
	
	
	@Test
	public void createTest() {
		Shop input = new Shop("shop1", "address1");
		Shop output = new Shop("shop1", "address1");
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		assertEquals(output, this.service.createShop(input));
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void getAllTest() {
		List<Shop> output = new ArrayList<>();
		output.add(new Shop("shop1", "address1"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getOneTest() {
		Long id = 1L;
		Shop output = new Shop(1l, "shop1", "address1");
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(output));
		
		assertEquals(output, this.service.getOne(id));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);	
	}
	
	
	@Test
	public void updateTest() {
		Long id = 1L; 
		Shop oldShop = new Shop(1l, "shop1", "address1");
		Shop newShop = new Shop(1l, "shop1", "address1");
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldShop));
		Mockito.when(this.repo.saveAndFlush(oldShop)).thenReturn(newShop);
		
		assertEquals(oldShop, this.service.update(id, newShop));
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(oldShop);
	}
	
	@Test
	public void deleteTest() {
		
		long id = 1L;
		boolean deleted = true;
		
		Mockito.when(this.service.deleteShop(id)).thenReturn(deleted);
		
		assertEquals(deleted, this.repo.existsById(id));
		
	}

}
