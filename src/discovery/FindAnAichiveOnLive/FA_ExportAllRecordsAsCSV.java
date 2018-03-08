package discovery.FindAnAichiveOnLive;

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
public class FA_ExportAllRecordsAsCSV{

	// Open the browser

	public void ExportAllRecordsAsCSV() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://discovery.nationalarchives.gov.uk/find-an-archive");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("archive-search").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();
		Thread.sleep(3000);
		
		/*		 
		Select sortedBy = new Select(driver.findElementById("sortDrop"));
		
		sortedBy.selectByIndex(1);
		Thread.sleep(3000);*/
		
		//Click Export result
		
				driver.findElementById("show-download-form").click();
				// click Export all reocords as spreadsheet(CSV)
				Thread.sleep(3000);
				driver.findElementById("exp10").click();
				
				Thread.sleep(3000);
				driver.findElementByXPath("//input[@value='Download']").click();
				Thread.sleep(3000);
				//driver.quit();
		
	

	}

		}

	

