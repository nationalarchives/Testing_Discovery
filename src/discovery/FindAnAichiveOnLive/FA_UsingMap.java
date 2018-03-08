package discovery.FindAnAichiveOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class FA_UsingMap extends Wrapper_methods{
	
	
		@BeforeMethod
		public void launchBrowser() throws InterruptedException {

			launchDriver(
					"http://discovery.nationalarchives.gov.uk/find-an-archive",	"chrome");
			
			
			Thread.sleep(3000);
		}
		
		
		@Test
		
		public void usingmap() throws IOException, InterruptedException{
			
			clickbyID("SCOT_1_");
			Thread.sleep(3000);
			
			// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("Scotland"));
			Thread.sleep(3000);
		}
		
		
		
@Test
		
		public void BrowseCountryname2() throws IOException, InterruptedException{
			
		clickbyID("GL_1_");
			Thread.sleep(3000);
			
					// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("England"));
			Assert.assertTrue(YourFilter.contains("London"));
			Thread.sleep(3000);
		}


@AfterMethod

public void closeBrowser() throws IOException{
	
	quitBrowser();
}






	}
	
	
	
	

