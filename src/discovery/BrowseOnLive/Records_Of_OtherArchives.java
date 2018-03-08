package discovery.BrowseOnLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Records_Of_OtherArchives extends Wrapper_methods{
	
	@Test
	public void otherArchives() throws IOException, InterruptedException{
		
		launchDriver("http://discovery.nationalarchives.gov.uk/", "chrome");
		
		clickbyLinkText("browse");
		
		clickbyXpath("(//ul[@class='a-z'])[2]/li[26]");
		
		//get the reference
		
        String refference_item = getTextByXpath("//ul[@class='siblings-list']/li/div/span[1]");
		
		System.out.println(refference_item);
		
		//Click the detail page
		
        clickbyXpath("//ul[@class='siblings-list']/li[1]/div[2]/a");
		
		String archon_code= getTextByXpath("//div[@class='breather'][1]/p[2]");
		
		System.out.println(archon_code);
		
		Assert.assertTrue(archon_code.contains(refference_item));
		
		quitBrowser();
		
				
		
		
	}

}
