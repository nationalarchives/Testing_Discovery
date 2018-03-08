package discovery.Ecommerce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class HomeGuard extends Wrapper {

	@Test
	public void HomeGuard() throws IOException,InterruptedException, AWTException {
		
		//Robot robot = new Robot();

		launchDriver("http://test.discovery.nationalarchives.gov.uk/paidsearch/foirequest/90ad00a1aa6149efa3991fab6037a5ec?readertype=offsite","chrome");
		
		
				
		Thread.sleep(5000);
		driver.findElementById("search_firstnames").clear();	
	    driver.findElementById("search_firstnames").sendKeys("Shanthi");
	    driver.findElementById("search_lastname").clear();
		driver.findElementById("search_lastname").sendKeys("venkatesh");
		driver.findElementById("search_dob").clear();
		driver.findElementById("search_dob").sendKeys("05/07/1986");
		
		/*driver.findElementById("firstnames").sendKeys("Shanthi");
		driver.findElementById("firstnames").sendKeys("Shanthi");*/
		
		//selectByValue_UsingId("search_county", "Durham");
		
          Thread.sleep(5000);
		
		
		((JavascriptExecutor)driver).executeScript("scroll(0,1400)");
		Thread.sleep(3000);		
		clickbyXpath("//input[@type='file']");
		
	
		//File uplaod
		
        /*robot.setAutoDelay(1000);
        
        StringSelection stringSelection = new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
        
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        
        robot.setAutoDelay(1000);
        
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
     
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        
      
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
		Thread.sleep(5000);
		Runtime.getRuntime().exec("Z:\\Svenkatesh\\Result\\BatchExecution\\Fileupload.exe");
			
		//Runtime.getRuntime().exec("Z:\\Svenkatesh\\Result\\BatchExecution\\Fileupload.exe");
		
		//enter your details
		Thread.sleep(5000);
		 
		 driver.findElementById("firstname").sendKeys("shanthi");
		
		 driver.findElementById("lastname").sendKeys("venkatesh");
		 
		 driver.findElementById("email").sendKeys("shanvivenkatesh@gmail.com");
		 
		 	 
		 driver.findElementById("address1").sendKeys("63 Lloydcourt");
		 
		 		 
		 driver.findElementById("postcode").sendKeys("Ha51eg");
		 
		selectByValue_UsingId("country", "United Kingdom");
		 
		 //clcik to add to basket
		 
		driver.findElementByXPath("//input[@class='discoveryPrimaryCallToActionLink']").click();
		// clickbyClassName("discoveryPrimaryCallToActionLink");
		 
		 Thread.sleep(3000);
		 
		 //click checkout
		 clickbyXpath("//input[@class='call-to-action-link']");
		 
		 //enter email id
		 
		 enterByTextXpath("//input[@id='DeliveryEmail']", "shanvivenkatesh@gmail.com");
		 
		 //accept the terms and conditons
		 
		 clickbyXpath("(//input[@name='termsAndConditionsAccepted'])[1]");
		 
		 //click submitorder
		 
		 clickbyXpath("(//input[@type='submit'])[3]");
		 
		 Thread.sleep(5000);
		 
		 //click paypal
			clickbyXpath("(//input[@type='image'])[1]");
			
			Thread.sleep(3000);
			
			//click continue
			
			clickbyID("PMMakePayment");
			
			Thread.sleep(3000);
			
			
		 
			//driver.close();
		 
		 
		
		
		
		
		
}
}
