package DeliveryOption;

import java.io.File;
import org.testng.Assert;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class InvigilationSafeRoom extends Wrapper_methods {

	@Test
	public void invigilationSafeRoom() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(19).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(19).getStringCellValue();
		String expectedValeStaff = sheet.getRow(2).getCell(19).getStringCellValue();
		String expectedOnsitePublicDo = sheet.getRow(3).getCell(19).getStringCellValue();
		String expectedOffisteDo = sheet.getRow(4).getCell(19).getStringCellValue();

		launchDriver(iaid, "chrome");

		driver.findElementByXPath("(//a[@class='discoveryPrimaryCallToActionLink'])[5]").click();

		Thread.sleep(3000);

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]")
				.getAttribute("innerHTML");

		System.out.println(Staffcheck);

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("InvigilationSafeRoom"));

		String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(deliveryOptionStaff);

		Assert.assertEquals(expectedValeStaff, deliveryOptionStaff);

		String deliveryOptionOnsitePublic = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getText();

		System.out.println(deliveryOptionOnsitePublic);

		Assert.assertEquals(expectedOnsitePublicDo, deliveryOptionOnsitePublic);

		String onsitepublic = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getAttribute("innerHTML");

		System.out.println(onsitepublic);

		Assert.assertTrue(onsitepublic.contains("OnSitePublic"));

		Assert.assertTrue(onsitepublic.contains("InvigilationSafeRoom"));

		String Offsitecheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]")
				.getAttribute("innerHTML");

		System.out.println(Offsitecheck);

		Assert.assertTrue(Offsitecheck.contains("OffSite"));

		Assert.assertTrue(Offsitecheck.contains("InvigilationSafeRoom"));

		String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getText();

		System.out.println(deliveryOptionOffsite);

		Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);

		Thread.sleep(3000);

		driver.quit();

	}

}
