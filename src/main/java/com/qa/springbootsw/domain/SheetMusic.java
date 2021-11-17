package com.qa.springbootsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class SheetMusic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long SheetMusicId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column (nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private double price;
	
	
	@ManyToOne
	private Shop shop;


	public SheetMusic(long sheetMusicId, String title, String author, String genre, double price) {
		super();
		SheetMusicId = sheetMusicId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
	}


	public SheetMusic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SheetMusic(long sheetMusicId, String title, String author, String genre, double price, Shop shop) {
		super();
		SheetMusicId = sheetMusicId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.shop = shop;
	}


	public long getSheetMusicId() {
		return SheetMusicId;
	}


	public void setSheetMusicId(long sheetMusicId) {
		SheetMusicId = sheetMusicId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	@Override
	public String toString() {
		return "SheetMusic [SheetMusicId=" + SheetMusicId + ", title=" + title + ", author=" + author + ", genre="
				+ genre + ", price=" + price + ", shop=" + shop + "]";
	}
	
	
	
	

}
