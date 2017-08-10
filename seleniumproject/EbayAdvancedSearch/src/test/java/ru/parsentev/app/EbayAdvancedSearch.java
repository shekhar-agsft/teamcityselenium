package ru.parsentev.app;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class EbayAdvancedSearch {
	private Selenium selenium;

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		 driver = new FirefoxDriver();
		String baseUrl = "http://www.google.com/";
		//selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testEbayAdvancedSearch() throws Exception {
		
		driver.navigate().to("http://www.google.com/");
        System.out.println(driver.getTitle());
        assertTrue( driver.getTitle().compareTo("srsffg")==0 );

	}

	@After
	public void tearDown() throws Exception {
		
		if(driver!=null)
		{
			driver.close();
		}
	}
}
