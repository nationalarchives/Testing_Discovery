package AdvancedSearchOnTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_Records_DateRange_SearchAll extends Wrapper_methods {

	@Test

	// Open the browser

	public void DateRange_SearchAll() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		driver.findElementByLinkText("advanced search").click();
		Thread.sleep(1000);
		driver.findElementById("all-words-records").sendKeys("nelson");
		Thread.sleep(1000);
		driver.findElementById("any-words-records-one").sendKeys("Mandela");
		Thread.sleep(1000);
		driver.findElementById("from-date").sendKeys("1900");
		Thread.sleep(1000);
		driver.findElementById("to-date").sendKeys("2007");

		Thread.sleep(1000);

		driver.findElementByXPath("(//input[@type='submit'])[4]").click();
		Thread.sleep(1000);
		String filterResult = driver.findElementById("search-filters").getText();

		System.out.println(filterResult);

		Assert.assertTrue(filterResult.contains("1900 - 2007"));
		Assert.assertTrue(filterResult.contains("Held by"));
		Assert.assertTrue(filterResult.contains("Date"));

		quitBrowser();
	}
}