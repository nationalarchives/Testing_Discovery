package FindAnAichiveOnTest;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class FA_ExportFirst1000RecordCreatorAsHTML extends Wrapper_methods {

	// Open the browser

	public void ExportFirst1000RecordCreatorAsHTML() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/find-an-archive", "chrome");
		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("archive-search").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();
		Thread.sleep(3000);

		// Click Export result

		driver.findElementByLinkText("Export results").click();
		Thread.sleep(3000);
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		driver.findElementById("dType").click();
		Thread.sleep(3000);

		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as web page (HTML)");
		Thread.sleep(3000);
		driver.executeScript("scroll(0,300)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);

		// driver.quit();

	}

}
