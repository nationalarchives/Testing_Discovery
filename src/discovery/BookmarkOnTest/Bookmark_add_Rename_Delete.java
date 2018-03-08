package discovery.BookmarkOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Bookmark_add_Rename_Delete extends Wrapper_methods {

	@Test
	public void bookmark_add() throws IOException, InterruptedException {

		launchDriver(
				"http://test.discovery.nationalarchives.gov.uk/details/r/C7351413",
				"chrome");

		// click the sigin in
		Thread.sleep(3000);

		clickbyLinkText("Sign in");
		//driver.findElementByXPath("(//a[@href='/sign-in'])[3]").click();

		driver.findElementById("UserName")
				.sendKeys("shanvivenkatesh@gmail.com");

		driver.findElementById("Password").sendKeys("Shanvi2016");
		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();

		clickbyLinkText("Bookmark");

		enterByTextXpath("//input[@name='title']", "Testbookmark");

		clickbyXpath("//input[@value='Add bookmark']");

		String actual_Bookmark=getTextById("bookmarkAddedSuccessfully");
		System.out.println(actual_Bookmark);
		
		
		Thread.sleep(3000);
		
		Assert.assertEquals("Bookmark has been added successfully",actual_Bookmark);
		
		clickbyID("signInLink");
		Thread.sleep(3000);
		clickbyLinkText("Your bookmarks");
		
		clickbyLinkText("Your bookmarks");
		
	//Rename Bookmark
		
		
		clickbyLinkText("Rename");
		// enter new name
		enterByTextXpath("//input[@name='newTitle']", "TestRenamebookmark");
		//click confirm
		
		clickbyXpath("//input[@value='Confirm']");
		
		
		//delete the book mark
		
		
		clickbyLinkText("Delete");
		
		clickbyLinkText("Confirm");
		
		String actual_Message=getTextByXpath("//div[@class='col ends-at-two-thirds box']/h2");
		
		System.out.println(actual_Message);
		
		Assert.assertEquals("You currently have no bookmarked pages", actual_Message);
		
		quitBrowser();
		

	}

}
