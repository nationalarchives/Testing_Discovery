package BasicSearchOnTest;

import java.io.IOException;
/*import org.hamcrest.core.Every;
import org.hamcrest.core.StringContains;*/
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_GreaterThan10000_ExportFirst1000ASHTML extends Wrapper_methods {

	// Open the browser

	public void ExportFirst1000ASHTML() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Total number of records for the nelson
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);

		if (Records.matches("Records 41,[0-999].*"))

			System.out.println(true);
		else

			System.out.println(false);
		// Assert.assertEquals("Records 41,257", Records);
		// Assert.assertEquals("Records 41,248", Records);

		// Total number records creators
		String RecordCreators = driver.findElementById("nameAuthorities").getText();
		System.out.println(RecordCreators);
		// Assert.assertEquals("Record creators 162", RecordCreators);
		Assert.assertEquals("Record creators 163", RecordCreators);

		Thread.sleep(3000);
		// Held by
		String heldBy = driver.findElementByXPath("//div[@class='filter-togglee']").getText();
		System.out.println(heldBy);

		// Sorted message

		String sortingMessage = driver.findElementByXPath("//span[@class='emphasis-block']").getText();

		System.out.println(sortingMessage);

		Assert.assertEquals(
				"Sorting is only enabled when there are fewer than 10,000 results. Refine the search to reduce the number of results to enable sorting.",
				sortingMessage);

		driver.findElementByLinkText("Export results").click();

		driver.executeScript("scroll(0,500)");
		// Click Export result the first 1000
		Thread.sleep(3000);
		driver.findElementById("dType").click();
		Thread.sleep(3000);
		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as web page (HTML)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);
		// driver.quit();
	}

}
