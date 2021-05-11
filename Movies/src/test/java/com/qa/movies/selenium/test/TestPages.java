package com.qa.movies.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPages {

	private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
}
    @Test
    public void getSite() {
    	driver.get("http://127.0.0.1:5500/Create.html");
    	assertEquals("Movie Lists", driver.getTitle());
    }
    
    @Test
    public void submitEntry() {
    	driver.get("http://127.0.0.1:5500/Create.html");
    }
    
}
