package BasicSearchOnTest;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@org.testng.annotations.Test
public class BS_LessThan10000ExportAllRecordsAsCSV extends Wrapper_methods {

	// Open the browser
	@org.testng.annotations.Test
	public void LessThan10000ExportAllRecordsAsCSV() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("titanic");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Total number of records for the nelson
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);
		// Assert.assertEquals("Records 7,910", Records);

		// Total number records creators
		String RecordCreators = driver.findElementById("nameAuthorities").getText();
		System.out.println(RecordCreators);
		Assert.assertEquals("Record creators 5", RecordCreators);

		Thread.sleep(3000);
		// Held by
		String heldBy = driver.findElementByXPath("//div[@class='filter-togglee']").getText();
		System.out.println(heldBy);

		// Lessthan 10,000 records so select from drop down

		Select sortedBy = new Select(driver.findElementById("sortDrop"));

		sortedBy.selectByIndex(1);
		Thread.sleep(3000);

		// Click export linjk
		driver.findElementByLinkText("Export results").click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		driver.findElementById("dType").click();
		// click Export all reocords as spreadsheet(CSV)
		Thread.sleep(3000);
		driver.findElementById("exp10").click();

		Thread.sleep(3000);

		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);
		// driver.quit();

	}

}
