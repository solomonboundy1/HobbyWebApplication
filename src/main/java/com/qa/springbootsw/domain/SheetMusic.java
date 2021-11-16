package com.qa.springbootsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	@Column(nullable = false)
	@ManyToOne
	private Shop shopId;
	
	

}
