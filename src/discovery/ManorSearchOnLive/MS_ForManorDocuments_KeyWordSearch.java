package discovery.ManorSearchOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class MS_ForManorDocuments_KeyWordSearch extends Wrapper_methods {

	@Test
	public void ForManorDocuments_KeyWordSearch() throws IOException, InterruptedException {
		// launch the browser and url
		launchDriver("http://discovery.nationalarchives.gov.uk/manor-search",
				"chrome");
		Thread.sleep(3000);

		// click search for manorial documents

		clickbyID("search-documents");

		// Enter the wildcard
		enterTextById("all-words-records", "*");
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(3000);

		// enter parish name

		enterByTextXpath("(//input[@id='parish-search'])[2]", "lambeth");

		// select historic country
		Thread.sleep(3000);

		selectbyvisibletext_Byxpath("(//select[@name='_ocn'])[2]", "Surrey");

		// select type of document

		selectbyvisibletext_Byname("_mdt", "Account");

		// click search specfic date
		Thread.sleep(3000);
		clickbyID("search-specific-date-record");
		
		//enter date
		Thread.sleep(3000);
		enterTextById("rc-from-date", "1321");
	
		// Click search button
		clickbyXpath("(//input[@type='submit'])[4]");

		Thread.sleep(3000);

		// Verify your filters
		Thread.sleep(3000);
		String yourFilters = getTextById("search-refine");
		System.out.println(yourFilters);

		Assert.assertTrue(yourFilters.contains("Manor"));
		Assert.assertTrue(yourFilters.contains("1321"));
		// Verify records
		String total_Records = getTextById("records-tab");
		System.out.println(total_Records);
		Assert.assertTrue(total_Records.contains("Records 2"));
		//Assert.assertTrue(total_Records.contains("Records 136"));
		Thread.sleep(3000);
		// Verify record creators
		String total_RecordsCreators = getTextById("name-authorities-tab");
		System.out.println(total_RecordsCreators);
		Assert.assertTrue(total_RecordsCreators.contains("Record creators 0"));
		// quit browser
		quitBrowser();
		
		
	}

}
