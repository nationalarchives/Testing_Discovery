package Ecommerce;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class Dsa1939registerClickYes extends Wrapper_methods {

	@Test

	public void Dsa1939registerClickYes() throws IOException, InterruptedException, AWTException {

		Robot robot = new Robot();

		launchDriver("http://test.discovery.nationalarchives.gov.uk/paidsearch/dsa1939register?readertype=offsite",
				"chrome");
		// First name
		enterTextById("firstnames", "Tester");
		// last name
		enterTextById("search_lastname", "LastTester");

		// gender
		selectByValue_UsingId("search_gender", "Female");

		// dob
		enterTextById("search_dob", "01/01/1900");

		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

		// are yout the data subjsect
		Thread.sleep(3000);
		clickbyID("isSubject");

		// upload proof of identity

		Thread.sleep(10000);

		clickbyXpath("(//input[@type='file'])[2]");

		/*
		 * robot.setAutoDelay(3000);
		 * 
		 * StringSelection stringSelection = new
		 * StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"
		 * );
		 * 
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
		 * stringSelection,null);
		 * 
		 * robot.setAutoDelay(3000);
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 * robot.setAutoDelay(3000); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * robot.keyRelease(KeyEvent.VK_V);
		 * 
		 * robot.setAutoDelay(3000);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */

		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\hparupalli\\KoalaUpload.exe");
		// Runtime.getRuntime().exec("./FileUpload2.exe");

		// your contact details

		enterTextById("firstname", "Tester");
		enterTextById("lastname", "SurTester");
		enterTextById("email", "TestMailcheck1233@gmail.com");
		enterTextById("confirmemail", "TestMailcheck1233@gmail.com");
		enterTextById("address1", "63Highstreet");
		enterTextById("town", "London");
		enterTextById("postcode", "tw96nu");
		// driver.executeScript("scroll(0,200)");
		((JavascriptExecutor) driver).executeScript("scroll(0,3500)");
		Thread.sleep(3000);
		selectByValue_UsingId("country", "United Kingdom");

		Thread.sleep(5000);
		// Declaration
		clickbyID("Confirm");

		// Add to basket
		clickbyXpath("//input[@class='discoveryPrimaryCallToActionLink']");

		String confirmationText = getTextByXpath("(//div[@class='container'])[3]");
		System.out.println(confirmationText);

		Assert.assertTrue(confirmationText.contains("Confirmation"));

		/*
		 * //click checkout
		 * clickbyXpath("//input[@class='call-to-action-link']");
		 * 
		 * //enter email id
		 * 
		 * enterByTextXpath("//input[@id='DeliveryEmail']",
		 * "discovery@nationalarchives.gov.uk");
		 * 
		 * //accept the terms and conditons
		 * 
		 * clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");
		 * 
		 * //click submitorder
		 * 
		 * clickbyXpath("(//input[@type='submit'])[3]");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * //click paypal clickbyXpath("(//input[@type='image'])[1]");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * //click continue
		 * 
		 * clickbyID("PMMakePayment");
		 * 
		 * Thread.sleep(3000);
		 * 
		 * driver.close();
		 * 
		 * 
		 * 
		 */

		driver.quit();

	}

}