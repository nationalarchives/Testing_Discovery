package TagOnTest;

import wrappers.Wrapper_methods;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StopListTag extends Wrapper_methods {

	@Test

	public void tag() throws InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=staffin", "chrome");
		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
		// click the sigin in
		Thread.sleep(3000);

		driver.findElementByXPath("(//a[@href='/sign-in'])[3]").click();

		driver.findElementById("UserName").sendKeys("discovery@nationalarchives.gov.uk");

		driver.findElementById("Password").sendKeys("DiscoveryTest1");
		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		// enter tag
		driver.findElementById("tagEntryText").sendKeys("abuse");

		// click add tag
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Add tag']").click();
		Thread.sleep(3000);
		String actual = driver.findElementById("tag-add-failure-message").getText();
		System.out.println(actual);

		// Verify the message

		Assert.assertEquals(
				"An error occurred when processing your request to add this tag. This may be because it does not comply with tagging guidelines (see link above).",
				actual);

		driver.quit();
	}
}
