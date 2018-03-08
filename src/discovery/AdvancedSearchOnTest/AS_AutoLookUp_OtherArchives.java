package discovery.AdvancedSearchOnTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class AS_AutoLookUp_OtherArchives extends Wrapper_methods {

	@Test
	public void verifyLookUp() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		clickbyLinkText("advanced search");

		enterTextById("all-words-records", "Cranham");

		// Select the other archives radio button
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(1000);
		driver.findElementById("search-other-repositories").click();

		enterTextById("repositories-lookup", "Glou");

		Thread.sleep(3000);

		List<WebElement> li = driver
				.findElementsByXPath("(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all'])[1]/li");

		String Acutal = li.get(2).getText();
		System.out.println(Acutal);
		li.get(2).click();

		driver.findElementByXPath("(//input[@type='submit'])[4]").click();

		Thread.sleep(3000);
		String yourFliters = driver.findElementById("search-refine").getText();

		System.out.println(yourFliters);

		Assert.assertTrue(yourFliters.contains(Acutal));

		quitBrowser();

	}

}
