package browserStack;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import wrapper.Wrapper_methods;

public class BrowserStackChromeExcel {

	
		
		  public static final String USERNAME = "emmabayne";
		  public static final String AUTOMATE_KEY = "NuCceJunBumUR6nLqu63";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  public static void main(String[] args) throws InterruptedException, InvalidFormatException, IOException {
			  
			  
			  File src = new File("./data/Book1.xlsx");	
		        XSSFWorkbook book = new XSSFWorkbook(src);
				
				XSSFSheet sheet = book.getSheetAt(0);
				
				String BrowserName = sheet.getRow(0).getCell(0).getStringCellValue();
				String version = sheet.getRow(1).getCell(0).getStringCellValue();
				/*String expectedStaffDo = sheet.getRow(2).getCell(22).getStringCellValue();
				String expectedOnsitePublicDo = sheet.getRow(3).getCell(22).getStringCellValue();
				String expectedOffisteDo = sheet.getRow(4).getCell(22).getStringCellValue();*/
			  
		   // DesiredCapabilities caps = new DesiredCapabilities();
			  
			  DesiredCapabilities caps=new DesiredCapabilities();
			  
			 // caps.setPlatform(Platform.XP);
			  
			  caps.setCapability("browser", BrowserName);
			    caps.setCapability("browser_version", version);
		    
		    /*caps.setCapability("browser", "IE");
		    caps.setCapability("browser_version", "7.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "XP");
		    caps.setCapability("browserstack.debug", "true");*/
			  
			  caps.setCapability("browserstack.debug", "true");

		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    driver.get("http://discovery.nationalarchives.gov.uk/");
			   
			   driver.manage().window().maximize();
			    
			    driver.findElement(By.linkText("advanced search")).click();
			    
			    driver.findElement(By.id("all-words-records")).sendKeys("*");

				
				// Select the other archives radio button

				//Select the national archives radio button
				((JavascriptExecutor) driver).executeScript("scroll(0,900)");
				
				driver.findElement(By.id("search-tna-as-repository")).click();
				Thread.sleep(3000);
				
				//select all records radio button
				driver.findElement(By.id("col0")).click();
				Thread.sleep(3000);
				  driver.findElement(By.id("departments-lookup")).sendKeys("gov");

				//enterTextById("departments-lookup", "gov");

				Thread.sleep(3000);

				List<WebElement> li = driver.findElements(By.xpath("(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all'])[3]/li"));

				String Acutal = li.get(2).getText();
				System.out.println(Acutal);
				li.get(2).click();
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("scroll(0,4200)");
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//input[@type='submit'])[4]")).click();

				Thread.sleep(3000);
				String yourFliters = driver.findElement(By.id("search-refine")).getText();

				System.out.println(yourFliters);

				Assert.assertTrue(yourFliters.contains(Acutal));

				Assert.assertTrue(yourFliters.contains("The National Archives"));
				driver.quit();


			
			
		

	

	}

}
