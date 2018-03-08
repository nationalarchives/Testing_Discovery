package browserStack;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class SubscriptionMoDMedalResearchOffice extends Wrapper_methods {
	
	@Test
	
	public void SubscriptionMoDMedalResearchOffice() throws IOException, InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		driver.findElementByXPath("//a[@href='/users/sign_in']").click();
		
		driver.findElementById("user_email_login").sendKeys("webmaster@nationalarchives.gsi.gov.uk");
		
		driver.findElementById("user_password").sendKeys("D1scovery");
		
		driver.findElementByXPath("//input[@value='Sign me in']").click();
		
		driver.findElementById("skip-local-installation").click();
		
		//driver.findElementByLinkText("Enable Local Testing").click();
		
		
		
		//driver.switchTo().alert().accept();
		
		//driver.findElementByXPath("//*[@id='rf-browsers']/div/div[2]/div[2]/ul/li[2]/a").click();
		
		driver.findElementByXPath("//*[@id='rf-browsers']/div/div[2]/div[3]/ul/li[2]/a").click();
		
		
		
		Thread.sleep(20000);
		
		String parent_window= driver.getWindowHandle();
		 
        System.out.println(parent_window);
        
        Set<String> s1=driver.getWindowHandles();
		
		
		
		Iterator <String> i1=s1.iterator();
		
		while(i1.hasNext()){
			
			String child_window =i1.next();
			
			if(!parent_window.equalsIgnoreCase(child_window))
			{
				
				driver.switchTo().window(child_window);
				
				driver.get("nationalarchives.co.uk");
				
				driver.findElementById("fakebox-input").sendKeys("shanthi");
				
			}
			
			driver.switchTo().window(parent_window);
			
		}
		
				
	}
	


}
