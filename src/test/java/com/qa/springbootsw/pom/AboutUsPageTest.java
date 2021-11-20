package com.qa.springbootsw.pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AboutUsPageTest {
	
	private WebDriver driver;
	
	@BeforeEach
	void setup( ) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		this.driver = new ChromeDriver(); 

		this.driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
		
	}
	
	@Test
	public void testShopsButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/AboutUs.html");
		
		
		WebElement button = driver.findElement(By.id("shopsBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/shop.html", driver.getCurrentUrl());
	}
	
	@Test
	public void testSheetMusicButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/AboutUs.html");
		
		
		WebElement button = driver.findElement(By.id("sheetMusicBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/SheetMusic.html", driver.getCurrentUrl());
	}

}
