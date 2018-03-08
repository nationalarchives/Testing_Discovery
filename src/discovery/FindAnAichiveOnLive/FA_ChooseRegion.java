package discovery.FindAnAichiveOnLive;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class FA_ChooseRegion extends Wrapper_methods{
	

	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {

		launchDriver(
				"http://discovery.nationalarchives.gov.uk/find-an-archive",
				"chrome");
		
		Thread.sleep(3000);
	}
	
	@Test
	
	public void ChooseRegion() throws InterruptedException, IOException{
		//choose region
		Select region = new Select(driver.findElementByXPath("//select[@name='selection']"));
		
		region.selectByIndex(2);
		
		Thread.sleep(3000);
		//select county
		clickbyLinkText("All London");
		

		// verify your filters

		String YourFilter = getTextById("search-refine");
		System.out.println(YourFilter);
		Assert.assertTrue(YourFilter.contains("England"));
		
		Assert.assertTrue(YourFilter.contains("London"));
		
		Thread.sleep(3000);
		
	}
		
		
		@Test
		
		public void region2() throws InterruptedException, IOException{
			//choose region
			Select region = new Select(driver.findElementByXPath("//select[@name='selection']"));
			
			region.selectByIndex(0);
			
			Thread.sleep(3000);
			//select county
			clickbyLinkText("All East Midlands");
			

			// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("England"));
			
			Assert.assertTrue(YourFilter.contains("East Midlands"));
			
			Thread.sleep(3000);
		
	}
		
@Test
		
		public void region3() throws InterruptedException, IOException{
			//choose region
			Select region = new Select(driver.findElementByXPath("//select[@name='selection']"));
			
			region.selectByIndex(8);
			
			Thread.sleep(3000);
			//select county
			clickbyLinkText("Cumbria");
			

			// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("England"));
			
			Assert.assertTrue(YourFilter.contains("Yorkshire and the Humber"));
			
			Assert.assertTrue(YourFilter.contains("Cumbria"));
			Thread.sleep(3000);
		
	}
	
	@AfterMethod
	
	public void closeBrowser() throws IOException{
		
		quitBrowser();
	}


}
