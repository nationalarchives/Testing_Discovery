package discovery.AdvancedSearchOnTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AS_Search_Find_DontFindWord {

	@Test
	public void Find_DontFindWord() throws IOException, InterruptedException {

		// launch browser

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// open url
		driver.get("http://test.discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);

		// click advanced search

		driver.findElementByLinkText("advanced search").click();
		// Enter find word

		driver.findElementById("all-words-records").sendKeys("james");
		// enter dont find word

		driver.findElementById("exact-words-records").sendKeys("grahamslaw");
		// click the search button

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();

		// get the total no of records

		String Records = driver.findElementById("records-tab").getText();
		System.out.println(Records);

		Assert.assertTrue(Records.contains("Records 2"));

		// click again advance search link

		driver.findElementByLinkText("Advanced search").click();

		// enter dont find words

		driver.findElementById("not-words-records-one").sendKeys("corps");

		// click the search button

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();

		// get the total no of records

		String Records1 = driver.findElementById("records-tab").getText();
		System.out.println(Records1);

		Assert.assertTrue(Records1.contains("Records 1"));
		// verify the message

		
		 String searchResult = driver.findElementByXPath("//div[@class='col starts-at-full clr box results-form']").getText();
		 System.out.println(searchResult); 
		 
		 //verify searchResult
		  //Assert.assertTrue(searchResult.contains("Search results for (james AND "grahamslaw") NOT corps"));
		  
		 driver.quit();
		 

	}

}
