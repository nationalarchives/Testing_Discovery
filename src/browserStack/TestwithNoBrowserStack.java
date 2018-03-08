package browserStack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import wrapper.Wrapper_methods;

public class TestwithNoBrowserStack extends Wrapper_methods{

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		
		System.setProperty("webdriver.opera.driver","./Driver/operadriver_win64 (1)/operadriver_win64/operadriver.exe");
		OperaDriver driver = new OperaDriver();
		
		   driver.get("http://discovery.nationalarchives.gov.uk/");
		   
		   driver.manage().window().maximize();
		    
		    driver.findElement(By.linkText("advanced search")).click();
		    
		    driver.findElement(By.id("all-words-records")).sendKeys("*");

			
			// Select the other archives radio button

			//Select the national archives radio button
			((JavascriptExecutor) driver).executeScript("scroll(0,700)");
			
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
			((JavascriptExecutor) driver).executeScript("scroll(0,4000)");
			
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


	