package endToEndPageRequest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class PlaceOrder extends Wrapper_methods {

	@Test
	public void PlacOrder() throws InterruptedException, IOException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C6553048#?readertype=offsite","Chrome");

		Thread.sleep(3000);

		clickbyLinkText("Sign in");
		// Create the account or sign in
		// Enter email

		driver.findElementById("UserName").sendKeys("shanvivenkatesh@gmail.com");

		Thread.sleep(3000);

		// Enter password

		driver.findElementById("Password").sendKeys("Shanvi2016");

		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();
		
		Thread.sleep(3000);
		
		clickbyID("signInLink");
		Thread.sleep(3000);
		clickbyLinkText("Your orders");
		
		clickbyLinkText("Place your copy order");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		
		clickbyXpath("//input[@value='Add to basket']");
		
		clickbyXpath("//input[@value='Checkout']");
		
		clickbyID("collect");
		
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

	}

}
