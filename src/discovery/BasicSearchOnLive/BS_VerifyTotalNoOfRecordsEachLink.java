package discovery.BasicSearchOnLive;


import java.io.IOException;

import org.testng.annotations.Test;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.hamcrest.Matcher;
import org.junit.Assert;

import wrapper.Wrapper_methods;



@Test
public class BS_VerifyTotalNoOfRecordsEachLink extends Wrapper_methods {
	// Open the browser and the url
	// enter the wildcard in search box
	// click the search button
	// check total no of records
	// check total no of record creators
	// click nationalarchiveslink and verify the totalnoof records
	//close the filter
	// click availabledownlaod and verify the totalnoof recordsclick
	//click remove all filter recocords
	// click otherarchives and verify the totalnoof records

	// Open the browser and the url
	public void VerifyTotalNoOfRecordsEachLinkGreaterThan() throws InterruptedException, IOException {

		launchDriver("http://discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);

		enterTextById("search-all-collections", "*");

		Thread.sleep(3000);

		clickbyXpath("(//input[@type='submit'])[1]");

		Thread.sleep(3000);

		String totalNoOfRecords = getTextById("records-tab");
		
		System.out.println(totalNoOfRecords);

		if (totalNoOfRecords.matches("Records 34,[0-9].*,[0-9].*"))

			System.out.println(true);

		else
			System.out.println(false);
		
		
		String totalNoOfRecordCreators = getTextById("nameAuthorities");

		System.out.println(totalNoOfRecordCreators);

		if (totalNoOfRecordCreators.matches("Record creators 261,[0-9].*"))

			System.out.println(true);

		else
			System.out.println(false);

		
		clickbyLinkText("The National Archives");
		
		
		Thread.sleep(3000);

		String totalNoOfRecordsForTheNationalArcgives = getTextById("records-tab");

		System.out.println("The national Archives Total no of records are : "+ totalNoOfRecordsForTheNationalArcgives);

		if (totalNoOfRecordsForTheNationalArcgives.matches("Records 23,[0-9].*,[0-9].*"))

			System.out.println(true);

		else
			System.out.println(false);
		
		
		clickbyXpath("//img[@alt='Remove']");
		
		
		clickbyLinkText("Available for download only");
		Thread.sleep(3000);
		String totalNoOfRecordsForDownloadOnly = getTextById("records-tab");

		System.out.println("The national Archives Total no of records are : "+ totalNoOfRecordsForDownloadOnly);

		if (totalNoOfRecordsForDownloadOnly.matches("Records 8,[0-9].*,[0-9].*"))

			System.out.println(true);

		else
			System.out.println(false);
		
		Thread.sleep(3000);
		clickbyLinkText("Remove all filters");
		Thread.sleep(3000);
		clickbyLinkText("Other archives");
		
		String totalNoOfRecordsForOtherArchive = getTextById("records-tab");

		System.out.println("The national Archives Total no of records are : "+ totalNoOfRecordsForOtherArchive);

		if (totalNoOfRecordsForOtherArchive.matches("Records 10,[0-9].*,[0-9].*"))

			System.out.println(true);

		else
			System.out.println(false);
		
		
		
		quitBrowser();
	}

	
	}

	
	


