package AdvancedSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_SearchOtherArchives extends Wrapper_methods {

	@Test

	// Open the browser

	public void SearchOtherArchives() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		driver.findElementByLinkText("advanced search").click();
		Thread.sleep(1000);
		driver.findElementById("all-words-records").sendKeys("*");
		Thread.sleep(3000);
		// Select the national archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);
		driver.findElementById("search-other-repositories").click();
		Thread.sleep(1000);
		// ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		driver.findElementByXPath("(//input[@type='submit'])[4]").click();
		Thread.sleep(1000);
		String filterResult = driver.findElementById("search-filters").getText();

		System.out.println(filterResult);

		Assert.assertTrue(filterResult.contains("Held by"));
		Assert.assertTrue(filterResult.contains("Date"));

		// Total number of records for otherArchives
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);
		if (Records.matches("Records 10,[0-9].*,[0-9].*"))

			System.out.println(true);
		else
			System.out.println(false);
		// Assert.assertEquals("Records 10,684,024", Records);

		quitBrowser();

	}
}