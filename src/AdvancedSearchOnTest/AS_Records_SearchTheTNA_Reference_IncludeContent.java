package AdvancedSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_Records_SearchTheTNA_Reference_IncludeContent extends Wrapper_methods {

	@Test

	// Open the browser

	public void SearchTheTNA_Reference_IncludeContent() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		driver.findElementByLinkText("advanced search").click();
		Thread.sleep(1000);
		driver.findElementById("all-words-records").sendKeys("*");
		Thread.sleep(3000);

		// Search within reference
		driver.findElementById("reference-search-0").sendKeys("CAB 181");

		// Select the national archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);
		driver.findElementById("search-tna-as-repository").click();
		Thread.sleep(1000);

		// select all records radio button
		driver.findElementById("col0").click();

		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");

		Thread.sleep(3000);

		// Select Include in search

		driver.findElementById("includecontent").click();
		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[4]").click();
		Thread.sleep(3000);
		String yourFliters = driver.findElementById("search-refine").getText();

		System.out.println(yourFliters);

		// verify include content

		String searchResult = driver.findElementByXPath("//ul[@id='search-results']").getText();

		System.out.println(searchResult);

		Assert.assertTrue(searchResult.contains("Content: "));

		Assert.assertTrue(yourFliters.contains("The National Archives"));
		Assert.assertTrue(yourFliters.contains("Include content"));
		Assert.assertTrue(yourFliters.contains("CAB 181"));

		quitBrowser();

	}
}