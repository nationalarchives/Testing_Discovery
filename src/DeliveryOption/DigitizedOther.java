package DeliveryOption;

import java.io.File;
import org.testng.Assert;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DigitizedOther extends Wrapper_methods {

	@Test

	public void digitizedOther() throws Exception {
		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(6).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(6).getStringCellValue();
		String expectedStaffDo = sheet.getRow(2).getCell(6).getStringCellValue();
		String expectedOffisteDo = sheet.getRow(4).getCell(6).getStringCellValue();

		launchDriver(iaid, "chrome");

		driver.findElementByXPath("//a[@class='discoveryPrimaryCallToActionLink']").click();

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText());

		String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(deliveryOptionStaff);

		Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);

		String staffCheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]")
				.getAttribute("innerHTML");

		Assert.assertTrue(staffCheck.contains("StaffIn"));
		Assert.assertTrue(staffCheck.contains("DigitizedOther"));

		String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText());
		System.out.println(deliveryOptionOffsite);

		Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);

		String offsiteCheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getAttribute("innerHTML");

		Assert.assertTrue(offsiteCheck.contains("OffSite"));
		Assert.assertTrue(offsiteCheck.contains("DigitizedOther"));

		Thread.sleep(3000);
		driver.quit();

	}

}