package wrappers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Days360;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrapper_methods {
	public RemoteWebDriver driver;

	int sCount = 1;

	public void launchDriver(String url, String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\Selenium\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void quitBrowser() throws IOException {
		try {
			driver.quit();

		} catch (WebDriverException e) {
			System.out.println("Unable to close the browser...");
		} finally {

		}
	}

	public void enterTextById(String id, String idValue) {
		try {
			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(idValue);
		} catch (NoSuchElementException e) {
			System.out.println("The Element with id : " + id + " is not available");
		} finally {

		}
	}

	public void clickbyXpath(String xpath) throws IOException {
		try {
			driver.findElementByXPath(xpath).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with xpath:" + xpath + "is not found");
		} finally {

		}
	}

	public String getTextById(String id) throws IOException {
		String str = null;
		try {
			str = driver.findElementById(id).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Id : " + id + " is not available");
		} finally {

		}
		return str;
	}

	public void clickbyID(String id) throws IOException {
		try {
			driver.findElementById(id).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with id" + id + "is not found");
		} finally {
		}
	}

	public void enterByTextXpath(String xPath, String xPathvalue) {
		try {
			driver.findElementByXPath(xPath).clear();
			driver.findElementByXPath(xPath).sendKeys(xPathvalue);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with Xpath : " + xPath + " is not available");
		} finally {

		}
	}

	public boolean selectbyvisibletext_Byname(String name, String value) throws IOException {
		boolean flag = false;
		int screenshotcount = 1;
		try {
			Select dropdown1 = new Select(driver.findElementByName(name));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size = alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				// System.out.println("Dropdowns 'options' are :" +text);
			}
			// System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {

			System.out.println("The Element with id :" + name + "is not available");
		} finally {
			/*
			 * //Take snapshot File src =
			 * driver.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(src,
			 * new File("./Snapshot/snap"+screenshotcount+".jpeg"));
			 * screenshotcount++;
			 */
		}
		return flag;

	}

	public boolean selectbyvisibletext_Byxpath(String xpath, String value) throws IOException {
		boolean flag = false;
		int screenshotcount = 1;
		try {
			Select dropdown1 = new Select(driver.findElementByXPath(xpath));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size = alloptions.size();

			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				// System.out.println("Dropdowns 'options' are :" +text);
			}
			System.out.println("The size of the dropdown is :" + size);
		} catch (NoSuchElementException e) {

			// System.out.println("The Element with id :"+xpath+"is not
			// available");
		} finally {
			// Take snapshot
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snapshot/snap" + screenshotcount + ".jpeg"));
			screenshotcount++;
		}
		return flag;

	}

	// Click on webelement using LinkText

	public void clickbyLinkText(String linktext) throws IOException {
		try {
			driver.findElementByLinkText(linktext).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element with linktext:" + linktext + "is not found");

		} finally {
			// Screenshot();
		}
	}

	// Wrapper for getTextBy Xpath

	public String getTextByXpath(String xpath) throws IOException {
		String str = null;
		try {
			str = driver.findElementByXPath(xpath).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The Element with Xpath : " + xpath + " is not available");
		} finally {

		}
		return str;
	}

	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try {
			driver.findElement(By.className(classVal)).click();
			// Reporter.reportStep("The element with class Name: "+classVal+" is
			// clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			// Reporter.reportStep("The element with class Name: "+classVal+"
			// could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	// Screenshot Method

	public void Screenshot() throws IOException {

		// Take snapshot
		File ScreenShot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenShot, new File("./Snapshots/snap" + System.currentTimeMillis() + ".jpeg"));
		System.out.println("Counter count - " + sCount);
		sCount = sCount + 1;
	}

	public void SingleSignOn() {

		try {
			driver.findElementById("UserName").sendKeys("discovery@nationalarchives.gov.uk");

			driver.findElementById("Password").sendKeys("DiscoveryTest1");
			// click sign in

			driver.findElementByClassName("singleColumnSubmit").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectByValue_UsingId(String id, String Value) throws IOException {

		try {
			Select dropdown = new Select(driver.findElementById(id));
			List<WebElement> allOptions = dropdown.getOptions();
			dropdown.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.err.println("The dropdown with id - " + id + " not found.");
		} finally {
			Screenshot();
		}

	}

	public void GetBulkOrderURL() {

		try {
			driver.get("https://dev.bulkorders.nationalarchives.gov.uk/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	/*public void Date(){

		LocalDate date = LocalDate.now();
		if(date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.MONDAY)
		{

			LocalDate Lastweek = date.minusDays(7);
		}
		else if (date.getMonth() == Month.JANUARY || date.getMonth() == Month.DECEMBER ) {
			LocalDate Last6months = date.minusMonths(6);
		}
		else if (date.getYear() == Month.JANUARY || date.getYear() == Month.DECEMBER ){
			LocalDate Last12months = date.minusMonths(12);

		}

	}


		public static void Date() {

			LocalDate date = LocalDate.now();
			LocalDate Lastday = date.minusDays(1);

			LocalDate date1 = LocalDate.now();
			LocalDate Lastweek = date1.minusDays(7);

			LocalDate date2 = LocalDate.now();
			LocalDate Last6months = date2.minusMonths(6);

			LocalDate date3 = LocalDate.now();
			LocalDate Last12months = date3.minusMonths(12);



		}*/

	public class TestDate3 {

		public void main(String[] args) throws ParseException {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-mmm-yyyy");

			String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
			System.out.println(actual);
			LocalDate date = LocalDate.now();
			LocalDate Lastday = date.minusDays(1);

			LocalDate date1 = LocalDate.now();
			LocalDate Lastweek = date1.minusDays(7);


			LocalDate date2 = LocalDate.now();
			LocalDate Last6months = date2.minusMonths(6);

			LocalDate date3 = LocalDate.now();
			LocalDate Last12months = date3.minusMonths(12);
             /*
			Date date1 = sdf.parse("2009-12-31");
			Date date2 = sdf.parse("2010-01-31");

			System.out.println("date1 : " + sdf.format(date1));
			System.out.println("date2 : " + sdf.format(date2));

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(date1);
			cal2.setTime(date2);

			if (cal1.after(cal2)) {
				System.out.println("Date1 is after Date2");
			}

			if (cal1.before(cal2)) {
				System.out.println("Date1 is before Date2");
			}

			if (cal1.equals(cal2)) {
				System.out.println("Date1 is equal Date2");
			}*/
		}

	}

}
