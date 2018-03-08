package discovery.SingleSignOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class SS_CreateAccount_ChangeEmail_ChangePassword_DeleteAccount extends Wrapper_methods {

	@Test(priority = 1)
	public void CreateAccount_ChangeEmail_ChangePassword_DeleteAccount() throws IOException, InterruptedException {

		// Open the test environment
		launchDriver("https://test.secure.nationalarchives.gov.uk/Login/register",
				"chrome");
		Thread.sleep(3000);

		// Create account

		enterTextById("Name", "Test");

		enterTextById("Email", "Testfive@gmail.com");

		enterTextById("ConfirmEmail", "Testfive@gmail.com");

		enterTextById("Password", "Test1234");

		enterTextById("ConfirmPassword", "Test1234");

		clickbyID("acceptTCs");

		clickbyXpath("//input[@value='Register']");

		String actual = getTextByXpath("//div[@class='heading-holding-banner']");

		Assert.assertEquals("Welcome to your account", actual);

		Thread.sleep(3000);

		clickbyLinkText("Your personal details");

		// change Email

		driver.findElementById("Email").clear();

		enterTextById("Email", "testsix@gmail.com");

		// save changes
		clickbyXpath("//input[@value='Save details']");

		// sign in

		enterTextById("UserName", "testsix@gmail.com");

		enterTextById("Password", "Test1234");

		clickbyXpath("//input[@value='Sign in']");

		Thread.sleep(3000);

		String actual1 = getTextByXpath("//div[@class='heading-holding-banner']");

		Assert.assertEquals("Welcome to your account", actual1);
		
		
		//change password
		
Thread.sleep(3000);
		
		clickbyLinkText("Your personal details");
		
		//change password
		
		clickbyLinkText("Change your password");
		
		enterTextById("OldPassword", "Test1234");
		
		enterTextById("NewPassword", "Test12345");
		
		enterTextById("ConfirmPassword", "Test12345");
		
		clickbyXpath("//input[@name='SavePassword']");
		
		String actual_changePassword = getTextByXpath("//div[@class='updateSuccess']");
		
		Assert.assertEquals("Your password has been successfully updated", actual_changePassword);
		clickbyLinkText("Sign out");
		
		enterTextById("UserName", "testsix@gmail.com");
		Thread.sleep(3000);
		
		enterTextById("Password", "Test12345");
		Thread.sleep(3000);
		
		clickbyXpath("//input[@value='Sign in']");
		Thread.sleep(3000);

		// deleteyouraccount

		// clickbyLinkText("Your account");

		clickbyLinkText("Delete your account");
		Thread.sleep(3000);
		clickbyXpath("//input[@value='Confirm account deletion']");

		String actual_AccountDeletion = getTextByXpath("//div[@class='grid-within-grid-two-item']");

		Assert.assertTrue(actual_AccountDeletion
				.contains("Your account has been closed and your account data deleted."));

		quitBrowser();

	}

}
