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

public class BrowserStackChromeSingleSignOn {

	
		
		  public static final String USERNAME = "emmabayne";
		  public static final String AUTOMATE_KEY = "NuCceJunBumUR6nLqu63";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  public static void main(String[] args) throws MalformedURLException, InterruptedException {
			  
		   // DesiredCapabilities caps = new DesiredCapabilities();
			  
			  DesiredCapabilities caps=new DesiredCapabilities();
			  
			 // caps.setPlatform(Platform.XP);
			  
			  /*caps.setCapability("browser", "Chrome");
			    caps.setCapability("browser_version", "49");*/
		    
		caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "11");
		   caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("browserstack.debug", "true");
			  
			 // caps.setCapability("browserstack.debug", "true");

		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    driver.get("http://discovery.nationalarchives.gov.uk/");
		    
		    driver.findElement(By.linkText("Sign in")).click();
		    
		    driver.findElement(By.id("UserName")).sendKeys("shanvivenkatesh@gmail.com");
			
			driver.findElement(By.id("Password")).sendKeys("Shanvi2016");
			//click sign in
			
			driver.findElement(By.className("singleColumnSubmit")).click();
			
			String verify_Signout=driver.findElement(By.xpath("//div[@id='account-controls-wrapper']/div/ul/li[2]")).getText();
			
			System.out.println(verify_Signout);
			   
			   
			driver.quit();


			
			
		

	

	}

}
