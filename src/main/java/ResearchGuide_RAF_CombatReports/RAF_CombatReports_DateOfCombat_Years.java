package ResearchGuide_RAF_CombatReports;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RAF_CombatReports_DateOfCombat_Years extends Wrapper_methods {
    @Test(priority = 1)
    public void RAF_CombatReports_DateOfCombat_Years_OutofRange() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-combat-reports-1939-1945/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter from date
        clickbyXpath("//*[@id=\"fromdate\"]");
        driver.findElementByXPath("//*[@id=\"fromdate\"]").sendKeys("1800");

        // enter to date
        clickbyXpath("//*[@id=\"todate\"]");
        driver.findElementByXPath("//*[@id=\"todate\"]").sendKeys("1850");

        //click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        String actual = driver.findElementByXPath("//*[@id=\"records-tab\"]/span").getText();
        Assert.assertTrue(actual.contains("Records 0"));
        driver.quit();
    }
    @Test(priority = 2)
    public void RAF_CombatReports_DateOfCombat_Years_InRange() throws IOException, InterruptedException{
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-combat-reports-1939-1945/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter from date
        clickbyXpath("//*[@id=\"fromdate\"]");
        driver.findElementByXPath("//*[@id=\"fromdate\"]").sendKeys("1940");

        // enter to date
        clickbyXpath("//*[@id=\"todate\"]");
        driver.findElementByXPath("//*[@id=\"todate\"]").sendKeys("1944");

        //click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check the third record year is in the given range
        String RecordYear = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td[2]/span").getText();
        System.out.println(RecordYear);


        String RecordYearwithoutspaces = RecordYear.replaceAll(" ","");
        String StrYear = RecordYearwithoutspaces.substring(RecordYearwithoutspaces.length() -4);
        int Year = Integer.parseInt(StrYear);
        Assert.assertTrue((Year>=1940) && (Year<=1944));
        driver.quit();
    }
}
