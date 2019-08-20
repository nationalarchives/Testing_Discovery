package BasicSearchOnTest;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_RecordCreator_filterresult extends Wrapper_methods {

	// Open the browser

	public void RecordCreator_filterresult() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("*");

		Thread.sleep(3000);

		// click search
		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// click Record Creators

		driver.findElementById("nameAuthorities").click();

		// get filter result

		String recordCreator_FilterResult = driver.findElementById("search-filters").getText();

		System.out.println(recordCreator_FilterResult);

		// verify creator type

		Assert.assertTrue(recordCreator_FilterResult.contains("Organisation"));
		Assert.assertTrue(recordCreator_FilterResult.contains("Person"));
		Assert.assertTrue(recordCreator_FilterResult.contains("Business"));
		Assert.assertTrue(recordCreator_FilterResult.contains("Manor"));
		Assert.assertTrue(recordCreator_FilterResult.contains("Family"));
		Assert.assertTrue(recordCreator_FilterResult.contains("Diaries"));

		/*
		 * List<WebElement>creatorTypeList=driver.findElementsByXPath(
		 * "//*[@id='entities']/div/ul/li");
		 * 
		 * int count = creatorTypeList.size();
		 * 
		 * System.out.println(count);
		 * 
		 * 
		 * for(int i=0; i<count; i++){
		 * 
		 * String eachtye= creatorTypeList.get(i).getText();
		 * 
		 * System.out.println(eachtye);
		 * 
		 * Assert.assertTrue(recordCreator_FilterResult.contains(eachtye)); }
		 */

		quitBrowser();
	}

}
