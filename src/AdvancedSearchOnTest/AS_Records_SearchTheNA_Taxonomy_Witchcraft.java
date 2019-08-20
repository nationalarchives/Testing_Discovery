package AdvancedSearchOnTest;

import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_Records_SearchTheNA_Taxonomy_Witchcraft extends Wrapper_methods {

	@Test

	// Open the browser

	public void SearchTheNA_Taxonomy_Witchcraft() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		driver.findElementByLinkText("advanced search").click();
		Thread.sleep(1000);
		driver.findElementById("all-words-records").sendKeys("*");
		Thread.sleep(1000);

		// Select the national archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,550)");
		Thread.sleep(1000);
		driver.findElementById("search-tna-as-repository").click();
		Thread.sleep(1000);

		// select all records radio button
		driver.findElementById("col0").click();

		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");

		Thread.sleep(3000);
		driver.findElementById("col0").click();

		// Select Taxonomy subjects
		//driver.findElementById("C10117").click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		driver.findElementById("C10117").click();
		Thread.sleep(1000);


		driver.findElementByXPath("(//input[@type='submit'])[4]").click();
		Thread.sleep(3000);
		String filterResult = driver.findElementById("search-filters").getText();

		System.out.println(filterResult);

		Assert.assertTrue(filterResult.contains("Witchcraft"));
		Assert.assertTrue(filterResult.contains("Download"));
		Assert.assertTrue(filterResult.contains("Date"));
		Assert.assertTrue(filterResult.contains("Collection"));
		Assert.assertTrue(filterResult.contains("Subjects"));
		Assert.assertTrue(filterResult.contains("Catalogue level"));
		Assert.assertTrue(filterResult.contains("Closure status"));
		Assert.assertTrue(filterResult.contains("Record opening date"));

		// Total number of records for the wildcard
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);

		assertNotEquals(Records, "Records 0");
		//Assert.assertEquals("Records 119", Records);

		quitBrowser();

	}
}