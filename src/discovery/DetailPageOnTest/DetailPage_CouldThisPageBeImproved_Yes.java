package discovery.DetailPageOnTest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class DetailPage_CouldThisPageBeImproved_Yes extends Wrapper_methods {
	
	
	@Test
	
	public void DetailPage_CouldThisPageBeImproved_Yes() throws IOException{
		
		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/D32670", "chrome");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
		//click no option on could this page be improved?
		
		clickbyID("room-for-improvement-yes");
		
	//	System.out.println(getTextById("room-for-improvement-no"));
			
		clickbyXpath("//input[@value='Send']");
		
		String verify_Message= getTextByXpath("//div[@id='discovery-explore-survey']/p");
		
		System.out.println(verify_Message);
		
		Assert.assertEquals(verify_Message,"Thank you for your feedback.");
				
		quitBrowser();
		
		
		
		
		
		
	}
	
	

}
