package discovery.DetailPageOnLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Verify_DetailPage_OnSeriesLevel extends Wrapper_methods{
	
	@Test
	
	public void series_Serach() throws IOException{
		
		launchDriver(" http://discovery.nationalarchives.gov.uk/details/r/C12122", "chrome");
		
		//enter firstname
		 enterTextById("FirstName", "john");
		
		//enter lastname
		 
		 enterTextById("LastName", "taylor");
		//Enter Occupation
		 
		 enterTextById("Occupation", "carpenter");
		//Enter Place
		 enterTextById("Place", "london");
		//Enter Other Keywords
		 //enterTextById("OtherKeywords", idValue);
		//EnterDate range (yyyy):
		//Enter From
		 
		 enterTextById("fromDate", "1800");
		//Enter TO
		 enterTextById("endDate", "1860");
		//Serach
		 
		 clickbyXpath("(//input[@type='submit'])[3]");
		 
		 //verify fliter result
		 
		String your_Filter =getTextById("search-refine");
		
		System.out.println(your_Filter);
		
		//verify result
		
		Assert.assertTrue(your_Filter.contains("1800 - 1860"));
		Assert.assertTrue(your_Filter.contains("PROB 11"));
		Assert.assertTrue(your_Filter.contains("Available for download only"));
		
		
		 
		 //verify backtoPROB11 link
		
		String verifybacktoPROB11= driver.findElementByLinkText("Back to PROB 11").getText();
		
		System.out.println(verifybacktoPROB11);
		
		Assert.assertEquals(verifybacktoPROB11, "Back to PROB 11");
		
		quitBrowser();
		
		
	}

}
