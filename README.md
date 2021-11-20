# Hobby Web Application

This is a front and back end Spring Boot project that allows you to add, remove, update and delete entries into a sheet music directory. It implements full CRUD functionality and displays both in a database labelled HWS and on a webpage

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
In order to  get started with the project you will need to download and install the following:
- An IDE of your choice that supports Java (Eclipse is recommended)
- An IDE that supports JavaScript
- MySQL as well as MySQL Workbench
- JUnit
- Mockito
- Selenium
- Git

To install Eclipse, follow this link: https://www.eclipse.org/ide/ and click on the download button. Once downloaded, go through the setup.

To install MySQL, follow this link: https://dev.mysql.com/downloads/installer/ and click on the SECOND download button. Once downloaded follow the setup process ensuring that you download MySQL Workbench and MySQL Command Line Client

To install Git, you need to follow this link https://git-scm.com/downloads and choose your Operating system



### Installing

Fork the Hobby Web Application Project
create a folder for the project
right click the folder and click git bash here
next, clone the project down to your computer by following the commands on github


## Running the tests

We use three testing frameworks to test the functionality of the program; JUnit, Selenium and Mockito.

JUnit is used for testing individual units or methods of classes, whereas mockito is used for integration testing to test the functionality between the SQL Database and the code in the java files.

Selenium was used to run automation tests on the websites functionality

To run the unit tests, right click on the class in which the unit you would like to test is and click run as, and then JUnit test.

To run an integration test, do the same. 
This will also show the coverage percentage of which tests have passed and which tests have failed.

To run the automation tests, do the same

### Unit Tests 
We use JUnit for testing units.

Unit tests test the functionality of an individual method of a class, if the method is not working correctly you will see a red bar and an error along side a message within the console outlining the issue. Using the 'assertEquals' method, we are able to compare the outcome of the first argument within the parenthesis to the second argument, ensuring that they output the same outcome. 

```
Unit test example:

	@Test
	public void createTest() {
		Shop shop = new Shop(1l, "MusicRoom Argents", "11 Denmark Street"); 
		SheetMusic input = new SheetMusic("Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop);
		SheetMusic output = new SheetMusic("Stevie Wonder: Songs in the key of Life", "Stevie Wonder", "Soul", 11.99, shop);
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		assertEquals(output, this.service.createSheetMusic(input));
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
```

### Integration Tests 
We use Mockito to for integration tests. We use this to test the functionality between the database and the java classes of the project.

```
Here is an example of the syntax

	@Test
	void testCreate() throws Exception {
		Shop shop = new Shop("shopName", "shopAddress");
		String shopAsJSON = this.mapper.writeValueAsString(shop);
		RequestBuilder request = post("/shop/create").contentType(MediaType.APPLICATION_JSON).content(shopAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Shop shopSaved = new Shop(2, "shopName", "shopAddress");
		String shopSavedAsJSON = this.mapper.writeValueAsString(shopSaved);
		
		ResultMatcher checkBody = content().json(shopSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}


## Built With

* [Maven (SpringBoot)](https://maven.apache.org/) - Dependency Management

## Versioning

We use [Git](https://git-scm.com/) for versioning.

## Authors

Solomon Boundy





## Acknowledgments

* Reece Elder
* Anoush Lowe



