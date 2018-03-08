package dicovery.DeliveryOptionOnDev;

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

public class MouldTreatment {
	

	@Test
	
public void mouldTreatment() throws Exception{
		
		File src = new File("./data/ALLOptionsDev.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(12)
				.getStringCellValue();
		String iaid = sheet.getRow(1).getCell(12).getStringCellValue();
		String expectedStaffDo = sheet.getRow(2).getCell(12)
				.getStringCellValue();
		String expectedOnsitePublicDo = sheet.getRow(3).getCell(12)
				.getStringCellValue();
		String expectedOffisteDo = sheet.getRow(4).getCell(12)
				.getStringCellValue();

		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
	    driver.get(iaid);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("(//a[@class='discoveryPrimaryCallToActionLink'])[2]").click();
		
		Thread.sleep(3000);
	             
			
		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getAttribute("innerHTML"));
		
		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText());
		
		String deliveryOptionStaff = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getText();

		System.out.println(deliveryOptionStaff);

		Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);
		
		String Staffcheck= driver.findElementByXPath("(//div[@class='order-option-wrapper'])[1]").getAttribute("innerHTML");
		
		Assert.assertTrue(Staffcheck.contains("StaffIn"));
		
		Assert.assertTrue(Staffcheck.contains("MouldTreatment"));
		
	    System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getAttribute("innerHTML"));
	    
	    System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText());
	    
	   String deliveryOptionOnsitePublic = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getText();

		System.out.println(deliveryOptionOnsitePublic);

		Assert.assertEquals(expectedOnsitePublicDo, deliveryOptionOnsitePublic);
		
		String onsitepublic= driver.findElementByXPath("(//div[@class='order-option-wrapper'])[2]").getAttribute("innerHTML");
		
		Assert.assertTrue(onsitepublic.contains("OnSitePublic"));
		
		Assert.assertTrue(onsitepublic.contains("MouldTreatment"));
		
		
System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getAttribute("innerHTML"));
System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getText());

String deliveryOptionOffsite = driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getText();

System.out.println(deliveryOptionOffsite);

Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);
		
		String Offsitecheck= driver.findElementByXPath("(//div[@class='order-option-wrapper'])[3]").getAttribute("innerHTML");
		
		Assert.assertTrue(Offsitecheck.contains("OffSite"));
		
		Assert.assertTrue(Offsitecheck.contains("MouldTreatment"));
		
		Thread.sleep(3000);

		driver.quit();
		
				
}
	
	

}
