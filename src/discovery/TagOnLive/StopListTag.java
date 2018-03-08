package discovery.TagOnLive;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.QuitAction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StopListTag {
	
	@Test
		
		public void tag ()throws InterruptedException{
			

        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//Enter the URL
		driver.get("http://discovery.nationalarchives.gov.uk/details/r/C7351413");
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
		//click the sigin in
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//a[@href='/sign-in'])[3]").click();
		
		driver.findElementById("UserName").sendKeys("shanvivenkatesh@gmail.com");
		
		driver.findElementById("Password").sendKeys("Shanvi2016");
		//click sign in
		
		driver.findElementByClassName("singleColumnSubmit").click();
		
	
		//enter tag
		driver.findElementById("tagEntryText").sendKeys("abuse");
				
		//click add tag
	    Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Add tag']").click();
		Thread.sleep(3000);
		String actual = driver.findElementById("tag-add-failure-message").getText();
		System.out.println(actual);
		
		//Verify the message
		
		Assert.assertEquals("An error occurred when processing your request to add this tag. This may be because it does not comply with tagging guidelines (see link above).", actual);
		
		
		driver.quit();
		}	
}

