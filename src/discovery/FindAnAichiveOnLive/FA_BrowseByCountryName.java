package discovery.FindAnAichiveOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class FA_BrowseByCountryName extends Wrapper_methods{
	
	
		@BeforeMethod
		public void launchBrowser() throws InterruptedException {

			launchDriver(
					"http://discovery.nationalarchives.gov.uk/find-an-archive",
					"chrome");
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			
			Thread.sleep(3000);
		}
		
		
		@Test
		
		public void BrowseByCountryName() throws IOException, InterruptedException{
			
			clickbyLinkText("B");
			Thread.sleep(3000);
			
			String getCountry= getTextByXpath("//ul[@class='countries-selector']");
			System.out.println(getCountry);
			
			//click the country
			Thread.sleep(3000);
			clickbyLinkText("Belgium");
			
			
			// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("Belgium"));
			Thread.sleep(3000);
		}
		
		
		
@Test
		
		public void BrowseCountryname2() throws IOException, InterruptedException{
			
			clickbyLinkText("Z");
			Thread.sleep(3000);
			
			String getCountry= getTextByXpath("//ul[@class='countries-selector']");
			System.out.println(getCountry);
			
			//click the country
			Thread.sleep(3000);
			clickbyLinkText("Zambia");
			
			
			// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("Zambia"));
			Thread.sleep(3000);
		}


@AfterMethod

public void closeBrowser() throws IOException{
	
	quitBrowser();
}






	}
	
	
	
	

