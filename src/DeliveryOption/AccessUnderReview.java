package DeliveryOption;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AccessUnderReview extends Wrapper_methods {

	@Test
	public void accessUnderReview() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(1).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(1).getStringCellValue();
		String expectedValeStaff = sheet.getRow(2).getCell(1).getStringCellValue();

		launchDriver(iaid, "chrome");

		System.out
				.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML"));

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])")
				.getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("AccessUnderReview"));

		String actual = driver.findElementByXPath("//div[@class='order-option-wrapper']").getText();

		System.out.println(actual);

		Assert.assertEquals(expectedValeStaff, actual);

		Thread.sleep(3000);

		driver.quit();

	}

}
