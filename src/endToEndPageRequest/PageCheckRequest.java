package endToEndPageRequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class PageCheckRequest extends Wrapper_methods {

	@Test
	public void PageCheckRequestACopy() throws IOException,
			InterruptedException {

		launchDriver(
				"http://test.discovery.nationalarchives.gov.uk/details/r/C6553048#?readertype=offsite",
				"chrome");

		Thread.sleep(3000);

		// click request copy
		clickbyXpath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]");

		Thread.sleep(3000);

		// click get started

		clickByClassName("discoveryPrimaryCallToActionLink");

		Thread.sleep(3000);

		// click the check box on certified copy

		// clickbyXpath("(//input[@name='CertifiedCopy'])[1]");

		Thread.sleep(3000);

		// Enter the details of the copy

		driver.findElementByXPath("//*[@id='CustomerInstructions']").sendKeys(
				"Research");

		// enterTextById("//textarea[@id='CustomerInstructions']", "Research");

		Thread.sleep(3000);

		// click add to basket

		clickbyXpath("//input[@class='text_sketch']");

		Thread.sleep(3000);
		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(3000);
		// Create the account or sign in
		// Enter email

		driver.findElementById("UserName")
				.sendKeys("shanvivenkatesh@gmail.com");

		Thread.sleep(3000);

		// Enter password

		driver.findElementById("Password").sendKeys("Shanvi2016");

		// click sign in

		driver.findElementByClassName("singleColumnSubmit").click();

		// click the checkout

		clickbyXpath("//input[@value='Checkout']");

		Thread.sleep(3000);

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
		
		
		//String Actual_Ordernumber =getTextByXpath("//*[@id='basketItemsWrapper']/div[1]/div[2]/p/text()[2]");
		
		//String Actual_Ordernumber =getTextByXpath("//div[@class='basket-item']/p/br[1]");
		
		String Actual_Ordernumber =getTextByXpath("//div[@class='basket-item']");
		
		//Actual_Ordernumber.getChars(srcBegin, srcEnd, dst, dstBegin);
		
		//div[@class='basket-item']/p/br[1]
		
		System.out.println(Actual_Ordernumber);

		//driver.close();
		
      /* driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+ "t");
		
		driver.get("http://dev.recordcopying.nationalarchives.web.local/");

	    driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Runtime.getRuntime().exec("Z:\\Svenkatesh\\Result\\BatchExecution\\HandleAuthentication.exe");*/
	}

}
