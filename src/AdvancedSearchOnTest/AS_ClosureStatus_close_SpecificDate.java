package AdvancedSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_ClosureStatus_close_SpecificDate extends Wrapper_methods {

	@Test

	// Open the browser

	public void close_SpecificDate() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Click advanced Search

		driver.findElementByLinkText("advanced search").click();

		// Enter words
		driver.findElementById("all-words-records").sendKeys("*");
		Thread.sleep(3000);

		// Select the national archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);
		driver.findElementById("search-tna-as-repository").click();
		Thread.sleep(1000);

		// select all records radio button
		driver.findElementById("col0").click();

		((JavascriptExecutor) driver).executeScript("scroll(0,3700)");

		// Record opening date

		driver.findElementById("rodDateRadio").click();
		// Enter the date

		driver.findElementById("rodDate").sendKeys("01/05/2020");
		Thread.sleep(3000);

		// Record closure status -check the box for open

		driver.findElementById("cs-C").click();
		Thread.sleep(3000);
		// click search button

		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@type='submit'])[4]").click();

		// closed records
		Thread.sleep(3000);
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);

		if (Records.matches("Records 3"))

			System.out.println(true);

		else
			System.out.println(false);

		// verify your filters
		String yourfilter = driver.findElementById("search-refine").getText();

		System.out.println(yourfilter);

		Assert.assertTrue(yourfilter.contains("The National Archives"));
		Assert.assertTrue(yourfilter.contains("Closed Document"));

		// click the first record link
		Thread.sleep(3000);
		driver.findElementByXPath("//ul[@id='search-results']/li[1]").click();
		((JavascriptExecutor) driver).executeScript("scroll(0,550)");

		// verify the date
		Thread.sleep(3000);
		String actualdate = driver.findElementByXPath("//table[@class='asset-details']").getText();

		System.out.println(actualdate);

		Assert.assertTrue(actualdate.contains("Record opening date: 01 May 2020"));

		quitBrowser();

	}
}