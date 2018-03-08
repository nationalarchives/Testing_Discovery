package discovery.AdvancedSearchOnLive;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AS_ClosureStatus_Open_SpecificDate{
	
	
	@Test
	
	// Open the browser

		public void Open_SpecificDate() throws IOException, InterruptedException {

			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();

			driver.get("http://discovery.nationalarchives.gov.uk/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(3000);
			//Click advanced Search
		
			driver.findElementByLinkText("advanced search").click();
			
			//Enter words
			driver.findElementById("all-words-records").sendKeys("*");
			
			//Select the national archives radio button
			((JavascriptExecutor) driver).executeScript("scroll(0,550)");
			Thread.sleep(1000);
			driver.findElementById("search-tna-as-repository").click();
			Thread.sleep(1000);
			
			//select all records radio button
			driver.findElementById("col0").click();
			
            ((JavascriptExecutor) driver).executeScript("scroll(0,3700)");
			
            
            //Record opening specific date
            
            driver.findElementById("rodDateRadio").click();
            //Enter the date
            
           driver.findElementById("rodDate").sendKeys("05/07/1999");
			Thread.sleep(3000);
            
           // driver.findElementById("rodAny").click();
            
			
			//Record closure status -check the box for open
			
			driver.findElementById("cs-O").click();
			Thread.sleep(3000);
			//click search button
			
			Thread.sleep(3000);
			driver.findElementByXPath("(//input[@type='submit'])[4]").click();
			
			//verify the no of records
			Thread.sleep(3000);
			String Records = driver.findElementById("records-tab").getText();
			System.out.println(Records);
			
			Assert.assertEquals("Records 60", Records);
			
			//verify your filters
			String yourfilter = driver.findElementById("search-refine").getText();
			
			System.out.println(yourfilter);
			
			Assert.assertTrue(yourfilter.contains("The National Archives"));
			Assert.assertTrue(yourfilter.contains("Open Document"));
			
			//click the first record link
			Thread.sleep(3000);
			driver.findElementByXPath("//ul[@id='search-results']/li[1]").click();
			((JavascriptExecutor) driver).executeScript("scroll(0,550)");
			
			//verify the date
			Thread.sleep(3000);
			String OpenStatus=driver.findElementByXPath("//table[@class='asset-details']").getText();
			
			System.out.println(OpenStatus);
			
			Assert.assertTrue(OpenStatus.contains("Record opening date: 05 July 1999"));
	
			
			driver.quit();
			
			
			
			

}
}