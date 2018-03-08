package discovery.FindAnAichiveOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class FA_HomeNation extends Wrapper_methods {

	@BeforeMethod
	public void launchBrowser() {

		launchDriver(
				"http://test.discovery.nationalarchives.gov.uk/find-an-archive",
				"chrome");
	}

	@Test
	public void firstHomeNation() throws IOException, InterruptedException {
		// click england
		clickbyLinkText("England");
		Thread.sleep(3000);
		String FilterResult = getTextById("search-filters");
		System.out.println(FilterResult);

		// verify location of archive and type of archive

		Assert.assertTrue(FilterResult.contains("London"));
		Assert.assertTrue(FilterResult.contains("South East"));
		Assert.assertTrue(FilterResult.contains("East of England"));
		Assert.assertTrue(FilterResult.contains("Yorkshire and the Humber"));
		Assert.assertTrue(FilterResult.contains("South West"));
		Assert.assertTrue(FilterResult.contains("North West"));
		Assert.assertTrue(FilterResult.contains("West Midlands"));
		Assert.assertTrue(FilterResult.contains("East Midlands"));
		Assert.assertTrue(FilterResult.contains("North East"));

		// verify type of archive
		Assert.assertTrue(FilterResult.contains("Special"));
		Assert.assertTrue(FilterResult.contains("Local"));
		Assert.assertTrue(FilterResult.contains("University"));
		Assert.assertTrue(FilterResult.contains("Private"));
		Assert.assertTrue(FilterResult.contains("National"));
		Assert.assertTrue(FilterResult.contains("Business"));

		// verify your filters

		String YourFilter = getTextById("search-refine");
		System.out.println(YourFilter);
		Assert.assertTrue(YourFilter.contains("England"));
		Thread.sleep(3000);

	}

	@Test
	public void secondHomeNation() throws IOException, InterruptedException {
		// click england
		clickbyLinkText("Northern Ireland");
		Thread.sleep(3000);
		String FilterResultNI = getTextById("search-filters");
		System.out.println(FilterResultNI);

		// verify your filters

		String YourFilter = getTextById("search-refine");
		System.out.println(YourFilter);
		Assert.assertTrue(YourFilter.contains("Northern Ireland"));

		// verify type of archive
		Assert.assertTrue(FilterResultNI.contains("Special"));
		Assert.assertTrue(FilterResultNI.contains("Local"));
		Assert.assertTrue(FilterResultNI.contains("University"));
		Assert.assertTrue(FilterResultNI.contains("Private"));
		Assert.assertTrue(FilterResultNI.contains("National"));
		Thread.sleep(3000);
		

	}

	
	@Test
	public void ThirdHomeNation() throws IOException, InterruptedException {
		// click england
		clickbyLinkText("Scotland");
		Thread.sleep(3000);
		String FilterResultSC = getTextById("search-filters");
		System.out.println(FilterResultSC);

		// verify your filters

		String YourFilter = getTextById("search-refine");
		System.out.println(YourFilter);
		Assert.assertTrue(YourFilter.contains("Scotland"));

		// verify type of archive
		Assert.assertTrue(FilterResultSC.contains("Special"));
		Assert.assertTrue(FilterResultSC.contains("Local"));
		Assert.assertTrue(FilterResultSC.contains("University"));
		Assert.assertTrue(FilterResultSC.contains("Private"));
		Assert.assertTrue(FilterResultSC.contains("National"));
		Assert.assertTrue(FilterResultSC.contains("Business"));
		Thread.sleep(3000);
		
	}
		
		@Test
		public void FourthHomeNation() throws IOException, InterruptedException {
			// click england
			clickbyLinkText("Wales");
			Thread.sleep(3000);
			String FilterResultWA = getTextById("search-filters");
			System.out.println(FilterResultWA);

			// verify your filters

			String YourFilter = getTextById("search-refine");
			System.out.println(YourFilter);
			Assert.assertTrue(YourFilter.contains("Wales"));

			// verify type of archive
			Assert.assertTrue(FilterResultWA.contains("Special"));
			Assert.assertTrue(FilterResultWA.contains("Local"));
			Assert.assertTrue(FilterResultWA.contains("University"));
			Assert.assertTrue(FilterResultWA.contains("Private"));
			Assert.assertTrue(FilterResultWA.contains("National"));
			Assert.assertTrue(FilterResultWA.contains("Business"));
			Thread.sleep(3000);
			
	}
	@AfterMethod
	public void closebrowser() throws IOException {

		quitBrowser();
	}

}
