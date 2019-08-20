package FindAnAichiveOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class FA_Export1000RecordsAsXML extends Wrapper_methods {

	// Open the browser

	public void Export1000RecordsAsXML() throws IOException, InterruptedException {

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
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");

		driver.findElementById("dType").click();
		Thread.sleep(3000);

		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as XML file (XML)");
		Thread.sleep(3000);
		;
		driver.executeScript("scroll(0,300)");
		// ((JavascriptExecutor) driver).executeScript("scroll(0,4000)");
		driver.findElementByXPath("//input[@value='Download']").click();

		// Runtime.getRuntime().exec("C:\\Users\\svenkatesh\\Desktop\\Editfile.exe");

		Thread.sleep(10000);

		// driver.quit();

	}

}
