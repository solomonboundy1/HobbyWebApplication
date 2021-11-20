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

public class ReadShopPageTest {
	
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
		driver.get("http://127.0.0.1:5501/HTML/ReadShop.html");
		
		WebElement readButton = driver.findElement(By.id("ReadShopBtn"));
		WebElement readAllButton = driver.findElement(By.id("ReadAllShopBtn"));
		WebElement shopIdInput = driver.findElement(By.id("inputReadShopId"));
		WebElement shopIdResult = driver.findElement(By.xpath("//*[@id=\"cardList\"]/div[1]/div/h5[1]"));

		String ID = "1";
		String expectedID = "ID: 1";
		
		
		
		
		// Act
		shopIdInput.sendKeys(ID);
		readButton.click();
		readAllButton.click();	
		
		// Assert
		Assertions.assertEquals(expectedID, shopIdResult.getText());
	}


}
