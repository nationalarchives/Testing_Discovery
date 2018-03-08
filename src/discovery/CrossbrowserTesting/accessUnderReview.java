package discovery.CrossbrowserTesting;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class accessUnderReview {

	RemoteWebDriver driver;
	
	@Test
	@Parameters("Browser")
	
	public void accessUnderReview(String browser) throws InvalidFormatException, IOException, InterruptedException	{
				
		if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Softwares\\Selenium\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if(browser.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", "C:\\Softwares\\Selenium\\Driver\\IEDriverServer_x64_2.39.0\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
			File src = new File("./data/ALLOptions.xlsx");
			
			XSSFWorkbook book = new XSSFWorkbook(src);

			XSSFSheet sheet = book.getSheetAt(0);

			String deliveryOptionType = sheet.getRow(0).getCell(1).getStringCellValue();
			String iaid = sheet.getRow(1).getCell(1).getStringCellValue();
			String expectedValeStaff = sheet.getRow(2).getCell(1).getStringCellValue();

	    driver.get(iaid);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML"));

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("AccessUnderReview"));

		String actual = driver.findElementByXPath("//div[@class='order-option-wrapper']").getText();
		
		System.out.println(actual);
		
		Assert.assertEquals(expectedValeStaff, actual);
				
		Thread.sleep(3000);

		driver.quit();

	}

}
