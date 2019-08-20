package DeliveryOption;

import java.io.File;
import org.testng.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class AcademicSubscription extends Wrapper_methods {

	@Test

	public void academicSubscription() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(22).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(22).getStringCellValue();
		String expectedStaffDo = sheet.getRow(2).getCell(22).getStringCellValue();
		String expectedOnsitePublicDo = sheet.getRow(3).getCell(22).getStringCellValue();
		String expectedOffisteDo = sheet.getRow(4).getCell(22).getStringCellValue();

		launchDriver(iaid, "chrome");
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Softwares\\Selenium\\Driver\\geckodriver.exe"); FirefoxDriver
		 * driver = new FirefoxDriver();
		 * 
		 * driver.manage().window().maximize();
		 * 
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * 
		 * driver.get(iaid);
		 */

		driver.findElementByXPath("(//a[@class='discoveryPrimaryCallToActionLink'])[3]").click();

		Thread.sleep(3000);

		String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(deliveryOptionStaff);

		Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]")
				.getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("AcademicSubscription"));

		String deliveryOptionOnsitePublic = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getText();

		System.out.println(deliveryOptionOnsitePublic);

		Assert.assertEquals(expectedOnsitePublicDo, deliveryOptionOnsitePublic);

		String onsitepublic = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]")
				.getAttribute("innerHTML");

		Assert.assertTrue(onsitepublic.contains("OnSitePublic"));

		Assert.assertTrue(onsitepublic.contains("AcademicSubscription"));

		String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getText();

		System.out.println(deliveryOptionOffsite);

		Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);

		System.out.println(
				driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getAttribute("innerHTML"));

		String Offsitecheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]")
				.getAttribute("innerHTML");

		Assert.assertTrue(Offsitecheck.contains("OffSite"));

		Assert.assertTrue(Offsitecheck.contains("AcademicSubscription"));
		System.out.println("AcademicSubscription");

		driver.quit();

	}

}