package discovery.SingleSignOnLive;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

/*Open the test environment

 create account

 Delete account
 */

public class SS_clickRegisterwithInvalidPassword extends
		Wrapper_methods {
	@Test(priority = 1)
	public void clickRegisterwithInvalidPassword() throws IOException,
			InterruptedException {
		// Open the test environment
		launchDriver(
				"https://secure.nationalarchives.gov.uk/Login/register",
				"chrome");
		Thread.sleep(3000);
		// Create account

		enterTextById("Name", "Test");

		enterTextById("Email", "testmailcheck1233@gmail.com");

		enterTextById("ConfirmEmail", "testmailcheck1233@gmail.com");

		enterTextById("Password", "Testcheck123");
		// Enter the invlaid password
		enterTextById("ConfirmPassword", "Testcheck1233333");

		clickbyID("acceptTCs");

		// clickByClassName("submit discoveryPrimaryCallToActionLink");

		clickbyXpath("//input[@value='Register']");
		// Verify the error message

		String Account_Creation = getTextByXpath("//div[@class='validation-summary-errors']/span");

		System.out.println(Account_Creation);

		String Password_confirPassword = getTextByXpath("(//span[@class='field-validation-error'])[1]");

		System.out.println(Password_confirPassword);
		
		Assert.assertEquals("Account creation was unsuccessful. Please correct the errors and try again.", Account_Creation);
		Assert.assertEquals("The password and confirmation password do not match.", Password_confirPassword);


		quitBrowser();

	}
}
