package discovery.DetailPageOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Verify_DetailPage_OnSeriesLevel_SearchWithin extends Wrapper_methods{
	
	@Test
	
	public void series_Serach() throws IOException{
		
		launchDriver(" http://test.discovery.nationalarchives.gov.uk/details/r/C12122", "chrome");
		
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
		 
		 enterTextById("fromDate", "dfd");
		//Enter TO
		 enterTextById("endDate", "dfdsfs");
		//Serach
		 
		 clickbyXpath("(//input[@type='submit'])[3]");
		 
		 //verify fliter result
		 
		 String actual =getTextByXpath("//div[@class='validation-summary-errors']/ul/li");
		
		 Assert.assertEquals(actual, "You have entered an invalid date format. Please use the format DD/MM/YYYY or MM/YYYY or YYYY.");
		 
		quitBrowser();
		
		
	}

}
