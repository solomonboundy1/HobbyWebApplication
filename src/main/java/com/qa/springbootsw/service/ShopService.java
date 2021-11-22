package com.qa.springbootsw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.Shop;
import com.qa.springbootsw.exceptions.ShopNotFoundException;

import com.qa.springbootsw.repo.ShopRepo;

@Service
public class ShopService {
	
	private ShopRepo repo;
	
	public ShopService(ShopRepo repo) {
		this.repo = repo;
	}
	
	public Shop createShop(Shop shop) {
		
		return this.repo.saveAndFlush(shop);
	}
	
	public List<Shop> getAll() {
		return this.repo.findAll();
	}
	
	public Shop getOne(Long id) {
		return this.repo.findById(id).orElseThrow(ShopNotFoundException::new);
	}
	
	
	
	public Shop update(Long id, Shop shop) {
		Shop existing = this.repo.findById(id).get();
		existing.setShopName(shop.getShopName());
		existing.setAddress(shop.getAddress());
		return this.repo.saveAndFlush(existing);
	}
	
	public boolean deleteShop(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id); // Bool
	}

}
