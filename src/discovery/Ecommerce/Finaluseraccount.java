package discovery.Ecommerce;

import java.io.IOException;

import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Finaluseraccount extends Wrapper_methods {
	
	@Test
	
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
