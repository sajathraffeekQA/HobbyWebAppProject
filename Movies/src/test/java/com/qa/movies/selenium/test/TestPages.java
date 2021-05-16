package com.qa.movies.selenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.movies.selenium.pages.CreatePage;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestPages {


	@LocalServerPort
	int randomPort;
	private final String URL = "http://localhost:";
	
	private static WebDriver driver;

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1064, 600));
	}



	@Test
	public void checkURL() {
		driver.get(URL+randomPort+"/");
		assertEquals(URL+randomPort+"/", driver.getCurrentUrl());
	}
	
	@Test
	public void submitEntry() {
		driver.get(URL + randomPort + "/create.html");
		CreatePage page = PageFactory.initElements(driver, CreatePage.class);
		page.getMovieTitle().sendKeys("Hulk");
		page.getReleaseYear().sendKeys("2008");
		page.getRating().sendKeys("70");
		page.getGenre().sendKeys("action");
		page.getSubmit().click();
		//assertTrue(page.getSuccess().getText().contains("Movie Entry Created"));
		assertTrue(driver.getTitle().contains("Movie Lists"));
	}
	
	@Test
	public void readEntries() {
		driver.get(URL + randomPort + "/create.html");
		CreatePage page = PageFactory.initElements(driver, CreatePage.class);
		
		page.getClickhere().click();
		assertEquals(URL+randomPort+"/read.html", driver.getCurrentUrl());
	
	}
	
	@Test
	public void DeleteEntries() {
		driver.get(URL + randomPort + "/create.html");
		CreatePage page = PageFactory.initElements(driver, CreatePage.class);
		
		page.getClickhere().click();
			
		assertEquals(URL+randomPort+"/read.html", driver.getCurrentUrl());
	
	}
	
	@Test
	public void UpdateEntries() {
		driver.get(URL + randomPort + "/create.html");
		CreatePage page = PageFactory.initElements(driver, CreatePage.class);
		
		page.getClickhere().click();
		page.getUpdate().click();
		
		
		assertTrue(driver.getTitle().contains("Update Entry"));
	}
	

}
