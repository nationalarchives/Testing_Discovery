package discovery.DetailPageOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class DetailPage_ErrorOnRecordDescription extends Wrapper_methods {
	
	
	@Test
	
	public void DetailPage_ErrorOnRecordDescription() throws IOException{
		
		launchDriver("http://discovery.nationalarchives.gov.uk/details/r/D32670", "chrome");
		
		//click the let us know link
		
		clickbyLinkText("let us know");
		//select from drop down
		
		Select containsError = new Select (driver.findElementById("fieldContainingError"));
	
		containsError.selectByIndex(2);
		
		// what is the error 
		
		enterTextById("whatIsTheError", "Test check");
		
		//enter whatIsTheRecommendation
		
		enterTextById("whatIsTheRecommendation", "Test check correct");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		
		//your details
		
		enterTextById("userName", "Tester");
		
		enterTextById("userEmail", "Testmailcheck1233@gmail.com");
		//clcik submit
		
		clickbyXpath("(//input[@class='discoverySecondaryCallToActionLink'])[2]");
		
		//verify the message
		
		String verify_Message= getTextByXpath("//p[@class='emphasis-block']");
		
		System.out.println(verify_Message);
		
		Assert.assertEquals("Thank you for taking the time to submit a suggestion. "
				+ "We may contact you within the next 10 days if we need further information. We will not be able to notify you if "
				+ "your suggestions is successful due to the high volume of suggestions we receive. The National Archives appreciates "
				+ "all suggestions as each one can help us improve Discovery for everyone.", verify_Message);
		
		quitBrowser();
		
		
		
		
		
		
	}
	
	

}
