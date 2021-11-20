package com.qa.springbootsw.pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SheetMusicPageTest {
private WebDriver driver;
	
	@BeforeEach
	void setup( ) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		this.driver = new ChromeDriver(); 

		this.driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
		
	}
	
	@Test
	public void testAddSheetMusicButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/sheetmusic.html");
		
		
		WebElement button = driver.findElement(By.id("addSheetMusicBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/CreateSheetMusic.html", driver.getCurrentUrl());
	}
	
	@Test
	public void testViewSheetMusicButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/sheetmusic.html");
		String viewSheetMusicTitle = "Browse Sheet Music | The Music Directory";
		
		WebElement button = driver.findElement(By.id("viewSheetMusicBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals(viewSheetMusicTitle, driver.getTitle());
	}
	
	@Test
	public void testUpdateSheetMusicButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/sheetmusic.html");
		
		
		WebElement button = driver.findElement(By.id("updateSheetMusicBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/UpdateSheetMusic.html", driver.getCurrentUrl());
	}
	
	@Test
	public void testDeleteSheetMusicButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/sheetMusic.html");
		
		
		WebElement button = driver.findElement(By.id("deleteSheetMusicBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/DeleteSheetMusic.html", driver.getCurrentUrl());
	}

}
