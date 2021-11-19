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

public class WebElementsTest {
private WebDriver driver;
	
	@BeforeEach
	void setup( ) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		
		 // create a new browser window with these measurements
		this.driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
	}
	
	@Test
	public void testUseless() {
		
		// Arrange
		driver.get("https://theuselessweb.com/");
		
		// Grab button we want to click
		WebElement button = driver.findElement(By.id("button"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		// Once the button is clicked the new url is NOT the uselessweb.com
		Assertions.assertEquals("https://theuselessweb.com/", driver.getCurrentUrl());
	}

}
