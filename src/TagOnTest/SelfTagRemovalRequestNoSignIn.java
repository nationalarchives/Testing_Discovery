package TagOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class SelfTagRemovalRequestNoSignIn extends Wrapper_methods {

	@Test

	public void removalRequest() throws InterruptedException

	{

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=staffin", "chrome");
		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
		// click flag

		driver.findElementByClassName("flagTagLink").click();
		// Enter removal message
		driver.findElementById("Reason").sendKeys("This tag is inappropriate");

		// Your details
		// Enter name
		// ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		driver.findElementByXPath("(//input[@id='userName'])[2]").sendKeys("Shanthi");
		// Enter email id

		driver.findElementByXPath("(//input[@id='userEmail'])[2]")
				.sendKeys("shanthi.venkatesh@nationalarichives.gsi.gov.uk");

		// ((JavascriptExecutor) driver).executeScript("scroll(0,1000");

		// Click submit button

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@value='Submit'])[2]").click();

		// get message

		String actual = driver.findElementByXPath("//div[@id='reportTagCompletionMessage']/p[1]").getText();

		System.out.println(actual);

		// Assert.assertEquals("Thank you for submitting your request to remove
		// this tag. This will be reviewed by our internal team and update you
		// shortly.", actual);

		Assert.assertEquals(
				"Thank you for submitting a tag removal request. If you left contact details, a member of our team will be in touch soon.",
				actual);

		driver.close();

	}

}
