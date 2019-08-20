package DetailPageOnTest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DetailPage_ShowImages_staff extends Wrapper_methods {

	@Test

	public void DetailPage_ShowImages() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/D32670?readertype=staff", "chrome");

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		clickbyLinkText("Preview an image of this record.");

		// Point img
		// =driver.findElementByXPath("//img[@id='subjectImage']").getLocation();

		String Text = driver.findElementByXPath("//div[@id='imageviewerOverlay']").getText();

		Thread.sleep(6000);

		String Text1 = driver.findElementByXPath("/html/head/meta[24]").getAttribute("innerHTML");


		System.out.println(Text1);
		System.out.println(Text);



		//String Text2 = driver.findElementByXPath("//*[@id='imageLoadError']/text()").getText();
		//Assert.assertEquals(Text,
			//	"The requested image either could not be found or your network is not currently connected to the internet. Please refresh the page to try again.");

		clickbyLinkText("Hide images");
		// quitBrowser();

	}

}
