package discovery.AdvancedSearchOnLive;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AS_Records_DateRange_SearchAll {
	
	@Test
	
	// Open the browser

		public void DateRange_SearchAll() throws IOException, InterruptedException {

			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();

			driver.get("http://discovery.nationalarchives.gov.uk/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(3000);
			
			driver.findElementByLinkText("advanced search").click();
			Thread.sleep(1000);
			driver.findElementById("all-words-records").sendKeys("nelson");
			Thread.sleep(1000);
			driver.findElementById("any-words-records-one").sendKeys("Mandela");
			Thread.sleep(1000);
			driver.findElementById("from-date").sendKeys("1900");
			Thread.sleep(1000);
			driver.findElementById("to-date").sendKeys("2007");
			
			Thread.sleep(1000);
			
			driver.findElementByXPath("(//input[@type='submit'])[4]").click();
			Thread.sleep(1000);
			String filterResult = driver.findElementById("search-filters").getText();
			
			System.out.println(filterResult);
			
			Assert.assertTrue(filterResult.contains("1900 - 2007"));
			Assert.assertTrue(filterResult.contains("Held by"));
			Assert.assertTrue(filterResult.contains("Date"));
			
			
			driver.quit();
			
			
			
			

}
}