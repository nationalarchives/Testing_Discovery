package BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class BS_NoOfRecordsPerPage15And30And60 extends Wrapper_methods {

	//public RemoteWebDriver driver;

	@BeforeMethod
	public void NoOfRecordsPerPage15And30And60() throws InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	// Enter the word in search
	public void defalutRecordsPerPage() throws InterruptedException {

		List<WebElement> first15Records = driver.findElementsByXPath("//ul[@id='search-results']/li");

		int count = first15Records.size();

		System.out.println("The total records are per page  " + count);

	}

	@Test(priority = 2)
	public void click30() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

		Thread.sleep(2000);

		driver.findElementByXPath("//a[@href='/results/r?_q=%2A&_ps=30']").click();
		Thread.sleep(2000);
		List<WebElement> first30Records = driver.findElementsByXPath("//ul[@id='search-results']/li");

		int count = first30Records.size();

		System.out.println("The total records are per page  " + count);

	}

	@Test(priority = 3)
	public void click60() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

		Thread.sleep(2000);

		driver.findElementByXPath("//a[@href='/results/r?_q=%2A&_ps=60']").click();
		Thread.sleep(2000);
		List<WebElement> first60Records = driver.findElementsByXPath("//ul[@id='search-results']/li");

		int count = first60Records.size();

		System.out.println("The total records are per page  " + count);

	}

	@AfterMethod
	public void closeBrowser() throws IOException {

		quitBrowser();
	}
}
