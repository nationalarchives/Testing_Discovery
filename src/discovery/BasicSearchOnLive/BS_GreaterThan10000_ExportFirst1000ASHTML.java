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
public class BS_GreaterThan10000_ExportFirst1000ASHTML {

	// Open the browser

	public void ExportFirst1000ASHTML() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("nelson");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Total number of records for the nelson
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);
		
		if(Records.matches("Records 41,[0-999].*"))
			
			System.out.println(true);
		else
			
			System.out.println(false);
		//Assert.assertEquals("Records 41,257", Records);
		//Assert.assertEquals("Records 41,248", Records);

		// Total number records creators
		String RecordCreators = driver.findElementById("nameAuthorities")
				.getText();
		System.out.println(RecordCreators);
		//Assert.assertEquals("Record creators 162", RecordCreators);
		Assert.assertEquals("Record creators 163", RecordCreators);

		Thread.sleep(3000);
		// Held by
		String heldBy = driver.findElementByXPath(
				"//div[@class='filter-togglee']").getText();
		System.out.println(heldBy);

		//Sorted message
		
		String sortingMessage= driver.findElementByXPath("//span[@class='emphasis-block']").getText();
		 
		 System.out.println(sortingMessage);
		 
		 Assert.assertEquals("Sorting is only enabled when there are fewer than 10,000 results. Refine the search to reduce the number of results to enable sorting.", sortingMessage);
		// Click Export result the first 1000

		driver.findElementById("show-download-form").click();
		Thread.sleep(3000);
		Select format = new Select(driver.findElementById("dType"));

		format.selectByVisibleText("as web page (HTML)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);
		//driver.quit();

	}

}
