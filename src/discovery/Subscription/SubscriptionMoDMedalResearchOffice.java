package discovery.Subscription;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SubscriptionMoDMedalResearchOffice {
	
	@Test
	
	public void SubscriptionMoDMedalResearchOffice() throws IOException, InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://discovery.nationalarchives.gov.uk/readerticketdemo/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		
		driver.findElementByClassName("button").click();
				
		Thread.sleep(3000);
		
		driver.findElementById("ticket").sendKeys("110110");
			
		Thread.sleep(3000);
		
		driver.findElementByXPath("//input[@value='Validate barcode']").click();
		
		String title = driver.findElementByXPath("//*[@id='account-controls']/ul/li[1]").getText();
		
		System.out.println(title);
		
		Assert.assertEquals("Subscription (MoD Medal Research Office)", title);
		
		Thread.sleep(3000);
		driver.get("http://discovery.nationalarchives.gov.uk/details/r/D431198");
		Thread.sleep(5000);
		System.out.println(driver.findElementByClassName("discoveryPrimaryCallToActionLink").getText());
					
		String subcriptioncheck = driver.findElementByClassName("order-option-wrapper").getAttribute("innerHTML");
		
		System.out.println(subcriptioncheck);
		
		Assert.assertTrue(subcriptioncheck.contains("Subscription"));

		Assert.assertTrue(subcriptioncheck.contains("DigitizedDiscovery"));
		
		driver.quit();
		
		
		
		
		
		
	}
	


}
