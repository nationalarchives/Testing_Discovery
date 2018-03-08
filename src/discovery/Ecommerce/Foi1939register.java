package discovery.Ecommerce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Foi1939register extends Wrapper {
	@Test
	public void Foi1939register() throws IOException, InterruptedException,	AWTException {

		Robot robot = new Robot();

		launchDriver("http://test.discovery.nationalarchives.gov.uk/paidsearch/foi1939register?readertype=offsite",
				"chrome");

		// enter name
		enterTextById("firstnames", "Tester");

		// enter lastname
		enterTextById("search_lastname", "SurTester");

		// enter gender
		Thread.sleep(5000);
		selectByValue_UsingId("search_gender", "Female");

		// enter dob

		enterTextById("search_dob", "01/01/1900");

		
		// enter address within the register
		// enter house no

		enterTextById("search_house", "50");

		// enter street name

		enterTextById("search_street", "lloyd");

		// enter town

		enterTextById("search_town", "London");

		// enter country

		selectByValue_UsingId("search_county", "London");

	   // Upload evidence of death

		Thread.sleep(5000);

		// WebElement
		// element=driver.findElementByXPath("//input[@name='deathCertFile']");

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");

		Thread.sleep(5000);

		driver.findElementByXPath("//input[@name='deathCertFile']").click();
	
		//File Upload
		
   /* robot.setAutoDelay(3000);
        
        StringSelection stringSelection = new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
        
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        
        robot.setAutoDelay(3000);
        
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.setAutoDelay(3000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        
        robot.setAutoDelay(3000);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
        
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("Z:\\Svenkatesh\\Result\\BatchExecution\\Fileupload.exe");
		//Runtime.getRuntime().exec("./Fileupload.exe");

		// your contact details

		enterTextById("firstname", "shanthi");
		enterTextById("lastname", "venkatesh");
		enterTextById("email", "shavivenkatesh@gmail.com");
		enterTextById("confirmemail", "shavivenkatesh@gmail.com");
		enterTextById("address1", "63lloyd");
		enterTextById("town", "London");
		enterTextById("postcode", "Ha51eg");

		Thread.sleep(3000);
		selectByValue_UsingId("country", "United Kingdom");
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		// Add to basket
		clickbyXpath("//input[@class='discoveryPrimaryCallToActionLink']");

		Thread.sleep(3000);

		// click checkout
		clickbyXpath("//input[@class='call-to-action-link']");

		// enter email id

		enterByTextXpath("//input[@id='DeliveryEmail']",
				"shanvivenkatesh@gmail.com");

		// accept the terms and conditons

		clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");

		// click submitorder

		clickbyXpath("(//input[@type='submit'])[3]");

		Thread.sleep(3000);

		// click paypal
		clickbyXpath("(//input[@type='image'])[1]");

		Thread.sleep(3000);

		// click continue

		clickbyID("PMMakePayment");

		Thread.sleep(3000);

		driver.close();

	}

}
