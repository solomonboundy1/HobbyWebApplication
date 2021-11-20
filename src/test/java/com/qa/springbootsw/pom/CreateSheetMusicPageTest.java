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

public class CreateSheetMusicPageTest {
	
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
		driver.get("http://127.0.0.1:5501/HTML/CreateSheetMusic.html");
		
		WebElement button = driver.findElement(By.id("CreateSheetMusicBtn"));
		WebElement sheetMusicTitleInput = driver.findElement(By.id("inputCreateSheetMusicTitle"));
		WebElement sheetMusicAuthorInput = driver.findElement(By.id("inputCreateSheetMusicAuthor"));
		WebElement sheetMusicGenreInput = driver.findElement(By.id("inputCreateSheetMusicGenre"));
		WebElement sheetMusicPriceInput = driver.findElement(By.id("inputCreateSheetMusicPrice"));
		
		WebElement sheetMusicTitleResult = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/h5[1]"));
		WebElement sheetMusicAuthorResult = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/h5[2]"));
		WebElement sheetMusicGenreResult = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/h5[3]"));
		WebElement sheetMusicPriceResult = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/h5[4]"));
		
		String expectedTitle = "Title: title1";
		String expectedAuthor = "Author: author1";
		String expectedGenre = "Genre: Jazz";
		String expectedPrice = "Price: 10.99";
		
		String title = "title1";
		String author = "author1";
		String genre = "Jazz";
		String price = "10.99";
		
		
		
		// Act
		sheetMusicTitleInput.sendKeys(title);
		sheetMusicAuthorInput.sendKeys(author);
		sheetMusicGenreInput.sendKeys(genre);
		sheetMusicPriceInput.sendKeys(price);
		button.click();
		
		// Assert
		Assertions.assertEquals(expectedTitle, sheetMusicTitleResult.getText());
		Assertions.assertEquals(expectedAuthor, sheetMusicAuthorResult.getText());
		Assertions.assertEquals(expectedGenre, sheetMusicGenreResult.getText());
		Assertions.assertEquals(expectedPrice, sheetMusicPriceResult.getText());
	}
	

}
