package dicovery.DeliveryOption;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DigitizedPartiallyOpened {
	

	
	@Test
	
	
	
	public void digitizedPartiallyOpened() throws Exception{
		
		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(7)
				.getStringCellValue();
		String iaid = sheet.getRow(1).getCell(7).getStringCellValue();
		String expectedStaffDo = sheet.getRow(2).getCell(7)
				.getStringCellValue();
				String expectedOffisteDo = sheet.getRow(4).getCell(7)
				.getStringCellValue();
		
			
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			
		    driver.get(iaid);
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
driver.findElementByXPath("(//a[@class='discoveryPrimaryCallToActionLink'])[3]").click();

System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getAttribute("innerHTML"));

String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

System.out.println(deliveryOptionStaff);

Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);

String staffCheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getAttribute("innerHTML");

Assert.assertTrue(staffCheck.contains("StaffIn"));
Assert.assertTrue(staffCheck.contains("DigitizedPartiallyOpened"));

System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getAttribute("innerHTML"));

String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText();

System.out.println(deliveryOptionOffsite);

//Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);
String offsiteCheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getAttribute("innerHTML");

Assert.assertTrue(offsiteCheck.contains("OffSite"));
Assert.assertTrue(offsiteCheck.contains("DigitizedPartiallyOpened"));

driver.quit();

}
	

	
}
