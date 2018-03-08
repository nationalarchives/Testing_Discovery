package endToEndPageRequest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class BackOfficeAndTestEnv_PageRequest extends Wrapper_methods{
	
	@Test(priority=1)
	
public void Rocordcopy() throws IOException, InterruptedException{
		
		launchDriver("http://RCOperator:Operaclaimrestcart3@test.recordcopying.tna.local/", "chrome");
		
		//launchDriver("http://RCOperator:Operaclaimrestcart3@dev.recordcopying.nationalarchives.web.local/", "chrome");
		
		
		
		
		
		//Runtime.getRuntime().exec("./HandleAuthentication.exe");
		
		/*driver.switchTo().alert().setCredentials(1);
		
		driver.switchTo().alert().s*/
		
		
		
		Select OrderNo = new Select(driver.findElementById("formselector"));
		
		
		OrderNo.selectByIndex(1);

		driver.findElementById("TextSearch_OrderNumber").sendKeys("RC1004035");
		
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


	
@Test(priority=2)
public void PlacOrder() throws InterruptedException, IOException {

	launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C6553048#?readertype=offsite","Chrome");

	Thread.sleep(3000);

	clickbyLinkText("Sign in");
	// Create the account or sign in
	// Enter email

	driver.findElementById("UserName").sendKeys("shanvivenkatesh@gmail.com");

	Thread.sleep(3000);

	// Enter password

	driver.findElementById("Password").sendKeys("Shanvi2016");

	// click sign in

	driver.findElementByClassName("singleColumnSubmit").click();
	
	Thread.sleep(3000);
	
	clickbyID("signInLink");
	Thread.sleep(3000);
	clickbyLinkText("Your orders");
	
	clickbyLinkText("Place your copy order");
	
	((JavascriptExecutor) driver).executeScript("scroll(0,400)");
	
	clickbyXpath("//input[@value='Add to basket']");
	
	clickbyXpath("//input[@value='Checkout']");
	
	clickbyID("collect");
	
	clickbyXpath("//input[@value='Proceed']");
	
	// accept the terms and conditions

			clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");

			Thread.sleep(3000);

			// click the submit order

			clickbyXpath("(//input[@type='submit'])[3]");

			Thread.sleep(3000);

			// click the paypal payment
			clickbyXpath("(//input[@type='image'])[1]");

			Thread.sleep(3000);

			// click continue for payment

			clickbyID("PMMakePayment");

			Thread.sleep(3000);

			getTextByXpath("//div[@class='heading-holding-banner']");

}


	
@Test(priority=3)
public void AfterPlacingOrder() throws InterruptedException, IOException {

	launchDriver("http://RCOperator:Operaclaimrestcart3@test.recordcopying.tna.local/",
			"chrome");

	// launchDriver("http://RCOperator:Operaclaimrestcart3@dev.recordcopying.nationalarchives.web.local/",
	// "chrome");

	// Runtime.getRuntime().exec("./HandleAuthentication.exe");

	Select OrderNo = new Select(driver.findElementById("formselector"));

	OrderNo.selectByIndex(1);
	Thread.sleep(4000);

	driver.findElementById("TextSearch_OrderNumber").sendKeys("RC1004035");

	Select CopyOrder = new Select(
			driver.findElementById("orderNumberTypeSelect"));

	CopyOrder.selectByVisibleText("Copy Order");

	Thread.sleep(3000);

	driver.findElementByXPath(
			"//input[@name='submit-TextSearch.OrderNumber']").click();

	Thread.sleep(3000);

	driver.findElementByXPath("//ul[@id='search-results']/li/a/h3").click();

	driver.findElementByLinkText("Change status to 'in progress'").click();

	((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

	clickbyLinkText("Send complete email");
	Thread.sleep(3000);
	clickbyXpath("//input[@value='Preview message']");
	Thread.sleep(3000);
	clickbyXpath("//input[@value='Send to user']");
	
	String Actual = getTextByXpath("(//div[@class='responsive-table'])[2]/table/tbody/tr[4]");
	
	System.out.println(Actual);

}


@Test(priority=4)

public void finalverification() throws InterruptedException, IOException{
	launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C6553048#?readertype=offsite","Chrome");

	Thread.sleep(3000);

	clickbyLinkText("Sign in");
	// Create the account or sign in
	// Enter email

	driver.findElementById("UserName").sendKeys("shanvivenkatesh@gmail.com");

	Thread.sleep(3000);

	// Enter password

	driver.findElementById("Password").sendKeys("Shanvi2016");

	// click sign in

	driver.findElementByClassName("singleColumnSubmit").click();
	
	Thread.sleep(3000);
	
	clickbyID("signInLink");
	Thread.sleep(3000);
	clickbyLinkText("Your orders");

	
	String Actual_status = getTextByXpath("(//div[@class='orderStatus'])[1]");
	
	System.out.println(Actual_status);
	
	
}



}





