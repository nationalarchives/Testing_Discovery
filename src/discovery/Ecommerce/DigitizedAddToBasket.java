package discovery.Ecommerce;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DigitizedAddToBasket extends Wrapper{
	
	@Test
	
	public void DigitizedAddToBasket() throws IOException, InterruptedException{
		
		launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/C7351413?readertype=offsite", "chrome");
		
		clickbyClassName("discoveryPrimaryCallToActionLink");
				
		System.out.println(getTextById("miniBasketLink"));
				
		clickbyID("miniBasketLink");
		
		//clcik add to baslet
		
		clickbyXpath("//a[@class='discoverySecondaryCallToActionLink']");
		
		Thread.sleep(3000);
		
		//click checkout
		
		clickbyXpath("//input[@class='call-to-action-link']");
		Thread.sleep(3000);
		
		//System.out.println(getTextById("heading-holding-banner"));
		
		Thread.sleep(3000);
		
		enterByTextXpath("//input[@id='DeliveryEmail']", "shanvivenkatesh@gmail.com");
		
		Thread.sleep(3000);
		
		clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");
		
		Thread.sleep(3000);
		clickbyXpath("(//input[@type='submit'])[3]");
		
		Thread.sleep(3000);
		clickbyXpath("(//input[@type='image'])[1]");
		
		Thread.sleep(3000);
		
		clickbyID("PMMakePayment");
		
		getTextByXpath("//div[@class='heading-holding-banner']");
		
		Thread.sleep(3000);
		
		
		
		driver.close();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
	}
	
	

}
