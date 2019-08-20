package AdvancedSearchOnTest;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_RecordCreator_CreatorType_CheckBox_Years extends Wrapper_methods {

	@Test
	// Open the browser
	public void CreatorType_CheckBox_Years() throws IOException, InterruptedException {

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

		// Select the checkbox for the years and dates unknown

		List<WebElement> allYears = driver.findElementsByXPath("(//ul[@class='date-periods'])[2]/li");
		int count = allYears.size();
		System.out.println(count);

		for (WebElement all : allYears) {
			System.out.println(all.getText());

		}

		// click the below years

		allYears.get(0).click();
		Thread.sleep(3000);

		allYears.get(1).click();
		Thread.sleep(3000);
		allYears.get(2).click();
		Thread.sleep(3000);

		Thread.sleep(1000);

		driver.findElementByXPath("(//input[@type='submit'])[6]").click();
		Thread.sleep(1000);

		// verify your filters
		String yourfilter = driver.findElementById("search-refine").getText();

		System.out.println(yourfilter);

		Assert.assertTrue(yourfilter.contains("Business"));
		Assert.assertTrue(yourfilter.contains("Agriculture, forestry and fisheries"));
		Assert.assertTrue(yourfilter.contains("Agricultural contracting"));
		Assert.assertTrue(yourfilter.contains("Dates unknown"));
		Assert.assertTrue(yourfilter.contains("1 - 999"));
		Assert.assertTrue(yourfilter.contains("1000 - 1099"));

		// verify the creator type on records creater level

		String verifyBusiness = driver.findElementByXPath("//span[@class='creator-type']").getText();
		System.out.println(verifyBusiness);
		Assert.assertTrue(yourfilter.contains(verifyBusiness));
		
		quitBrowser();
	}
}