package discovery.DetailPageOnTest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Verify_DetailPage_OnAllLevels extends Wrapper_methods {
	
	@Test
	
	public void detailPgae() throws InterruptedException, IOException{
		
		//Open the url
		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C252", "chrome");
		
		
		
		//verify the reference On Department level
		
		String department_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(department_ref);
		
		Assert.assertTrue(department_ref.contains("Reference: T"));
		
		//verify the reference on Division level
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,3800)");
		Thread.sleep(3000);
		
		clickbyXpath("//a[@href='/browse/r/h/C252']");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		clickbyXpath("//a[@href='/details/r/C671']");
		String  Division_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(Division_ref);
		
		Assert.assertTrue(Division_ref.contains("Reference: Division within T"));
		
		
	//verify series level
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(3000);
		clickbyXpath("//a[@href='/browse/r/h/C671']");
		
		Thread.sleep(3000);
		
		clickbyXpath("//a[@href='/details/r/C13807']");
		
		String series_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(series_ref);
		Assert.assertTrue(series_ref.contains("Reference: T 70"));
		
		//verify Subseries level
		
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Thread.sleep(3000);
		clickbyXpath("//a[@href='/browse/r/h/C13807']");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,3200)");
		clickbyXpath("//a[@href='/details/r/C33507']");
		String Subseries_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(Subseries_ref);
		Assert.assertTrue(Subseries_ref.contains("Reference: Subseries within T 70"));
		
		
		//verify subsubseries level
		Thread.sleep(3000);
		clickbyXpath("//a[@href='/browse/r/h/C33507']");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		clickbyXpath("//a[@href='/details/r/C100324']");
		String Subsubseries_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(Subsubseries_ref);
		Assert.assertTrue(Subsubseries_ref.contains("Reference: Subsubseries within T 70"));
		
		
		//verify Piece level
		Thread.sleep(3000);
		clickbyXpath("//a[@href='/browse/r/h/C100324']");
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		clickbyXpath("//a[@href='/details/r/C1248122']");
		String Piece_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(Piece_ref);
		Assert.assertTrue(Piece_ref.contains("Reference: T 70/1142"));
		
		//verify item level
		
		Thread.sleep(3000);
		clickbyXpath("//a[@href='/browse/r/h/C1248122']");
		Thread.sleep(3000);
		clickbyXpath("//a[@href='/details/r/C6221775']");
		String item_ref=driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(item_ref);
		Assert.assertTrue(item_ref.contains("Reference: T 70/1142"));
		
		quitBrowser();
		
		
		
		
		
		
	}
	
	

}
