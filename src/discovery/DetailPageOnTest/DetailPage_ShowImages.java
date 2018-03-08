package discovery.DetailPageOnTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class DetailPage_ShowImages extends Wrapper_methods {
	
	
	@Test
	
	public void DetailPage_ShowImages() throws IOException{
		
		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/D32670", "chrome");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
				
		clickbyLinkText("Show images");
		
	//Point img =driver.findElementByXPath("//img[@id='subjectImage']").getLocation();
	
	
 String Text =driver.findElementByXPath("//div[@class='image-info emphasis-block']").getText();
				
				//.getAttribute("innerHTML");
		
		System.out.println(Text);
		
		
		Assert.assertEquals(Text,"Please note, images are low-resolution and have been intentionally distorted. To download a high-resolution, complete record, please add to your basket.");
		
		clickbyLinkText("Hide images");
		quitBrowser();
		
		
		
		
		
		
	}
	
	

}
