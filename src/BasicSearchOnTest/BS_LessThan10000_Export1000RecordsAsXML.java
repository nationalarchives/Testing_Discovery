package BasicSearchOnTest;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@org.testng.annotations.Test
public class BS_LessThan10000_Export1000RecordsAsXML extends Wrapper_methods {

	// Open the browser
    @org.testng.annotations.Test
	public void Export1000RecordsAsXML() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("Titanic");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Lessthan 10,000 records so select from drop down

		Select sortedBy = new Select(driver.findElementById("sortDrop"));

		sortedBy.selectByIndex(1);
		Thread.sleep(3000);
		// Click simple view
		driver.findElementByLinkText("Simple view").click();

		// Click Export result
		driver.findElementByLinkText("Export results").click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		driver.findElementById("dType").click();
		Thread.sleep(3000);

		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as XML file (XML)");
		Thread.sleep(3000);

		driver.findElementByXPath("//input[@value='Download']").click();

		// Runtime.getRuntime().exec("C:\\Users\\svenkatesh\\Desktop\\Editfile.exe");

		Thread.sleep(10000);

		// driver.quit();

	}

}
