package BasicSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_LessThan10000_Export1000RecordCreatorAsXML extends Wrapper_methods {

	// Open the browser

	public void Export1000RecordCreatorAsXML() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// click record creator

		driver.findElementById("nameAuthorities").click();

		// click diaries under creator type

		driver.findElementByPartialLinkText("Diaries").click();

		// Lessthan 10,000 records so select from drop down

		Select sortedBy = new Select(driver.findElementById("sortDrop"));

		sortedBy.selectByIndex(1);
		Thread.sleep(3000);

		// Click Export result

		driver.findElementByLinkText("Export results").click();
		Thread.sleep(3000);
		driver.executeScript("scroll(0,500)");
		// driver.findElementById("show-download-form").click();
		driver.findElementById("dType").click();
		Thread.sleep(3000);

		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as XML file (XML)");
		Thread.sleep(3000);
		// ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);

		// driver.quit();

	}

}
