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
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class EbayAdvancedSearch {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.google.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testEbayAdvancedSearch() throws Exception {
		selenium.open("/");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=gh-as-a");
		selenium.type("id=_nkw", "JUnit");
		selenium.select("id=e1-1", "value=267");
		selenium.click("id=LH_TitleDesc");
		selenium.click("css=button.btn.btn-prim");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=span.listingscnt")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("Объявлений: 488", selenium.getText("css=span.listingscnt"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
