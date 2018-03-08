package discovery.DownlaodRecordOnLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Veriy_DownloadOption_InAccount extends Wrapper_methods{
	
	@Test
	
	public void verify_Download_InAccount() throws IOException, InterruptedException{
		
		launchDriver("http://discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=offsite", "chrome");
		
		clickbyLinkText("Sign in");
		
		enterTextById("UserName", "shanvivenkatesh@gmail.com");
		enterTextById("Password", "Shanvi2016");
		
		clickbyXpath("//input[@value='Sign in']");
		
		clickbyLinkText("Add to basket");
		clickbyLinkText("Continue to basket");
		clickbyXpath("//input[@value='Checkout']");
		clickbyID("confirm-terms");
		clickbyXpath("//input[@value='Submit order']");
		
		clickbyLinkText("PayPal");
		
		clickbyID("PMMakePayment");
		
		clickbyID("signInLink");
		
		clickbyLinkText("Your orders");
		
		String acutal_order=getTextByXpath("(//li[@class='orderItem'])[1]/h3[2]");
		System.out.println(acutal_order);
		
		Assert.assertEquals("3 Cavalry Field Ambulance", acutal_order);
		
		clickbyLinkText("Download now");
		
		String Verify_downlad =getTextByXpath("(//a[@class='download-part discoveryPrimaryCallToActionLink'])[1]");
		
		System.out.println(Verify_downlad);
		
		Assert.assertEquals("Download",Verify_downlad);
		
		clickbyLinkText("Download");
		
		Thread.sleep(3000);
		
		quitBrowser();
		
		
	}

}
