package AdvancedSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_Records_SpecificDate_SearchAll extends Wrapper_methods {

	@Test
	// Open the browser
	public void SpecificDate_SearchAll() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Advanced Search
		driver.findElementByLinkText("advanced search").click();
		Thread.sleep(3000);
		driver.findElementById("all-words-records").sendKeys("nelson");
		Thread.sleep(3000);
		driver.findElementById("any-words-records-one").sendKeys("Mandela");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");

		// Date
		driver.findElementById("search-specific-date").click();

		Thread.sleep(3000);
		driver.findElementById("from-date").sendKeys("1986");

		Thread.sleep(3000);
		// Click Search
		driver.findElementByXPath("(//input[@type='submit'])[4]").click();
		Thread.sleep(3000);
		String filterResult = driver.findElementById("search-filters").getText();

		System.out.println(filterResult);

		String totalRecords = driver.findElementById("records-tab").getText();

		System.out.println(totalRecords);

		Assert.assertTrue(totalRecords.contains("2"));

		System.out.println(filterResult);

		Assert.assertTrue(filterResult.contains("1986"));
		quitBrowser();
	}
}