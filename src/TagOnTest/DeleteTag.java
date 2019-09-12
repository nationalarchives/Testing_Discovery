
package TagOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

public class DeleteTag extends Wrapper_methods {

	@Test

	public void deleteTag() throws InterruptedException, Exception {

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

		// Delete tag

		driver.findElementByXPath("//*[@id=\"tag-list\"]/li[1]/div/span/span/a").click();
		Thread.sleep(3000);
		driver.switchTo().alert();
		Thread.sleep(3000);


		driver.switchTo().alert().accept();
		// get deletion message
		String actual = driver.findElementById("tag-delete-success-message").getText();
		System.out.println(actual);

		// verify the deletion message

		//Assert.assertEquals(actual, "Your tag deletion request was successful");

		Assert.assertEquals(actual, "Your tag has been deleted.");

		// click sign out

		driver.findElementByXPath("(//a[@href='/sign-out'])").click();

		driver.close();

	}

}
