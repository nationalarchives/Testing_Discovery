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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class UploadeFile extends Wrapper_methods {
	
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
		
	String actual =driver.findElementByLinkText("0001.jpg").getText();
	
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	
	driver.findElementByLinkText("Discard Changes").click();
	
	driver.findElementByXPath("(//input[@id='iaid'])[1]").sendKeys("C14727836");
	Thread.sleep(5000);
	
	driver.findElementByXPath("//input[@value='Edit']").click();
	
	File src = driver.getScreenshotAs(OutputType.FILE);
	//int Screenshot =1;
	FileUtils.copyFile(src, new File("Z:\\Svenkatesh\\Result\\BatchExecution\\Snapshot\\snap"+".jpeg"));
	//Screenshot++;
	
	
	//Screenshot();
	System.out.println(actual);
		
		//clickbyXpath("//input[@value='Edit']");
		String parent = driver.getWindowHandle();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		
		Set<String> Browsers=driver.getWindowHandles();
		
		for(String i:Browsers){
			
			if(!i.equals(parent)){
				
				driver.switchTo().window(i);
				
				driver.get("http://dev.discovery.nationalarchives.gov.uk/details/r/C14727836");
				
				Thread.sleep(3000);
				
//				clickbyLinkText("Show images");
				
				//clickbyID("imageViewerLink");
				
				driver.findElementById("imageViewerLink").click();
				Thread.sleep(3000);				
				//WebElement expected =driver.findElementByXPath("//img[@alt='Thumb item 66/WO/140/91059d03-8747-4413-a325-4e37289d26cb_thb.jpg']");


File src1 = driver.getScreenshotAs(OutputType.FILE);
				//int Screenshot =1;
		FileUtils.copyFile(src1, new File("Z:\\Svenkatesh\\Result\\BatchExecution\\Snapshot\\snap1" +".jpeg"));
				//Screenshot++;
			}
		}
		
		
	
	}

}
