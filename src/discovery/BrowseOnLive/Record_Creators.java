package discovery.BrowseOnLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Record_Creators extends Wrapper_methods {
	
	@Test
	public void recordCreators() throws IOException, InterruptedException{
		
		launchDriver("http://discovery.nationalarchives.gov.uk/", "chrome");
		
		clickbyLinkText("browse");
		Thread.sleep(3000);
		clickbyXpath("//ul[@class='browse-record-creators']/li[1]");
		Thread.sleep(3000);
		clickbyXpath("(//ul[@class='a-z'])/li[20]");
		
		Thread.sleep(3000);
		
		
		String title = getTextByXpath("//ul[@id='search-results']/li[1]/a/h3");
		System.out.println(title);
		
		clickbyXpath("//ul[@id='search-results']/li[1]/a/h3");
		
		//clickbyXpath("//ul[@id='search-results']/li[1]");
		
		String detailPage_Tittle=getTextByXpath("//h1[@class='inline']");
		
		System.out.println(detailPage_Tittle);
		
		Assert.assertEquals(detailPage_Tittle, title);
		
		quitBrowser();

}
}