
package discovery.TagOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import discovery.Ecommerce.Wrapper;

public class DeleteTag{
	
	@Test
	
	public void deleteTag() throws InterruptedException, Exception{
		
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
		
		//Delete tag
		
		driver.findElementByXPath("(//a[@class='tagName deleteTag users-tag-list-item'])[1]").click();
		Thread.sleep(3000);
		driver.switchTo().alert();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//get deletion message
		String actual = driver.findElementById("tag-delete-success-message").getText();
		System.out.println(actual);
		
		//verify the deletion message
		
		//Assert.assertEquals(actual, "Your tag deletion request was successful");
		
		Assert.assertEquals(actual, "Your tag has been deleted.");
		
		
		 //click sign out
		
		driver.findElementByXPath("(//a[@href='/sign-out'])").click();
		
	    driver.close();
		
		
		
		
		
		
		
	
		
	}

}
