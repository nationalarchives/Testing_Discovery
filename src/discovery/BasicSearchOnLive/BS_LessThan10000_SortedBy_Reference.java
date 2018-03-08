package discovery.BasicSearchOnLive;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.hamcrest.Matcher;
import org.hamcrest.core.Every;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class BS_LessThan10000_SortedBy_Reference {

	// Open the browser

	public void SortedBy_Reference() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("Titanic");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Total number of records for the nelson
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);
		Assert.assertEquals("Records 7,910", Records);

		// Total number records creators
		String RecordCreators = driver.findElementById("nameAuthorities")
				.getText();
		System.out.println(RecordCreators);
		Assert.assertEquals("Record creators 5", RecordCreators);

		Thread.sleep(3000);
		// Held by
		String heldBy = driver.findElementByXPath(
				"//div[@class='filter-togglee']").getText();
		System.out.println(heldBy);

		// Lessthan 10,000 records so select from drop down

		Select sortedBy = new Select(driver.findElementById("sortDrop"));

		sortedBy.selectByIndex(1);
		Thread.sleep(3000);

		// Verify the reference status

		String actual = driver.findElementByXPath(
				"(//ul[@id='search-results']/li/a/table/tbody/tr[3]/td[2])[1]")
				.getText();

		System.out.println(actual);
		Assert.assertEquals("None stated", actual);

		Thread.sleep(3000);
		driver.findElementById("nameAuthorities").click();
		//verify reference is not available under record creators

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

		driver.quit();

	}

}
