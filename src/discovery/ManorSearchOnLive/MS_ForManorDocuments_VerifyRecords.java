package discovery.ManorSearchOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class MS_ForManorDocuments_VerifyRecords extends Wrapper_methods{
	
	@Test
	
	public void ForManorDocuments_VerifyRecords() throws IOException, InterruptedException{
	//launch the browser and url	
	launchDriver("http://discovery.nationalarchives.gov.uk/manor-search", "chrome");
	Thread.sleep(3000);
	
	//click search for manorial documents
	
	clickbyID("search-documents");
	Thread.sleep(3000);
	//Enter the wildcard
	enterTextById("all-words-records", "*");
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	Thread.sleep(3000);
	//Click search button
	clickbyXpath("(//input[@type='submit'])[4]");
	
	
	Thread.sleep(3000);
	//Verify records
	String total_Records=getTextById("records-tab");
	System.out.println(total_Records);
	if(total_Records.matches("Records 254,[0-9].*"))
	System.out.println(true);
		else
	 System.out.println(false);
	Thread.sleep(3000);
	//Verify record creators
	String total_RecordsCreators=getTextById("name-authorities-tab");
	System.out.println(total_RecordsCreators);
	Assert.assertTrue(total_RecordsCreators.contains("Record creators 0"));
	

	// Verify your filters
	Thread.sleep(3000);
	String yourFilters = getTextById("search-refine");
	System.out.println(yourFilters);

	Assert.assertTrue(yourFilters.contains("Manor"));
	
	
		
	//quit browser
	quitBrowser();
	}

}
