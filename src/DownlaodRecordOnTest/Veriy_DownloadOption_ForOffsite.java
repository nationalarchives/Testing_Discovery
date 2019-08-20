package DownlaodRecordOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class Veriy_DownloadOption_ForOffsite extends Wrapper_methods {

	@Test
	public void verify_Download_ForOffsite() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=offsite", "chrome");

		// launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C4107320?readertype=offsite",
		// "chrome");

		clickbyLinkText("Sign in");

		enterTextById("UserName", "discovery@nationalarchives.gov.uk");
		enterTextById("Password", "DiscoveryTest1");

		clickbyXpath("//input[@value='Sign in']");

		clickbyLinkText("Add to basket");
		clickbyLinkText("Continue to basket");
		clickbyXpath("//input[@value='Checkout']");
		clickbyID("confirm-terms");
		clickbyXpath("//input[@value='Submit order']");

		clickbyLinkText("PayPal");

		clickbyID("PMMakePayment");

		String Thankyou_Order = getTextByXpath("//div[@class='heading-holding-banner']/h1/span");

		System.out.println(Thankyou_Order);

		Assert.assertEquals("Thank you for your order", Thankyou_Order);

		clickbyLinkText("Download now");

		Thread.sleep(3000);
		String Verify_downlad = getTextByXpath("(//a[@class='download-part discoveryPrimaryCallToActionLink'])[1]");

		System.out.println(Verify_downlad);

		Assert.assertEquals("Download", Verify_downlad);

		clickbyLinkText("Download");

		Thread.sleep(3000);

		quitBrowser();

	}

}
