package discovery.Ecommerce;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageCheckRequestMore1000Characters extends Wrapper {

	@Test
	public void PageCheckRequestACopy() throws IOException,
			InterruptedException {

		launchDriver(
				"http://test.discovery.nationalarchives.gov.uk/pagecheck/addtobasket/C11443396?readertype=offsite",
				"chrome");

		Thread.sleep(3000);

		// click request copy
		//clickbyXpath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]");

		Thread.sleep(3000);

		// click get started

		clickByClassName("discoveryPrimaryCallToActionLink");

		Thread.sleep(3000);

		// click the check box on certified copy

		// clickbyXpath("(//input[@name='CertifiedCopy'])[1]");
		
		String message = getTextByXpath("//span[@class='field-validation-error text-danger']");
		
		System.out.println(message);
		
		Assert.assertEquals("Customer instructions required.", message);

		Thread.sleep(3000);

		// Enter the details of the copy

		driver.findElementByXPath("//*[@id='CustomerInstructions']").sendKeys("Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible,"
				+ " please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible,"
				+ " please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				+ "please include page numbers, dates, and names.Please tell us as much as you can about what you want copied. Where possible, "
				);
				


		// enterTextById("//textarea[@id='CustomerInstructions']", "Research");

		Thread.sleep(3000);

		// click add to basket

		clickbyXpath("//input[@class='text_sketch']");
		
  String Errormessage = getTextByXpath("//span[@class='field-validation-error text-danger']");
		
		System.out.println(Errormessage);
		
		Assert.assertEquals("Customer instructions cannot exceed 1000 characters.", Errormessage);

		driver.quit();
		
}
}
