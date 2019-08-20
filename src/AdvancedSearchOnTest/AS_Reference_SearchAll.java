package AdvancedSearchOnTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AS_Reference_SearchAll extends Wrapper_methods {

	// Open the browser

	@Test
	public void Reference_SearchAll() throws IOException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		// click Advanced Search

		driver.findElementByLinkText("advanced search").click();
		// Enter reference
		driver.findElementById("reference-search-0").sendKeys("IR 30");

		// click search

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();

		// get the list of table

		List<WebElement> allReference = driver
				.findElementsByXPath("//*[@id='search-results']/li/a/table/tbody/tr[3]");

		int count = allReference.size();
		
		for (int i = 0; i < count; i++) {

			String reference = allReference.get(i).getText();
			System.out.println(reference);
			
			assertTrue(reference.matches("Reference.*IR.*"));
		}

		// Click the first record
		driver.findElementByPartialLinkText("Domesday Book").click();
		// Verify reference
		String reference = driver.findElementByXPath("//table[@class='asset-details']/tbody/tr").getText();
		System.out.println(reference);
		
		assertTrue(reference.matches("Reference: IR.*"));

		quitBrowser();

		// check whether the reference is highlighted on the home page

	}

	
}
