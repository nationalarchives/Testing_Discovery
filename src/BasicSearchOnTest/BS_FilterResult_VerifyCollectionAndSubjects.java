package BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_FilterResult_VerifyCollectionAndSubjects extends Wrapper_methods {

	// Open the browser

	public void VerifyCollectionAndSubjects() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		//Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("nelson");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Filter result

		String searchFilters = driver.findElementByXPath("//*[@id=\"search-filters\"]").getText();
		System.out.println(searchFilters);

		// click the nationalarchive link on held by
		Thread.sleep(3000);
		driver.findElementByLinkText("The National Archives").click();

		// Filter result

		String afterHeldbylinkclick_searchFilters = driver.findElementByXPath("//*[@id=\"search-filters\"]").getText();
		System.out.println(afterHeldbylinkclick_searchFilters);

		// collection

		List<WebElement> collectionList = driver.findElementsByXPath("//li[@id='department']/form/div/ul/li");

		int count = collectionList.size();

		System.out.println(count);
		String woCheck = collectionList.get(0).getText();

		System.out.println(woCheck);

		Assert.assertTrue(afterHeldbylinkclick_searchFilters.contains(woCheck));

		// Subjects
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
		Thread.sleep(3000);
		driver.findElementById("subject-filters").click();

		List<WebElement> SubjectsList = driver.findElementsByXPath("//li[@id='subjects']/form/div/ul/li");

		int countOnSubject = SubjectsList.size();

		System.out.println(countOnSubject);
		String ArmedForces = SubjectsList.get(0).getText();

		System.out.println(ArmedForces);

		// Assert.assertTrue(afterHeldbylinkclick_searchFilters.contains(ArmedForces));
		quitBrowser();

	}

}
