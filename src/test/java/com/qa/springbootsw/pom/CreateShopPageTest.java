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


public class CreateShopPageTest {
	
private WebDriver driver;
	
	@BeforeEach
	void setup( ) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		this.driver = new ChromeDriver(); 

		this.driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
		
	}
	
	@Test
	@Disabled
	public void testCreateShopForm() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/CreateShop.html");
		
		WebElement button = driver.findElement(By.id("CreateShopBtn"));
		WebElement shopNameInput = driver.findElement(By.id("inputCreateShopName"));
		WebElement shopAddressInput = driver.findElement(By.id("inputCreateShopAddress"));
		WebElement shopAddressResult = driver.findElement(By.xpath("//*[@id=\"cardListCreate\"]/div[1]/div/h5[3]"));
		WebElement shopNameResult = driver.findElement(By.xpath("//*[@id=\"cardListCreate\"]/div[1]/div/h5[2]"));
		String expectedName = "Shop Name: shop1";
		String expectedAddress = "Address: address1";
		String name = "shop1";
		String address = "address1";
		
		
		
		// Act
		shopNameInput.sendKeys(name);
		shopAddressInput.sendKeys(address);
		button.click();
		
		// Assert
		Assertions.assertEquals(expectedName, shopNameResult.getText());
		Assertions.assertEquals(expectedAddress, shopAddressResult.getText());
	}
	
	@Test
	@Disabled
	public void testHomeButton() {
		driver.get("http://127.0.0.1:5501/HTML/CreateShop.html");
		
		WebElement homeButton = driver.findElement(By.xpath("/html/body/section/ul/li[1]/a"));
		String expectedURL = "http://127.0.0.1:5501/Index.html";
		
		homeButton.click();
		
		Assertions.assertEquals(expectedURL, driver.getCurrentUrl());
		
		
	}

}
