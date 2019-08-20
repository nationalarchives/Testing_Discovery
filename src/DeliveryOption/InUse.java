package DeliveryOption;

import java.io.File;
import org.testng.Assert;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class InUse extends Wrapper_methods {

	@Test

	public void inUse() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(23).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(23).getStringCellValue();
		String expectedStaffDo = sheet.getRow(2).getCell(23).getStringCellValue();
		String expectedOffisteDo = sheet.getRow(4).getCell(23).getStringCellValue();

		launchDriver(iaid, "chrome");

		driver.findElementByXPath("(//a[@class='discoveryPrimaryCallToActionLink'])[3]").click();

		Thread.sleep(3000);

		System.out.println(
				driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getAttribute("innerHTML"));

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText());

		String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(deliveryOptionStaff);

		Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]")
				.getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("InUse"));

		Thread.sleep(3000);

		System.out.println(
				driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getAttribute("innerHTML"));

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText());

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText());

		String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText();

		System.out.println(deliveryOptionOffsite);

		Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);

		String Offsitecheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getAttribute("innerHTML");

		Assert.assertTrue(Offsitecheck.contains("OffSite"));

		Assert.assertTrue(Offsitecheck.contains("InUse"));

		Thread.sleep(3000);

		driver.quit();

	}

}
