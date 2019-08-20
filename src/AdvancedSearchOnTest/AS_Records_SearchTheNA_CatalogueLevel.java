package AdvancedSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_Records_SearchTheNA_CatalogueLevel extends Wrapper_methods {

	@Test

	// Open the browser

	public void SearchTheNA_CatalogueLevel() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		driver.findElementByLinkText("advanced search").click();
		Thread.sleep(1000);
		driver.findElementById("all-words-records").sendKeys("*");
		Thread.sleep(3000);

		// Select the national archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);
		driver.findElementById("search-tna-as-repository").click();
		Thread.sleep(1000);

		// select all records radio button
		driver.findElementById("col0").click();

		((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

		Thread.sleep(1000);
		driver.findElementById("catLvl-1").click();
		Thread.sleep(1000);
		driver.findElementById("catLvl-2").click();
		Thread.sleep(1000);
		driver.findElementById("catLvl-3").click();
		Thread.sleep(1000);
		driver.findElementById("catLvl-6").click();
		Thread.sleep(1000);
		driver.findElementById("catLvl-7").click();
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");
		driver.findElementById("notitlesearch").click();

		driver.findElementByXPath("(//input[@type='submit'])[4]").click();
		Thread.sleep(3000);
		String filterResult = driver.findElementById("search-filters").getText();

		System.out.println(filterResult);

		Assert.assertTrue(filterResult.contains("The National Archives"));
		Assert.assertTrue(filterResult.contains("Exclude title"));
		Assert.assertTrue(filterResult.contains("Department"));
		Assert.assertTrue(filterResult.contains("Division"));
		Assert.assertTrue(filterResult.contains("Series"));
		Assert.assertTrue(filterResult.contains("Piece"));
		Assert.assertTrue(filterResult.contains("Item"));

		quitBrowser();

	}
}