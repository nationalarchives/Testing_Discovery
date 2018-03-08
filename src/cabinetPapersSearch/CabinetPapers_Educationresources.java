package cabinetPapersSearch;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class CabinetPapers_Educationresources extends Wrapper_methods{
	
	@Test
	public void cabinetSearch() throws IOException{
		
	
		launchDriver("http://test.nationalarchives.gov.uk/cabinetpapers/", "chrome");
		
		// start search
	
		clickbyXpath("//a[@class='btn']");
		//click education resources
		
		clickbyLinkText("Education resources");
		
		//search by word or phrase
		
		enterTextById("search-all-collections", "CAB 65");
		
		//click search
		clickbyXpath("(//input[@value='Search'])[2]");
		
		
				
				String actual = driver.findElementByLinkText("Return to Cabinet Papers website").getText();
				
				System.out.println(actual);
				
				Assert.assertEquals(actual, "Return to Cabinet Papers website");
				
				clickbyLinkText("Return to Cabinet Papers website");
				
				String actual_title = driver.getTitle();
				
				System.out.println("The title is "+actual_title);
		
				quitBrowser();
	}

}
