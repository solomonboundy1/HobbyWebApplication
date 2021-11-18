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

import com.qa.springbootsw.domain.SheetMusic;
import com.qa.springbootsw.service.SheetMusicService;

@CrossOrigin
@RestController
@RequestMapping("/sheetmusic")
public class SheetMusicController {
	
	private SheetMusicService service;
	
	public SheetMusicController(SheetMusicService service) {
		this.service = service;
	}
	
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<SheetMusic> create(@RequestBody SheetMusic sheetMusic) {
	System.out.println(sheetMusic);
		return new ResponseEntity<SheetMusic>(this.service.createSheetMusic(sheetMusic), HttpStatus.CREATED);
	}
		
		
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<SheetMusic>> getAll() {
		// return the whole list
		return new ResponseEntity<List<SheetMusic>>(this.service.getAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<SheetMusic> getOne(@PathVariable Long id) {
		return new ResponseEntity<SheetMusic>(this.service.getOne(id), HttpStatus.ACCEPTED);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<SheetMusic> update(@PathVariable Long id, @RequestBody SheetMusic sheetMusic) {
		
		return new ResponseEntity<SheetMusic>(this.service.update(id, sheetMusic), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SheetMusic> delete(@PathVariable Long id) {
		return (this.service.deleteSheetMusic(id) == true) ? new ResponseEntity<SheetMusic>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<SheetMusic>(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}

}
