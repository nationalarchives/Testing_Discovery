package discovery.Ecommerce;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageCheckRequestACopy extends Wrapper {

	@Test
	public void PageCheckRequestACopy() throws IOException,
			InterruptedException {

		launchDriver(
				"http://test.discovery.nationalarchives.gov.uk/details/r/C6553048#?readertype=offsite",
				"chrome");

		Thread.sleep(3000);

		// click request copy
		clickbyXpath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]");

		Thread.sleep(3000);

		// click get started

		clickByClassName("discoveryPrimaryCallToActionLink");

		Thread.sleep(3000);

		// click the check box on certified copy

		// clickbyXpath("(//input[@name='CertifiedCopy'])[1]");

		Thread.sleep(3000);

		// Enter the details of the copy

		driver.findElementByXPath("//*[@id='CustomerInstructions']").sendKeys(
				"Research");

		// enterTextById("//textarea[@id='CustomerInstructions']", "Research");

		Thread.sleep(3000);

		// click add to basket

		clickbyXpath("//input[@class='text_sketch']");

		Thread.sleep(3000);
		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(3000);
		// Create the account or sign in
		// Enter email

		driver.findElementById("UserName")
				.sendKeys("shanvivenkatesh@gmail.com");

		Thread.sleep(3000);

		// Enter password

		driver.findElementById("Password").sendKeys("Shanvi2016");

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
		 * driver.findElementByXPath("(//span[@name='The National Archives'])[1]"
		 * ).click();
		 */

	}

}
