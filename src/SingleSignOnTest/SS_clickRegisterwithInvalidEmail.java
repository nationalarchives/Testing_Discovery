package SingleSignOnTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

/*Open the test environment

 create account

 Delete account
 */

public class SS_clickRegisterwithInvalidEmail extends Wrapper_methods {
	@Test(priority = 1)
	public void clickRegisterwithInvalidEmail() throws IOException, InterruptedException {
		// Open the test environment
		launchDriver("https://test.secure.nationalarchives.gov.uk/Login/register", "chrome");
		Thread.sleep(3000);
		// Create account

		enterTextById("Name", "Test");

		enterTextById("Email", "tnadiscovery100@gmail.com");

		enterTextById("ConfirmEmail", "tnadiscovery100@gmaillllll.com");

		enterTextById("Password", "Discovery1234");
		// Enter the invlaid password
		enterTextById("ConfirmPassword", "Discovery1234");

		clickbyID("acceptTCs");

		// clickByClassName("submit discoveryPrimaryCallToActionLink");

		clickbyXpath("//input[@value='Register']");
		// Verify the error message

		String Account_Creation = getTextByXpath("//div[@class='validation-summary-errors']/span");

		System.out.println(Account_Creation);

		String Email_confirmEmail = getTextByXpath("(//span[@class='field-validation-error'])[1]");

		System.out.println(Email_confirmEmail);

		Assert.assertEquals("Account creation was unsuccessful. Please correct the errors and try again.",
				Account_Creation);
		Assert.assertEquals("The email address and confirmation email address do not match.", Email_confirmEmail);

		quitBrowser();

	}
}
