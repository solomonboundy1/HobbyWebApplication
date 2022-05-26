package com.qa.springbootsw.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootsw.domain.Shop;

import com.qa.springbootsw.service.ShopService;

@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {
	
	private ShopService service;
	
	public ShopController(ShopService service) {
		this.service = service;
	}
	
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<Shop> create(@RequestBody Shop shop) {
		return new ResponseEntity<Shop>(this.service.createShop(shop), HttpStatus.CREATED);
	}
		
		
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Shop>> getAll() {
		// return the whole list
		return new ResponseEntity<List<Shop>>(this.service.getAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Shop> getOne(@PathVariable Long id) {
		return new ResponseEntity<Shop>(this.service.getOne(id), HttpStatus.ACCEPTED);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Shop> update(@PathVariable Long id, @RequestBody Shop shop) {
		
		return new ResponseEntity<Shop>(this.service.update(id, shop), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Shop> delete(@PathVariable Long id) {
		return (this.service.deleteShop(id) == true) ? new ResponseEntity<Shop>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Shop>(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}

}
