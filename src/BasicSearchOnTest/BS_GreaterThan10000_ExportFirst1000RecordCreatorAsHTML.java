package BasicSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_GreaterThan10000_ExportFirst1000RecordCreatorAsHTML extends Wrapper_methods {

	// Open the browser

	public void ExportFirst1000RecordCreatorAsHTML() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// click record creator

		driver.findElementById("nameAuthorities").click();

		// grater than 10,000 records so select from drop down

		// Click Export result

		driver.findElementByLinkText("Export results").click();
		Thread.sleep(3000);

		driver.executeScript("scroll(0,1000)");
		driver.findElementById("dType").click();
		Thread.sleep(3000);

		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as web page (HTML)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);

		quitBrowser();
	}

}
