package Ecommerce;

import java.io.IOException;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class PageCheckRequestACopy extends Wrapper_methods {

	@Test
	public void PageCheckRequestACopy() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C6553048#?readertype=offsite", "chrome");


		// click request copy
		clickbyXpath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]");

		Thread.sleep(1000);

//		 driver.executeAsyncScript("(scroll(0,600))");
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// click get started

		clickbyXpath("//a[contains(text(),'Get started')]");


		// clickbyLinkText("Get started");
		//clickByClassName("discoveryPrimaryCallToActionLink");

//		driver.findElementByXPath("//a[contains(text(),'Get started')]").click();
//
//		// clickbyXpath("//*[@class='discoveryPrimaryCallToActionLink']");

		Thread.sleep(1000);


		// click the check box on certified copy
		clickbyXpath("(//input[@name='CertifiedCopy'])[1]");

		// clickbyXpath("(//input[@name='CertifiedCopy'])[1]");

		// Enter the details of the copy

		driver.findElementByXPath("//*[@id='CustomerInstructions']").sendKeys("Research");

		// enterTextById("//textarea[@id='CustomerInstructions']", "Research");

		// click add to basket

		clickbyXpath("//input[@class='text_sketch']");

		Thread.sleep(3000);
		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(3000);
		// Create the account or sign in
		// Enter email

		driver.findElementById("UserName").sendKeys("discovery@nationalarchives.gov.uk");

		Thread.sleep(3000);

		// Enter password

		driver.findElementById("Password").sendKeys("DiscoveryTest1");

		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();

		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(3000);

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

		driver.close();
		// clickbyXpath("//div[@class='ar9 T-I-J3 J-J5-Ji']");

		/*
		 * System.out.println(driver.findElementByXPath(
		 * "(//span[@name='The National Archives'])[1]").getText());
		 * 
		 * 
		 * driver.
		 * findElementByXPath("(//span[@name='The National Archives'])[1]"
		 * ).click();
		 */

	}

}
