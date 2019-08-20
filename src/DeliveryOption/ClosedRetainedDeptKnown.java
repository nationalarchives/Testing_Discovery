package DeliveryOption;

import java.io.File;
import org.testng.Assert;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class ClosedRetainedDeptKnown extends Wrapper_methods {

	@Test
	public void closedRetainedDeptKnown() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(2).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(2).getStringCellValue();
		String expectedStaffDO = sheet.getRow(2).getCell(2).getStringCellValue();

		launchDriver(iaid, "chrome");

		System.out
				.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML"));

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])")
				.getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("ClosedRetainedDeptKnown"));

		String deliveryOptionStaff = (driver.findElementByClassName("order-option-wrapper").getText());
		System.out.println(deliveryOptionStaff);
		Assert.assertEquals(expectedStaffDO, deliveryOptionStaff);

		Thread.sleep(3000);

		driver.quit();

	}

}
