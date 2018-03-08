package discovery.AdvancedSearchOnLive;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AS_SearchOtherArchives {
	
	@Test
	
	// Open the browser

		public void searchOtherArchives() throws IOException, InterruptedException {

			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();

			driver.get("http://discovery.nationalarchives.gov.uk/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(3000);
			
			driver.findElementByLinkText("advanced search").click();
			Thread.sleep(1000);
			driver.findElementById("all-words-records").sendKeys("*");
			Thread.sleep(1000);
			//Select the other archives radio button
			((JavascriptExecutor) driver).executeScript("scroll(0,550)");
			Thread.sleep(1000);
			driver.findElementById("search-other-repositories").click();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0,600)");
			driver.findElementByXPath("(//input[@type='submit'])[4]").click();
			Thread.sleep(1000);
			String filterResult = driver.findElementById("search-filters").getText();
			
			System.out.println(filterResult);
			
	        Assert.assertTrue(filterResult.contains("Held by"));
			Assert.assertTrue(filterResult.contains("Date"));
			
			// Total number of records for otherArchives
			String Records = driver.findElementById("records-tab").getText();
			System.out.println(Records);
			if(Records.matches("Records 10,[0-9].*,[0-9].*"))
				
				System.out.println(true);
			else
				System.out.println(false);
			//Assert.assertEquals("Records 10,684,024", Records);
			
			
			driver.quit();
			
			
			
			

}
}