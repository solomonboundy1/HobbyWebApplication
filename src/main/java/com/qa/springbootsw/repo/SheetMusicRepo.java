package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springbootsw.domain.SheetMusic;

public interface SheetMusicRepo extends JpaRepository<SheetMusic, Long> {
	
	

}
