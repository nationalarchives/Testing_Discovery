package endToEndPageRequest;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import wrapper.Wrapper_methods;

public class AfterPlacing_order_recordcopy extends Wrapper_methods {

	@Test
	public void Rocordcopy() throws InterruptedException, IOException {

		launchDriver("http://RCOperator:Operaclaimrestcart3@test.recordcopying.tna.local/",
				"chrome");

		// launchDriver("http://RCOperator:Operaclaimrestcart3@dev.recordcopying.nationalarchives.web.local/",
		// "chrome");

		// Runtime.getRuntime().exec("./HandleAuthentication.exe");

		Select OrderNo = new Select(driver.findElementById("formselector"));

		OrderNo.selectByIndex(1);
		Thread.sleep(4000);

		driver.findElementById("TextSearch_OrderNumber").sendKeys("RC1004020");

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

}
