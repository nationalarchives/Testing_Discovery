package BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_LessThan10000_SortedBy_Reference extends Wrapper_methods {

	// Open the browser

	public void LessThan10000_SortedBy_Reference() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("Titanic");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Total number of records for the nelson
		String totalNoOfRecords = driver.findElementById("records-tab").getText();
		System.out.println(totalNoOfRecords);

		if (totalNoOfRecords.matches("Records 7,[0-999].*"))

			System.out.println(true);

		else
			System.out.println(false);

		// Total number records creators
		String RecordCreators = driver.findElementById("nameAuthorities").getText();
		System.out.println(RecordCreators);
		Assert.assertEquals("Record creators 5", RecordCreators);

		Thread.sleep(3000);
		// Held by
		String heldBy = driver.findElementByXPath("//div[@class='filter-togglee']").getText();
		System.out.println(heldBy);

		// Lessthan 10,000 records so select from drop down

//		Select sortedBy = new Select(driver.findElementById("sortDrop"));
		Select sortedBy = new Select(driver.findElementByName("_srt"));

		sortedBy.selectByIndex(1);
		Thread.sleep(3000);

		// Verify the reference status

		String actual = driver.findElementByXPath("(//ul[@id='search-results']/li/a/table/tbody/tr[3]/td[2])[1]")
				.getText();

		System.out.println(actual);
		Assert.assertEquals("None stated", actual);

		Thread.sleep(9000);
		driver.findElementById("nameAuthorities").click();
		// verify reference is not available under record creators

		Select sortedBy_RecordCreator = new Select(driver.findElementById("sortDrop"));

		List<WebElement> alloptions = sortedBy_RecordCreator.getOptions();

		int count = alloptions.size();

		for (WebElement all : alloptions) {

			System.out.println(all.getText());

		}

		if (alloptions.contains("Reference"))

			System.out.println(false);

		else

			System.out.println(true);

		quitBrowser();

	}

}
