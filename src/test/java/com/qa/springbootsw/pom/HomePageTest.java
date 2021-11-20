package com.qa.springbootsw.pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
	
private WebDriver driver;
	
	@BeforeEach
	void setup( ) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		this.driver = new ChromeDriver(); 

		this.driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
		
	}
	
	@Test
	public void testHomePageButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/Index.html");
		
		
		WebElement button = driver.findElement(By.id("discButton"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/AboutUs.html", driver.getCurrentUrl());
	}
	
	@Test
	@Disabled
	public void testHamburgerButton() {
		
		driver.get("http://127.0.0.1:5501/HTML/Index.html");
		
		
		WebElement button = driver.findElement(By.xpath("/html/body/div/div"));
		
		WebElement hamburgerClassChange = driver.findElement(By.className("hamburger-menu change"));
		
		button.click();
		
		String expectedClass = "hamburger-menu change";
		
		Assertions.assertEquals(expectedClass, hamburgerClassChange);
	}
	
	

}
