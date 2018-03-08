package discovery.BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.hamcrest.Matcher;
import org.hamcrest.core.Every;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class BS_LessThan10000_Export1000RecordCreatorAsXML{

	// Open the browser

	public void Export1000RecordCreatorAsXML() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://test.discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);
		
		//click record creator
		
		driver.findElementById("nameAuthorities").click();
		
		//click diaries under creator type
		
		driver.findElementByPartialLinkText("Diaries").click();
		
		 //Lessthan 10,000 records so select from drop down
		 
		Select sortedBy = new Select(driver.findElementById("sortDrop"));
		
		sortedBy.selectByIndex(1);
		Thread.sleep(3000);
		
		//Click Export result
		
		driver.findElementById("show-download-form").click();
		Thread.sleep(3000);
		 
		Select format = new Select(driver.findElementById("dType"));
		
		format.selectByVisibleText("as XML file (XML)");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Download']").click();
		Thread.sleep(3000);
		
		//driver.quit();
		
		

	}

		}

	

