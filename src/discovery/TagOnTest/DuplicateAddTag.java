package discovery.TagOnTest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import discovery.Ecommerce.Wrapper;

public class DuplicateAddTag{
	
	@Test
	
	public void tag() throws InterruptedException, Exception{
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver","./chromedriver_win32/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//Enter the URL
		driver.get("http://test.discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=staffin");
		driver.manage().window().maximize();
		
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		
		//click the sigin in
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//a[@href='/sign-in'])[3]").click();
		
		driver.findElementById("UserName").sendKeys("shanvivenkatesh@gmail.com");
		
		driver.findElementById("Password").sendKeys("Shanvi2016");
		//click sign in
		
		driver.findElementByClassName("singleColumnSubmit").click();
		
     Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		//enter tag
		
		driver.findElementById("tagEntryText").sendKeys("test");
				
						
		//click add tag
			
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Add tag']").click();
		Thread.sleep(3000);
		String actual = driver.findElementByXPath("//div[@id='tag-add-failure-message']").getText();
		System.out.println(actual);
		
		//Verify the error message
		
		Assert.assertEquals("An error occurred when processing your request to add this tag. This may be because it does not comply with tagging guidelines (see link above).", actual);
		
		// click sign out
		
		driver.findElementByXPath("(//a[@href='/sign-out'])").click();
		
		
				
		
	
	
	driver.close();
		
		
		
		
		
		
		
	
		
	}

}
