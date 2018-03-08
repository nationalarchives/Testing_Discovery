package discovery.TagOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import discovery.Ecommerce.Wrapper;

public class AddTag{
	
	@Test
	
	public void tag() throws InterruptedException, Exception{
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver","./chromedriver_win32/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//Enter the URL
		driver.get("http://discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=staffin");
		driver.manage().window().maximize();
		
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		
		//click the sigin in
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//a[@href='/sign-in'])[3]").click();
		
		driver.findElementById("UserName").sendKeys("shanvivenkatesh@gmail.com");
		
		driver.findElementById("Password").sendKeys("Shanvi2016");
		//click sign in
		
		driver.findElementByClassName("singleColumnSubmit").click();
		
		//enter tag
		
		driver.findElementById("tagEntryText").sendKeys("Field Ambulance one");
		
		
		
		//click add tag
	
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Add tag']").click();
		Thread.sleep(3000);
		
		//enter tag
		
		driver.findElementById("tagEntryText").sendKeys("Field Ambulance two");
				
				
				
		//click add tag
			
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Add tag']").click();
		Thread.sleep(3000);
		String actual = driver.findElementByXPath("//div[@class='emphasis-block']").getText();
		System.out.println(actual);
		
		//Verify the message
		
		Assert.assertEquals("Your tag has been added. Thank you.", actual);
		
		// click sign out
		
		driver.findElementByXPath("(//a[@href='/sign-out'])").click();
		
		
				
		
	
	
	driver.close();
		
		
		
		
		
		
		
	
		
	}

}
