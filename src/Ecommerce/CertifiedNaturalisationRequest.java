package Ecommerce;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class CertifiedNaturalisationRequest extends Wrapper_methods {

	@Test
	public void CertifiedNaturalisationRequest() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C16120922?readertype=offsite", "chrome");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		// click request copy
		// clickbyXpath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]");

		clickbyLinkText("Request a copy");
		Thread.sleep(3000);
		// click Yes, I would like a certified copy

		clickbyXpath("//a[@class='discoveryPrimaryCallToActionLink']");

		// click add to basket

		clickbyXpath("//input[@class='text_sketch']");

		Thread.sleep(3000);
		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		driver.findElementById("UserName").sendKeys("yepuribindu@gmail.com");

		Thread.sleep(3000);

		// Enter password

		driver.findElementById("Password").sendKeys("Bindu123");

		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();

		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(3000);

         /*
		  //add the delivery address

		  clickbyXpath("//a[@class='discoveryPrimaryCallToActionLink']");


		  //Enter the title

		  driver.findElementByXPath("//input[@id='Title']").sendKeys("Mrs");

		  driver.findElementById("FirstName").sendKeys("shanthi");

		  driver.findElementById("Surname").sendKeys("venkatesh");

		  selectByValue_UsingId("Country", "United Kingdom");

		  driver.findElementById("HouseNameNo").sendKeys("63");

		  driver.findElementById("Street").sendKeys("Lloydcourt");

		  driver.findElementById("Town").sendKeys("London");

		  driver.findElementById("PostCode").sendKeys("Ha51eg");

		  Thread.sleep(3000); //clcik to save

		  clickbyXpath("//input[@class='call-to-action-link']");

		  //again sign in driver.findElementById("UserName").sendKeys("discovery@nationalarchives.gov.uk" );

		  Thread.sleep(3000);

		  //Enter password

		  driver.findElementById("Password").sendKeys("DiscoveryTest1");

		  //click sign in

		  driver.findElementByClassName("singleColumnSubmit").click(); */

		// click to proceed

		   clickbyXpath("//input[@value='Proceed']");

		// accept the terms and conditions

		   clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");

		Thread.sleep(3000);

		// click the submit order

		clickbyXpath("(//input[@type='submit'])[3]");

		Thread.sleep(3000);

		// click the paypal payment

		clickbyXpath("(//input[@type='image'])[1]");

		Thread.sleep(3000);

		// click continue for payment

		clickbyID("PMMakePayment");

		Thread.sleep(3000);

		getTextByXpath("//div[@class='heading-holding-banner']");

		Thread.sleep(3000);

		driver.close();

	}

}
