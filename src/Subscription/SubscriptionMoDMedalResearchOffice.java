package Subscription;

import java.io.IOException;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class SubscriptionMoDMedalResearchOffice extends Wrapper_methods {

	@Test

	public void SubscriptionMoDMedalResearchOffice() throws IOException, InterruptedException {

		launchDriver("https://test.secure.nationalarchives.gov.uk/Login/register", "chrome");

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		driver.findElementByXPath("//*[@id=\"Email\"]").click();

		driver.findElementByXPath("//*[@id=\"Email\"]").sendKeys("yepuribindu@gmail.com");

		Thread.sleep(5000);

		driver.findElementByXPath("//*[@id=\"ConfirmEmail\"]").click();

		driver.findElementByXPath("//*[@id=\"ConfirmEmail\"]").sendKeys("yepuribindu@gmail.com");

		Thread.sleep(5000);

		driver.findElementByXPath("//*[@id=\"Password\"]").click();

		driver.findElementByXPath("//*[@id=\"Password\"]").sendKeys("Bindu12345");

		driver.findElementByXPath("//*[@id=\"ConfirmPassword\"]").click();

		driver.findElementByXPath("//*[@id=\"ConfirmPassword\"]").sendKeys("Bindu12345");

		driver.findElementByXPath("//*[@id=\"ReaderTicket\"]").sendKeys("110110");

		//driver.findElementByXPath("//input[@value='Validate barcode']").click();

		Thread.sleep(3000);

		driver.findElementByXPath("//*[@id=\"acceptTCs\"]").click();

		driver.findElementByXPath("//*[@id=\"regForm\"]/fieldset/div[1]/div[2]/div[5]/input[1]").click();



		// driver.findElementByClassName("button").click();

//		Thread.sleep(3000);


//		driver.findElementById("ticket").sendKeys("110110");
		//driver.findElementByXPath("//*[@id=\"ReaderTicket\"]").sendKeys("110110");

		Thread.sleep(3000);

        //driver.findElementByXPath("//input[@value='Validate barcode']").click();

		String title = driver.findElementByXPath("//*[@id='account-controls']/ul/li[1]").getText();

		driver.findElementByXPath("//*[@id=\"page_wrap\"]/div/div/div[2]/fieldset[2]/ul/li[2]/span/a").click();

		driver.findElementByXPath("//*[@id=\"page_wrap\"]/div/div/div[2]/fieldset/div/form/input").click();



		/*System.out.println(title);

		Assert.assertEquals("Subscription (MoD Medal Research Office)", title);

		Thread.sleep(3000);
		driver.get("http://discovery.nationalarchives.gov.uk/details/r/D431198");
		Thread.sleep(5000);
		System.out.println(driver.findElementByClassName("discoveryPrimaryCallToActionLink").getText());

		String subcriptioncheck = driver.findElementByClassName("order-option-wrapper").getAttribute("innerHTML");

		System.out.println(subcriptioncheck);

		Assert.assertTrue(subcriptioncheck.contains("Subscription"));

		Assert.assertTrue(subcriptioncheck.contains("DigitizedDiscovery"));*/


		driver.quit();

	}

}
