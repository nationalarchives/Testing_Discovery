package cabinetPapersSearch;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class CabinetPapers_Date_descriptionOnly extends Wrapper_methods{
	
	@Test
	public void cabinetSearch() throws IOException{
		
	
		launchDriver("http://test.nationalarchives.gov.uk/cabinetpapers/", "chrome");
		
		// start search
	
		clickbyXpath("//a[@class='btn']");
		//enter word
		enterTextById("all-words", "*");
		//select filter by document type
		clickbyXpath("//input[@id='conclusions']");
		
		//enter the from date
		enterTextById("from-date", "1915");
		
		//enter to date
		 enterTextById("to-date", "1980");
		
		
		//select search Within entire document
		clickbyXpath("//input[@id='decsription']");
		//click search
		clickbyXpath("(//input[@value='Search'])[1]");
		
		// filters
				String yourFliters = driver.findElementById("search-refine").getText();

				System.out.println(yourFliters);
				
				Assert.assertTrue(yourFliters.contains("1915 - 1980"));
				Assert.assertTrue(yourFliters.contains("CAB 23"));
				Assert.assertTrue(yourFliters.contains("CAB 65"));
				Assert.assertTrue(yourFliters.contains("CAB 128"));
				
				String actual = driver.findElementByLinkText("Return to Cabinet Papers website").getText();
				
				System.out.println(actual);
				
				Assert.assertEquals(actual, "Return to Cabinet Papers website");
				
				clickbyLinkText("Return to Cabinet Papers website");
				// driver.get();
				String actual_title = driver.getTitle();
				
				System.out.println("The title is "+actual_title);
		
				quitBrowser();
	}

}
