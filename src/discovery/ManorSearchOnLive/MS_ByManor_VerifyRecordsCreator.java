package discovery.ManorSearchOnLive;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class MS_ByManor_VerifyRecordsCreator extends Wrapper_methods{
	
	@Test
	
	public void byManor_VerifyRecordsCreator() throws IOException, InterruptedException{
	//launch the browser and url	
	launchDriver("http://discovery.nationalarchives.gov.uk/manor-search", "chrome");
	Thread.sleep(3000);
	//Enter the wildcard
	enterTextById("manor-name", "*");
	((JavascriptExecutor) driver).executeScript("scroll(0,300)");
	
	//Click search button
	clickbyXpath("(//input[@type='submit'])[3]");
	
	
	Thread.sleep(3000);
	//Verify records
	String total_Records=getTextById("records-tab");
	System.out.println(total_Records);
	Assert.assertTrue(total_Records.contains("Records 0"));
	
	//Verify record creators
	String total_RecordsCreators=getTextById("name-authorities-tab");
	System.out.println(total_RecordsCreators);
	Assert.assertTrue(total_RecordsCreators.contains("Record creators 18,051"));
	
	
	//Verrify your filters
	Thread.sleep(3000);
	String yourFilters = getTextById("search-refine");
	System.out.println(yourFilters);
	
	Assert.assertTrue(yourFilters.contains("Manor"));
	
	
	//quit browser
	quitBrowser();
	}

}
