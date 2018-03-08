package discovery.BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.hamcrest.Matcher;
import org.hamcrest.core.Every;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

@Test
public class BS_FilterResult_VerifyCollectionAndSubjects {

	// Open the browser

	public void VerifyCollectionAndSubjects() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
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

		// Filter result

		String searchFilters = driver.findElementById("search-filters")
				.getText();
		System.out.println(searchFilters);

		// click the nationalarchive link on held by
		Thread.sleep(3000);
		driver.findElementByLinkText("The National Archives").click();

		// Filter result

		String afterHeldbylinkclick_searchFilters = driver.findElementById("search-filters").getText();
		System.out.println(afterHeldbylinkclick_searchFilters);

		// collection

		List<WebElement> collectionList = driver.findElementsByXPath("//li[@id='department']/form/div/ul/li");

		int count = collectionList.size();

		System.out.println(count);
		String woCheck = collectionList.get(0).getText();

		System.out.println(woCheck);

		Assert.assertTrue(afterHeldbylinkclick_searchFilters.contains(woCheck));

		// Subjects
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
		Thread.sleep(3000);
		driver.findElementById("subject-filters").click();

		List<WebElement> SubjectsList = driver.findElementsByXPath("//li[@id='subjects']/form/div/ul/li");

		int countOnSubject = SubjectsList.size();

		System.out.println(countOnSubject);
		String ArmedForces = SubjectsList.get(0).getText();

		System.out.println(ArmedForces);

		Assert.assertTrue(afterHeldbylinkclick_searchFilters.contains(ArmedForces));
		driver.quit();

	}

}
