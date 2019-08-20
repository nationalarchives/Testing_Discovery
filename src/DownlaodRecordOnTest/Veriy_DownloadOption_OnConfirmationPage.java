package DownlaodRecordOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class Veriy_DownloadOption_OnConfirmationPage extends Wrapper_methods {

	@Test
	public void verify_Download_OnConfirmationPage() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C198022?readertype=staffin", "chrome");

		clickbyLinkText("Sign in");

		enterTextById("UserName", "discovery@nationalarchives.gov.uk");
		enterTextById("Password", "DiscoveryTest1");

		clickbyXpath("//input[@value='Sign in']");

		String actual_message = getTextByXpath("(//h2[@class='inline'])[1]");
		System.out.println(actual_message);

		Assert.assertEquals("Download this record", actual_message);

		clickbyLinkText("Download now");
		Thread.sleep(3000);

		quitBrowser();

	}

}
