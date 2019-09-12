package SingleSignOnTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

/*Open the test environment

 create account

 Delete account
 */

public class SS_NoAcceptTerm extends Wrapper_methods {
	@Test(priority = 1)
	public void NoAcceptTerm() throws IOException, InterruptedException {
		// Open the test environment
		launchDriver("https://test.secure.nationalarchives.gov.uk/Login/register", "chrome");
		Thread.sleep(3000);

		// Create account

		enterTextById("Name", "Test");

		enterTextById("Email", "tnadiscovery100@gmail.com");

		enterTextById("ConfirmEmail", "tnadiscovery100@gmail.com");

		enterTextById("Password", "Discovery1234");

		enterTextById("ConfirmPassword", "Discovery1234");

		// clickbyID("acceptTCs");

		clickbyXpath("//input[@value='Register']");

		String Account_Creation = getTextByXpath("//div[@class='validation-summary-errors']/span");

		System.out.println(Account_Creation);

		String terms_condition = getTextByXpath("(//span[@class='field-validation-error'])[1]");

		System.out.println(terms_condition);

		Assert.assertEquals("Account creation was unsuccessful. Please correct the errors and try again.",
				Account_Creation);
		Assert.assertEquals("You must accept the terms and conditions.", terms_condition);

		quitBrowser();

	}

}
