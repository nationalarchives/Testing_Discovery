package discovery.AdvancedSearchOnLive;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class AS_ClosureStatus_Retained_AnyTime extends Wrapper_methods{
	
	
	@Test
	
	// Open the browser

		public void Retained_AnyTime() throws IOException, InterruptedException {

			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		   driver = new ChromeDriver();

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
			
            
          //Record opening date anytime
            
            clickbyID("rodAny");
			
			//Record closure status -check the box for open
			
			driver.findElementById("cs-R").click();
			Thread.sleep(3000);
			//click search button
			
			Thread.sleep(3000);
			driver.findElementByXPath("(//input[@type='submit'])[4]").click();
			
			//total no of Retained records
			Thread.sleep(3000);
			String Records = driver.findElementById("records-tab").getText();
			System.out.println(Records);
			if(Records.matches("Records 31,[0-9].*"))
				
				System.out.println(true);
			
			else
				
				System.out.println(false);
			
			
			//verify your filters
			String yourfilter = driver.findElementById("search-refine").getText();
			
			System.out.println(yourfilter);
			
			Assert.assertTrue(yourfilter.contains("The National Archives"));
			Assert.assertTrue(yourfilter.contains("Retained Document"));
			//click the first record link
			Thread.sleep(3000);
			driver.findElementByXPath("//ul[@id='search-results']/li[1]").click();
			((JavascriptExecutor) driver).executeScript("scroll(0,550)");

			//verify the date
			Thread.sleep(3000);
			String Verify_RetainedDocument=driver.findElementByXPath("//table[@class='asset-details']").getText();
			
			System.out.println(Verify_RetainedDocument);
			
			//Assert.assertTrue(Verify_RetainedDocument.contains("Reconsideration due in: 2022"));
	
			
			driver.quit();
			
			
			
			

}
}