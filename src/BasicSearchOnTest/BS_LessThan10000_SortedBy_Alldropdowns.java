package BasicSearchOnTest;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

@Test
public class BS_LessThan10000_SortedBy_Alldropdowns extends Wrapper_methods {

	// Open the browser

	public void SortedBy_Alldropdowns() throws IOException, InterruptedException {

		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

		Thread.sleep(3000);
		// Enter the word in search

		driver.findElementById("search-all-collections").sendKeys("Titanic");

		Thread.sleep(3000);

		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		Thread.sleep(3000);

		// Lessthan 10,000 records so select from drop down
		// select title acending
		Select sortedBy_TitleAcending = new Select(driver.findElementById("sortDrop"));

		sortedBy_TitleAcending.selectByIndex(2);
		Thread.sleep(3000);

		// verify records start with number
		List<WebElement> listAll_Title = driver.findElementsByXPath("//ul[@id='search-results']/li/a/h3");

		String first_Record = listAll_Title.get(0).getText();
		System.out.println(first_Record);

		Assert.assertTrue(first_Record.contains("1 item"));

		// clcik the link E
		Thread.sleep(3000);
		driver.findElementByLinkText("E").click();

		List<WebElement> title_E = driver.findElementsByXPath("//ul[@id='search-results']/li/a/h3");

		int count = title_E.size();

		for (int i = 0; i < count; i++) {
			String titleE = (title_E.get(i).getText());
			System.out.println(titleE);
			if (titleE.matches("E.*"))
				System.out.println(true);
			else
				System.out.println(false);

		}

		// click view all

		driver.findElementByXPath("//a[@class='discoveryPrimaryCallToActionLink']").click();

		// select title decending

		Select sortedBy_TitleDecending = new Select(driver.findElementById("sortDrop"));

		sortedBy_TitleDecending.selectByIndex(3);
		Thread.sleep(3000);

		List<WebElement> title_Decending = driver.findElementsByXPath("//ul[@id='search-results']/li/a/h3");

		int countDec = title_Decending.size();

		for (int i = 0; i < count; i++) {
			String titleDec = (title_Decending.get(i).getText());
			System.out.println(titleDec);
			if (titleDec.matches("W.*"))
				System.out.println(true);
			else
				System.out.println(false);

		}

		// Date ascending

		// select title decending

		Select sortedBy_DateAscending = new Select(driver.findElementById("sortDrop"));

		sortedBy_DateAscending.selectByIndex(4);
		Thread.sleep(3000);

		List<WebElement> date_Ascending = driver
				.findElementsByXPath("//*[@id='search-results']/li/a/table/tbody/tr[2]");

		int countdateAscen = date_Ascending.size();

		for (int i = 0; i < count; i++) {
			String dateAscen = (date_Ascending.get(i).getText());
			System.out.println(dateAscen);
			// Assert.assertTrue(dateAscen.contains("Dates unknown"));
			// Assert.assertTrue(dateAscen.contains("Engraving"));

		}

		// date decending

		Select sortedBy_DateDecending = new Select(driver.findElementById("sortDrop"));

		sortedBy_DateDecending.selectByIndex(5);
		Thread.sleep(3000);

		List<WebElement> date_Decending = driver
				.findElementsByXPath("//*[@id='search-results']/li/a/table/tbody/tr[2]");

		int countdateDecen = date_Decending.size();

		for (int i = 0; i < count; i++) {
			String dateDecen = (date_Decending.get(i).getText());
			System.out.println(dateDecen);
		}

		quitBrowser();

	}

}
