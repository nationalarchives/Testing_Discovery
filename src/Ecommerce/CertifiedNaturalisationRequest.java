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

		// sign in
		driver.findElementById("UserName").sendKeys("tnadiscovery100@gmail.com");

		Thread.sleep(3000);

		// Enter password

		driver.findElementById("Password").sendKeys("Discovery1234");

		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();
		Thread.sleep(6000);

		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(6000);

        /* // click on add delivery address

		clickbyXpath("//*[@id=\"basketItemsWrapper\"]/div/div[3]/div[1]/div/div/p/a");

		// enter first name
		driver.findElementByXPath("//*[@id=\"FirstName\"]").sendKeys("Tester");
		// enter Last name
		driver.findElementByXPath("//*[@id=\"Surname\"]").sendKeys("Surname Tester");
		//enter house numer
		driver.findElementByXPath("//*[@id=\"HouseNameNo\"]").sendKeys("70 Blenheim");
		// enter street
		driver.findElementByXPath("//*[@id=\"Street\"]").sendKeys("LychField road");
		// enter town/city
		driver.findElementByXPath("//*[@id=\"Town\"]").sendKeys("london");
		// enter postcode
		driver.findElementByXPath("//*[@id=\"PostCode\"]").sendKeys("tw9 4ad");
		// click on save
		//driver.findElementByXPath("//input[@value='Save']");
		clickbyXpath("//input[@value='Save']");*/
		// click to proceed
		clickbyXpath("//input[@value='Proceed']");

		// accept the terms and conditions

		   clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");

		Thread.sleep(6000);

		// click the submit order

		clickbyXpath("(//input[@type='submit'])[3]");

		Thread.sleep(6000);

		// click the paypal payment

		clickbyXpath("(//input[@type='image'])[1]");

		Thread.sleep(6000);

		// click continue for payment

		clickbyID("PMMakePayment");

		Thread.sleep(3000);

		getTextByXpath("//div[@class='heading-holding-banner']");

		Thread.sleep(3000);

		driver.close();

	}

}
