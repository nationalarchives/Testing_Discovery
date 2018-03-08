package discovery.SingleSignOnTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class SS_ForgttenPassword extends Wrapper_methods{
	
	@Test
	
	public void forgotten_Password() throws IOException{
		
		
		launchDriver("https://test.secure.nationalarchives.gov.uk/Login", "chrome");
		
		enterTextById("UserName", "TestMailcheck1233@gmail.com");
		
		clickbyLinkText("Forgotten your password?");
		
		//enter email id to send request
		
		enterTextById("Email", "TestMailcheck1233@gmail.com");
		
		//clcik send request
		
		clickbyXpath("//input[@value='Send request']");
		
		String reset_Message=getTextByXpath("//div[@class='container row']");
		
		System.out.println(reset_Message);
		
		Assert.assertTrue(reset_Message.contains("Check your e-mail 'TestMailcheck1233@gmail.com'."));
		
		quitBrowser();
	}

}
