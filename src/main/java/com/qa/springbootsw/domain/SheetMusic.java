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
	
	


	public SheetMusic(String title, String author, String genre, double price, Shop shop) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.shop = shop;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (SheetMusicId ^ (SheetMusicId >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SheetMusic other = (SheetMusic) obj;
		if (SheetMusicId != other.SheetMusicId)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	

}
