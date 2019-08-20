package DetailPageOnTest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DetailPage_ShowImages_Offsite extends Wrapper_methods {

	@Test

	public void DetailPage_ShowImages() throws IOException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/D32670", "chrome");

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		// clickbyLinkText("Preview a low-resolution image of this record.");

		clickbyLinkText("Preview an image of this record.");

		// Point img
		// =driver.findElementByXPath("//img[@id='subjectImage']").getLocation();

		String Text = driver.findElementByXPath("//div[@id='imageviewerOverlay']").getText();

		String Text1 = driver.findElementByXPath("/html/head/meta[24]").getAttribute("innerHTML");

		System.out.println(Text1);
		System.out.println(Text);

		Assert.assertEquals(Text, "To download this record without a watermark, please add it to your basket.");

		clickbyLinkText("Hide images");
		quitBrowser();

	}

}
