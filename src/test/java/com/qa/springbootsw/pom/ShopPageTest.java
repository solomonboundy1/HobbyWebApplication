package com.qa.springbootsw.pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopPageTest {
	
private WebDriver driver;
	
	@BeforeEach
	void setup( ) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		this.driver = new ChromeDriver(); 

		this.driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
		
	}
	
	@Test
	public void testAddShopButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/shop.html");
		
		
		WebElement button = driver.findElement(By.id("addShopBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/CreateShop.html", driver.getCurrentUrl());
	}
	
	@Test
	public void testViewShopButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/shop.html");
		String viewShopTitle = "Browse Shops | The Music Directory";
		
		WebElement button = driver.findElement(By.id("viewShopBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals(viewShopTitle, driver.getTitle());
	}
	
	@Test
	public void testUpdateShopButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/shop.html");
		
		
		WebElement button = driver.findElement(By.id("updateShopBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/UpdateShop.html", driver.getCurrentUrl());
	}
	
	@Test
	public void testDeleteShopButton() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/shop.html");
		
		
		WebElement button = driver.findElement(By.id("deleteShopBtn"));
		System.out.println(button);
		
		// Act
		button.click();
		
		// Assert
		Assertions.assertEquals("http://127.0.0.1:5501/HTML/DeleteShop.html", driver.getCurrentUrl());
	}


}
