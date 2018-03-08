package discovery.BrowseOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Browse_Archives extends Wrapper_methods {
	
	
	@Test
	public void Browse_Archives() throws IOException, InterruptedException{
		
		launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");
		
		clickbyLinkText("browse");
		
		clickbyXpath("(//ul[@class='a-z'])[3]/li[19]");

		String title= getTextByXpath("//ul[@id='search-results']/li[1]/a/h3");
		System.out.println(title);
		
		clickbyXpath("//ul[@id='search-results']/li[1]/a/h3");
		
		//detail page
		
		String detailPage_Title=getTextByXpath("//div[@class='breather holding-box']/h1");
		
		System.out.println(detailPage_Title);
		
		Assert.assertEquals(detailPage_Title, title);
		
		quitBrowser();
		
}
}
