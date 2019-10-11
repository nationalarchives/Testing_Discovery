package ResearchGuide_MilitaryHonours_Awards;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class MilitaryHonours_Awards_Years extends Wrapper_methods {
    @Test(priority = 1)
    public void MilitaryHonours_Awards_Years_OutofRange() throws IOException, InterruptedException{
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/recommendations-military-honours-awards-1935-1990/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter from year
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1800");

        // enter to year
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1850");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check for 0 records
        String actual = driver.findElementByXPath("//*[@id=\"records-tab\"]").getText();
        Assert.assertTrue(actual.contains("Records 0"));
        driver.quit();
    }
    @Test(priority = 2)
    public void MilitaryHonours_Awards_Years_InRange() throws IOException, InterruptedException{
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/recommendations-military-honours-awards-1935-1990/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter from year
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1950");

        // enter to year
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1970");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check third record year is in the range
        String RecordYear = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(RecordYear);

        if (RecordYear.length()<=12) {
            int FromYear = Integer.parseInt(RecordYear.substring(0, 4));
            System.out.println(FromYear);

            int ToYear = Integer.parseInt(RecordYear.substring(7));
            System.out.println(ToYear);

            Assert.assertTrue((FromYear>= 1950)||(ToYear<=1970));
        }else {

            String FromYearBeforeHyphen = RecordYear.split("\\-")[0];
            String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
            String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
            int FromYear = Integer.parseInt(StrFromYear);

            String ToYearAfterHyphen = RecordYear.substring(RecordYear.indexOf("-")+1);
            String stringdatewithoutspaces2 = ToYearAfterHyphen.replaceAll(" ","");
            String StrToYear = stringdatewithoutspaces2.substring(stringdatewithoutspaces2.length() -4);
            int ToYear = Integer.parseInt(StrToYear);

            Assert.assertTrue((FromYear>= 1950)||(ToYear<=1970));
        }
        driver.quit();
    }
}
