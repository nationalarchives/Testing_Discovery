package browserStack;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import wrapper.Wrapper_methods;

public class BS_SingleSignOn_Android {

	
		
		  public static final String USERNAME = "emmabayne";
		  public static final String AUTOMATE_KEY = "NuCceJunBumUR6nLqu63";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  public static void main(String[] args) throws MalformedURLException, InterruptedException {
			  
		 
			  DesiredCapabilities caps=new DesiredCapabilities();
			  
			  
			  
			  caps.setCapability("device", "Samsung Galaxy S8");
			  caps.setCapability("realMobile", "true");
			  caps.setCapability("os_version", "7.0");
			  
		  /*  caps.setCapability("browserName", "Firefox");
		    caps.setCapability("browser_version", "61");
		    caps.setCapability("platform", "MAC");
		    // caps.setCapability("os", "Windows");
		    caps.setCapability("device", "iPhone 6S Plus");
		    caps.setCapability("browserstack.debug", "true");*/
			  
			 // caps.setCapability("browserstack.debug", "true");

		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    
		    driver.get("http://discovery.nationalarchives.gov.uk/");
		    
		    driver.findElement(By.linkText("Sign in")).click();
		    
		    Thread.sleep(3000);
		    
			((JavascriptExecutor) driver).executeScript("scroll(0,600)");
			
			 Thread.sleep(3000);
			 
		    driver.findElement(By.id("UserName")).sendKeys("shanvivenkatesh@gmail.com");
			
			driver.findElement(By.id("Password")).sendKeys("Shanvi2016");
			//click sign in
			
			driver.findElement(By.className("singleColumnSubmit")).click();
			 Thread.sleep(3000);
			Thread.sleep(3000);
			String verify_Signout=driver.findElement(By.xpath("//div[@id='account-controls-wrapper']/div/ul/li[2]")).getText();
			
			System.out.println(verify_Signout);
			
			driver.findElement(By.linkText("Sign out")).click();
			   
			   
			driver.quit();


			
			
		

	

	}

}
