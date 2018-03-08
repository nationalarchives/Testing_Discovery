package discovery.AdvancedSearchOnLive;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class AS_AutoLookUp_ByGovernmentDepartment extends Wrapper_methods {

	@Test
	public void verifyAutoLookUp_ByGovernmentDepartment() throws IOException, InterruptedException {

		launchDriver("http://discovery.nationalarchives.gov.uk/", "chrome");

		clickbyLinkText("advanced search");

		enterTextById("all-words-records", "*");
		// Select the other archives radio button

		//Select the national archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,550)");
		Thread.sleep(1000);
		driver.findElementById("search-tna-as-repository").click();
		Thread.sleep(1000);
		
		//select all records radio button
		driver.findElementById("col0").click();

		enterTextById("departments-lookup", "gov");

		Thread.sleep(3000);

		List<WebElement> li = driver
				.findElementsByXPath("(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all'])[3]/li");

		String Acutal = li.get(2).getText();
		System.out.println(Acutal);
		li.get(2).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");
		driver.findElementByXPath("(//input[@type='submit'])[4]").click();

		Thread.sleep(3000);
		String yourFliters = driver.findElementById("search-refine").getText();

		System.out.println(yourFliters);

		Assert.assertTrue(yourFliters.contains(Acutal));

		Assert.assertTrue(yourFliters.contains("The National Archives"));
		quitBrowser();

	}

}
