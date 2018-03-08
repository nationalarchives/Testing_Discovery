package discovery.BrowseOnTest;

import java.io.IOException;
import java.util.List;



import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Records_Of_TNA extends Wrapper_methods {
	
	@Test
	public void browseRecords() throws IOException, InterruptedException{
		
		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");
		
		clickbyLinkText("browse");
		
		Thread.sleep(3000);
		
		clickbyXpath("(//ul[@class='a-z'])[1]/li[17]");
		
		//getthe reference
		
		String refference_item = getTextByXpath("//ul[@class='siblings-list']/li/div/span[1]");
		
		System.out.println(refference_item);
		
		Assert.assertTrue(refference_item.contains("Q"));
		
		//click the detail page
		
		clickbyXpath("//ul[@class='siblings-list']/li[1]/div[2]/a");
		
		String detailPage_refference= getTextByXpath("//table[@class='asset-details']/tbody/tr[1]/td");
		
		System.out.println(refference_item);
		
		Assert.assertEquals(refference_item, refference_item);
		
		quitBrowser();
	
	}
	
	
}
