package Ecommerce;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class WO416 extends Wrapper_methods {

	@Test
	public void WO416() throws IOException, InterruptedException, AWTException {

		// Robot robot = new Robot();

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C14568023?readertype=offsite", "chrome");

		// launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C14567850?readertype=offsite","chrome");

		clickbyLinkText("Request a search of closed records");

		Thread.sleep(5000);
		// driver.findElementById("search_firstnames").clear();
		driver.findElementById("search_firstnames").sendKeys("Shanthi");
		driver.findElementById("search_lastname").clear();
		driver.findElementById("search_lastname").sendKeys("venkatesh");
		driver.findElementById("search_dob").clear();
		driver.findElementById("search_dob").sendKeys("05/07/1986");

		selectbyvisibletext_Byname("Search_Category", "Royal Air Force");

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("scroll(0,2900)");
		Thread.sleep(3000);
		clickbyXpath("//input[@type='file']");

		// File uplaod

		/*
		 * robot.setAutoDelay(1000);
		 *
		 * StringSelection stringSelection = new
		 * StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"
		 * );
		 *
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
		 * stringSelection,null);
		 *
		 * robot.setAutoDelay(1000);
		 *
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 *
		 * robot.keyRelease(KeyEvent.VK_CONTROL);
		 * robot.keyRelease(KeyEvent.VK_V);
		 *
		 *
		 *
		 * robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		Thread.sleep(5000);

		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\KoalaUpload.exe");
		//Runtime.getRuntime().exec("This PC\\Documents\\KoalaUpload.exe");

		//Runtime.getRuntime().exec("Z:\\Svenkatesh\\Result\\BatchExecution\\Fileupload.exe");

		// enter your details
		Thread.sleep(5000);

		driver.findElementById("firstname").sendKeys("hima");

		driver.findElementById("lastname").sendKeys("parupalli");

		driver.findElementById("email").sendKeys("discovery@nationalarchives.gov.uk");

		driver.findElementById("address1").sendKeys("63 Lloydcourt");

		driver.findElementById("postcode").sendKeys("Ha51eg");

		driver.findElementByXPath("//input[@id='town']").sendKeys("London");

		selectbyvisibletext_Byname("Country", "Afghanistan");

		// clcik to add to basket

		driver.findElementByXPath("//input[@class='discoveryPrimaryCallToActionLink']").click();
		// clickbyClassName("discoveryPrimaryCallToActionLink");

		Thread.sleep(3000);

		// click checkout
		clickbyXpath("//input[@class='call-to-action-link']");

		// enter email id

		enterByTextXpath("//input[@id='DeliveryEmail']", "discovery@nationalarchives.gov.uk");

		// accept the terms and conditons

		clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");

		// click submitorder

		clickbyXpath("(//input[@type='submit'])[3]");

		Thread.sleep(5000);

		// click paypal
		clickbyXpath("(//input[@type='image'])[1]");

		Thread.sleep(3000);

		// click continue

		clickbyID("PMMakePayment");

		Thread.sleep(3000);

		driver.close();

	}
}
