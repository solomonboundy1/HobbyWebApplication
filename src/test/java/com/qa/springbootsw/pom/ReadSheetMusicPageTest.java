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

public class ReadSheetMusicPageTest {
	
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
	public void testCreateSheetMusicForm() {
		
		// Arrange
		driver.get("http://127.0.0.1:5501/HTML/ReadSheetMusic.html");
		
		WebElement readButton = driver.findElement(By.id("ReadSheetMusicBtn"));

		WebElement sheetMusicIdInput = driver.findElement(By.id("inputReadSheetMusicId"));
		WebElement sheetMusicCard = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));

		String ID = "1";
		String card = "/html/body/div[2]/div/div/div";
		
		
		
		
		// Act
		sheetMusicIdInput.sendKeys(ID);
		readButton.click();
		
		
		// Assert
		Assertions.assertEquals(card, sheetMusicCard);
	}

}
