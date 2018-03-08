package discovery.FileHandler;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class FH_MoveFile extends Wrapper_methods {
	
	@Test
	
	public void uploadfile() throws IOException, InterruptedException, AWTException{
		
		/*launchDriver("http://dev.discovery.nationalarchives.gov.uk/details/r/0125874efb9c41f78f1cfdbdb1544e08", "chrome");
		
		clickbyLinkText("Show images");
		
	System.out.println(driver.findElementByXPath("//div[@class='thumb-item ng-scope'][1]").getAttribute("innerHTML"));
	*/
		//launchDriver("http://wb-d-soaapp1.web.local/DiscoveryFileHandler", "chrome");
		
		/*System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://wb-d-soaapp1.web.local/DiscoveryFileHandler");
		
         driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Runtime.getRuntime().exec("C:\\Users\\svenkatesh\\Desktop\\AUTOITScript\\HandleAuthentication.exe");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+ "t");
		
		driver.get("http://dev.discovery.nationalarchives.gov.uk/");
		
		//driver.switchTo().alert().accept();
		
		
	}*/
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://wb-d-soaapp1.web.local/DiscoveryFileHandler");
		
         driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Runtime.getRuntime().exec("C:\\Users\\svenkatesh\\Desktop\\AUTOITScript\\HandleAuthentication.exe");
		Thread.sleep(5000);
		
		
		driver.findElementByXPath("(//input[@id='iaid'])[1]").sendKeys("C14727836");
		Thread.sleep(5000);
		
		driver.findElementByXPath("//input[@value='Edit']").click();
		
		Thread.sleep(5000);
		
		//move file
		
		driver.findElementByXPath("(//img[@alt='Move file'])[1]").click();
		
		//enter the no to move 
		System.out.println(driver.findElementByXPath("(//input[@type='number'])[1]").getLocation());
		System.out.println(driver.findElementByXPath("(//input[@type='number'])[1]").getText());
		
driver.findElementByXPath("(//input[@type='number'])[1]").sendKeys("10");

driver.findElementByXPath("(//input[@value='Move'])[1]").click();

System.out.println(driver.findElementByXPath("(//div[@class='file-detail'])[10]").getLocation());


System.out.println(driver.findElementByXPath("(//div[@class='file-detail'])[10]").getText());
		
		
		
	
	}

}
