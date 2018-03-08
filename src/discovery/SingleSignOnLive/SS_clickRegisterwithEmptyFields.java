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

public class SS_clickRegisterwithEmptyFields extends Wrapper_methods {
	@Test(priority=1)
	public void clickRegisterwithEmptyFields() throws IOException, InterruptedException {
		// Open the test environment
		launchDriver(
				"https://secure.nationalarchives.gov.uk/Login/register","chrome");
		Thread.sleep(3000);
		
		

		// Click register without fill the info and verify the messages
		
		clickbyXpath("//input[@value='Register']");
		
		//Verify the error message
		
		String Account_Creation= getTextByXpath("//div[@class='validation-summary-errors']/span");
		
		System.out.println(Account_Creation);
		
		
		
		String email_Field=getTextByXpath("(//span[@class='field-validation-error'])[1]");
		
		System.out.println(email_Field);
		
		String confirmation_EamilField=getTextByXpath("(//span[@class='field-validation-error'])[2]");
		
		System.out.println(confirmation_EamilField);
		
		String password_field=getTextByXpath("(//span[@class='field-validation-error'])[3]");
		System.out.println(password_field);
		
		String confirmation_passwordfield=getTextByXpath("(//span[@class='field-validation-error'])[4]");
		System.out.println(confirmation_passwordfield);
		
		String terms_condition=getTextByXpath("(//span[@class='field-validation-error'])[5]");
		System.out.println(terms_condition);
		
		Assert.assertEquals("Account creation was unsuccessful. Please correct the errors and try again.", Account_Creation);
		Assert.assertEquals("The Email field is required.", email_Field);
		Assert.assertEquals("The ConfirmEmail field is required.", confirmation_EamilField);
		Assert.assertEquals("The Password field is required.", password_field);
		Assert.assertEquals("The ConfirmPassword field is required.", confirmation_passwordfield);
		Assert.assertEquals("You must accept the terms and conditions.", terms_condition);
		
		quitBrowser();
		
		
	}
}
