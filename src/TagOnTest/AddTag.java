package TagOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AddTag extends Wrapper_methods {

	@Test

	public void tag() throws InterruptedException, Exception {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=staffin", "chrome");

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");

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

		driver.findElementById("tagEntryText").sendKeys("Testingforsomethinggggg");

		// click add tag

		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='Add tag']").click();
		Thread.sleep(3000);
		String actual = driver.findElementByXPath("//div[@class='emphasis-block']").getText();
		System.out.println(actual);

		// Verify the message

		Assert.assertEquals("Your tag has been added. Thank you.", actual);
        /*

		// Delete tag

		driver.findElementByXPath("(//a[@class='tagName deleteTag users-tag-list-item'])[1]").click();
		Thread.sleep(3000);
		driver.switchTo().alert();
		Thread.sleep(3000);


		driver.switchTo().alert().accept();
		// get deletion message
		actual = driver.findElementById("tag-delete-success-message").getText();
		System.out.println(actual);

        */
		// click sign out

		driver.findElementByXPath("(//a[@href='/sign-out'])").click();

		driver.close();

	}

}