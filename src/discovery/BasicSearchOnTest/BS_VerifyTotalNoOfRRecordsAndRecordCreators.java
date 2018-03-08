package discovery.BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.hamcrest.Matcher;
import org.hamcrest.core.Every;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



@Test
public class BS_VerifyTotalNoOfRRecordsAndRecordCreators{

	// Open the browser

	public void VerifyTotalNoOfRRecordsAndRecordCreators() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://test.discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Total number of records for *
		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);
		if(Records.matches("Records 34,[0-9].*,[0-9].*"))
			
			System.out.println(true);
		
		else
			System.out.println(false);
		
		// Total number records creators
		String RecordCreators = driver.findElementById("nameAuthorities").getText();
		System.out.println(RecordCreators);
   if(RecordCreators.matches("Record creators 261,[0-9].*"))
			
			System.out.println(true);
		
		else
			System.out.println(false);
		
		Thread.sleep(3000);
		// Held by
		String heldBy = driver.findElementByXPath("//div[@class='filter-togglee']").getText();
		System.out.println(heldBy);
		
		String Date = driver.findElementByXPath("(//div[@class='filter-togglee'])[2]").getText();

		System.out.println(Date);
		Thread.sleep(3000);
		List<WebElement> checkbox = driver.findElementsByXPath("//input[@type='checkbox']");

		int count = checkbox.size();

		System.out.println(count);

		checkbox.get(0).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Refine']").click();
		
		
		String yourfilter = driver.findElementById("search-refine").getText();
		
		System.out.println(yourfilter);
		
		Assert.assertTrue(yourfilter.contains("Dates unknown"));

		driver.quit();

	}

}
