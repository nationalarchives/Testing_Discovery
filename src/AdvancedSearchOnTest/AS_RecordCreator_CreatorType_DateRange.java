package AdvancedSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_RecordCreator_CreatorType_DateRange extends Wrapper_methods {

	@Test
	// Open the browser
	public void CreatorType_DateRange() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Click advanced Search

		driver.findElementByLinkText("advanced search").click();
		// clcik record creator tab

		driver.findElementById("record-creators-advanced-search").click();
		// Enter words
		driver.findElementById("all-words-record-creators").sendKeys("*");

		((JavascriptExecutor) driver).executeScript("scroll(0,550)");

		Thread.sleep(3000);
		// select createrType

		Select createrType = new Select(driver.findElementById("creator-type"));

		createrType.selectByIndex(1);

		// select category

		Select category = new Select(driver.findElementById("creator-category"));

		category.selectByIndex(1);
		Thread.sleep(3000);

		// select sub category

		Select sub_Category = new Select(driver.findElementById("creator-sub-category"));

		sub_Category.selectByIndex(1);

		Thread.sleep(3000);
		driver.findElementById("rc-from-date").sendKeys("1900");
		Thread.sleep(1000);
		driver.findElementById("rc-to-date").sendKeys("2007");

		Thread.sleep(1000);

		driver.findElementByXPath("(//input[@type='submit'])[6]").click();
		Thread.sleep(1000);
		String filterResult = driver.findElementById("search-filters").getText();

		System.out.println(filterResult);

		Assert.assertTrue(filterResult.contains("Business"));
		Assert.assertTrue(filterResult.contains("Agriculture, forestry and fisheries"));
		Assert.assertTrue(filterResult.contains("Agricultural contracting"));
		Assert.assertTrue(filterResult.contains("1900 - 2007"));

		// verify the creator type on records creator level for each record

		String verifyBusiness = driver.findElementByXPath("//span[@class='creator-type']").getText();
		System.out.println(verifyBusiness);
		Assert.assertTrue(filterResult.contains(verifyBusiness));
		quitBrowser();
	}
}