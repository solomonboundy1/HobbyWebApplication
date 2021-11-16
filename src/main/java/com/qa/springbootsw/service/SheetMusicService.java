package com.qa.springbootsw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.SheetMusic;

import com.qa.springbootsw.repo.SheetMusicRepo;


@Service
public class SheetMusicService {
	
private SheetMusicRepo repo;
	
	public SheetMusicService(SheetMusicRepo repo) {
		this.repo = repo;
	}
	
	public SheetMusic createSheetMusic(SheetMusic sheetMusic) {
		
		return this.repo.saveAndFlush(sheetMusic);
	}
	
	public List<SheetMusic> getAll() {
		return this.repo.findAll();
	}
	
	public SheetMusic getOne(Long id) {
		return this.repo.findById(id).get();
	}
	
	
	
	public SheetMusic update(Long id, SheetMusic sheetMusic) {
		SheetMusic existing = this.repo.findById(id).get();
		existing.setTitle(sheetMusic.getTitle());
		existing.setAuthor(sheetMusic.getAuthor());
		existing.setGenre(sheetMusic.getGenre());
		existing.setPrice(sheetMusic.getPrice());
		return this.repo.saveAndFlush(existing);
	}
	
	public boolean deleteSheetMusic(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id); // Bool
	}

	
	

}
