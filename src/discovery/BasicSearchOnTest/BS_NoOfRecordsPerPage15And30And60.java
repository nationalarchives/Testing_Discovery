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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BS_NoOfRecordsPerPage15And30And60 {

	public RemoteWebDriver driver;

	@BeforeMethod
	public void NoOfRecordsPerPage15And30And60() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://test.discovery.nationalarchives.gov.uk/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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

		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");

		Thread.sleep(2000);

		driver.findElementByXPath("//a[@href='/results/r?_q=%2A&_ps=30']").click();
		Thread.sleep(2000);
		List<WebElement> first30Records = driver.findElementsByXPath("//ul[@id='search-results']/li");

		int count = first30Records.size();

		System.out.println("The total records are per page  " + count);

	}

	@Test(priority = 3)
	public void click60() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");

		Thread.sleep(2000);

		driver.findElementByXPath("//a[@href='/results/r?_q=%2A&_ps=60']").click();
		Thread.sleep(2000);
		List<WebElement> first360Records = driver.findElementsByXPath("//ul[@id='search-results']/li");

		int count = first360Records.size();

		System.out.println("The total records are per page  " + count);

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}
