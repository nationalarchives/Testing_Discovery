package endToEndPageRequest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class RecordCopy extends Wrapper_methods{
	@Test
	
	public void Rocordcopy() throws IOException, InterruptedException{
		
		launchDriver("http://RCOperator:Operaclaimrestcart3@test.recordcopying.tna.local/", "chrome");
		
		//launchDriver("http://RCOperator:Operaclaimrestcart3@dev.recordcopying.nationalarchives.web.local/", "chrome");
		
		
		
		
		
		//Runtime.getRuntime().exec("./HandleAuthentication.exe");
		
		/*driver.switchTo().alert().setCredentials(1);
		
		driver.switchTo().alert().s*/
		
		
		
		Select OrderNo = new Select(driver.findElementById("formselector"));
		
		
		OrderNo.selectByIndex(1);

		driver.findElementById("TextSearch_OrderNumber").sendKeys("RC1004020");
		
		driver.findElementByXPath("//input[@name='submit-TextSearch.OrderNumber']").click();
		
	    Thread.sleep(3000);
	    
	    driver.findElementByXPath("//ul[@id='search-results']/li/a/h3").click();
		
		//driver.findElementByLinkText("RC1001256").click();
		
		driver.findElementByLinkText("Change status to 'in progress'").click();
		
			
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		
		enterByTextXpath("//input[@id='a3']", "3");
		
		//enterByTextXpath("//input[@id='certifiedPages']", "3");
				
		//driver.findElementById("paper-colour").click();
		
		clickbyXpath("//input[@id='paper-colour']");
		
		
		clickbyXpath("//input[@value='Update and send']");
		
		String Actual_Status =getTextByXpath("//table[@class='page-check']/tbody/tr[2]");
		
		System.out.println(Actual_Status);
		
		Assert.assertEquals(Actual_Status, "Status Page check completed");
		
		
		
		
		
		
	}

}
