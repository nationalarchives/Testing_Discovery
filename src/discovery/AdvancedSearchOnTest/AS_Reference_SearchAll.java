package discovery.AdvancedSearchOnTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AS_Reference_SearchAll {

	// Open the browser

	@Test
	public void Reference_SearchAll() {

		System.setProperty("webdriver.chrome.driver",
				"./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://test.discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// click Advanced Search

		driver.findElementByLinkText("advanced search").click();
		// Enter reference
		driver.findElementById("reference-search-0").sendKeys("IR 30");

		// click search

		driver.findElementByXPath("(//input[@type='submit'])[3]").click();

		// get the list of table

		List<WebElement> totalNoOfReference = driver
				.findElementsByXPath("//*[@id='search-results']/li/a/table/tbody/tr[3]");

		int count = totalNoOfReference.size();
		System.out.println(count);

		for (int i = 0; i < count; i++) {

			String Allreferences = totalNoOfReference.get(i).getText();
			System.out.println(Allreferences);
			
			if(Allreferences.matches("Reference: IR.*"))
					System.out.println("true");
			
			else
				
				System.out.println("false");

		}
		

		// Click the first record
		driver.findElementByPartialLinkText("Domesday Book").click();
		// Verify reference
		String reference = driver.findElementByXPath("//table[@class='asset-details']/tbody/tr").getText();
		System.out.println(reference);
		if(reference.matches("Reference: IR.*"))
			System.out.println("true");
	
	else
		
		System.out.println("false");


		driver.quit();

		// check whether the reference is highlighted on the home page

	}
}
