package discovery.DownlaodRecordOnLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Veriy_DownloadOption_OnConfirmationPage extends Wrapper_methods {

	@Test
	public void verify_Download_OnConfirmationPage() throws IOException, InterruptedException {

		launchDriver(
				"http://discovery.nationalarchives.gov.uk/details/r/C198022?readertype=staffin",
				"chrome");

		clickbyLinkText("Sign in");

		enterTextById("UserName", "shanvivenkatesh@gmail.com");
		enterTextById("Password", "Shanvi2016");

		clickbyXpath("//input[@value='Sign in']");
		

		
		String actual_message=getTextByXpath("(//h2[@class='inline'])[1]");
		System.out.println(actual_message);
		
		Assert.assertEquals("Download this record",actual_message);
		
		clickbyLinkText("Download now");
		Thread.sleep(3000);

		quitBrowser();

	}

}
