package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springbootsw.domain.Shop;

public interface ShopRepo extends JpaRepository<Shop, Long> {
	
	

}
