package browserStack;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class BrowserStackDataProvider {
	
	

	
		   WebDriver driver;
		
		  public static final String USERNAME = "emmabayne";
		  public static final String AUTOMATE_KEY = "NuCceJunBumUR6nLqu63";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		
			  
			  public Object[][] readExcel(String dataSheetName) throws IOException, InvalidFormatException{
			  File src = new File("./data/ALLBrowsers1.xlsx");	
		        XSSFWorkbook book = new XSSFWorkbook(src);
				
				XSSFSheet sheet = book.getSheetAt(0);
				
				int rowcount = sheet.getLastRowNum();
				
				int  cellcount = sheet.getRow(0).getLastCellNum();
				
				Object [][] obj = new Object[rowcount][cellcount];
				
				for (int i =1; i<=rowcount; i++ )
				{
					
					XSSFRow row = sheet.getRow(i);
					
					for (int j=0 ; j<cellcount; j++)
					{
				
				XSSFCell Cell = row.getCell(j);
				
				obj[i-1][j]=Cell.getStringCellValue();

			}

			}

			return obj;
			}
			  
			  
			  @Test(dataProvider = "BrowserStack",priority=1)
			  
			  public void  BrowserStack(String BrowserName,String Version,String os_version)throws InterruptedException, InvalidFormatException, IOException {
				  
		
			  
			  DesiredCapabilities caps=new DesiredCapabilities();
			  
			
			  
			  caps.setCapability("browser", BrowserName);
			    caps.setCapability("browser_version", Version);
			    caps.setCapability("os", "Windows");
			    //caps.setCapability("os_version", os_version);
			   caps.setCapability("os_version", os_version);
			    
		    		    
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
				((JavascriptExecutor) driver).executeScript("scroll(0,4800)");
				
				
				driver.findElement(By.xpath("(//input[@type='submit'])[4]")).click();

				Thread.sleep(3000);
				String yourFliters = driver.findElement(By.id("search-refine")).getText();

				System.out.println(yourFliters);

				Assert.assertTrue(yourFliters.contains(Acutal));

				Assert.assertTrue(yourFliters.contains("The National Archives"));
				driver.quit();
			
			  }

	
			  @DataProvider(name = "BrowserStack")
				public Object[][] createleadData() throws IOException, InvalidFormatException {
					return readExcel("ALLBrowsers1");
						}
					
				/*@AfterMethod
				
				public void close() throws Exception
				{
					
				}
			  */

	}


