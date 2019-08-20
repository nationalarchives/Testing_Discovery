package DeliveryOption;

import java.io.File;
import org.testng.Assert;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DisplayAtMuseum extends Wrapper_methods {

	@Test
	public void displayAtMuseum() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(8).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(8).getStringCellValue();
		String expectedStaffDo = sheet.getRow(2).getCell(8).getStringCellValue();
		String expectedOffisteDo = sheet.getRow(4).getCell(8).getStringCellValue();

		launchDriver(iaid, "chrome");
		driver.findElementByXPath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]").click();

		Thread.sleep(3000);

		System.out.println(
				driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getAttribute("innerHTML"));
		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText());

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]")
				.getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("DisplayAtMuseum"));

		String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(deliveryOptionStaff);

		Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);

		System.out.println(
				driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getAttribute("innerHTML"));

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText());

		String onsitepublic = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getAttribute("innerHTML");

		Assert.assertTrue(onsitepublic.contains("OnSitePublic"));

		Assert.assertTrue(onsitepublic.contains("DisplayAtMuseum"));

		String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText();

		System.out.println(deliveryOptionOffsite);

		Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);

		Thread.sleep(3000);

		driver.quit();

	}

}