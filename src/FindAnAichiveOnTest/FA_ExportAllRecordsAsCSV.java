package FindAnAichiveOnTest;

import java.io.IOException;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class FA_ExportAllRecordsAsCSV extends Wrapper_methods {

	// Open the browser

	public void ExportAllRecordsAsCSV() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/find-an-archive", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("archive-search").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();
		Thread.sleep(3000);

		/*
		 * Select sortedBy = new Select(driver.findElementById("sortDrop"));
		 * 
		 * sortedBy.selectByIndex(1); Thread.sleep(3000);
		 */

		// Click Export result

		driver.findElementByLinkText("Export results").click();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,700)");

		Thread.sleep(3000);

		driver.findElementById("dType").click();
		// click Export all reocords as spreadsheet(CSV)
		Thread.sleep(3000);
		driver.findElementById("exp10").click();

		Thread.sleep(3000);
		driver.executeScript("scroll(0,300)");
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);
		driver.quit();

	}

}
