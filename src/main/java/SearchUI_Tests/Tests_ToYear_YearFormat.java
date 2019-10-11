package SearchUI_Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Tests_ToYear_YearFormat extends Wrapper_methods {
    @Test(priority = 1)
    public void Tests_ToYear_InValid() throws IOException,InterruptedException{
        SearchUIURL();
        // enter letters in years field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("abcd");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        Thread.sleep(3000);
        // check for the error message
        String errormsg = driver.findElementByXPath("//*[@id=\"discovery-home-page-search\"]/div/div[1]/div/ul/li").getText();
        Assert.assertEquals("You have entered an invalid date format for the start date. Please use the format DD/MM/YYYY or MM/YYYY or YYYY.",errormsg);
        driver.quit();
    }
    @Test(priority = 2)
    public void Tests_ToYears_Valid() throws IOException,InterruptedException{
        SearchUIURL();
        // enter year in 'between' field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("1900");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        // check for the filter '1900'
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(chkfilter);
        Assert.assertTrue(chkfilter.contains("1900"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");

        String RecordYear = driver.findElementByXPath("//*[@id=\"search-results\"]/li[5]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(RecordYear);

        if (RecordYear.length()<=12) {
            int FromYear = Integer.parseInt(RecordYear.substring(0, 4));
            System.out.println(FromYear);

            int ToYear = Integer.parseInt(RecordYear.substring(7));
            System.out.println(ToYear);

            Assert.assertTrue((1900>= FromYear)&&(1900<=ToYear));
        }else {
            String FromYearBeforeHyphen = RecordYear.split("\\-")[0];
            String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
            String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
            int FromYear = Integer.parseInt(StrFromYear);


            String ToYearAfterHyphen = RecordYear.substring(RecordYear.indexOf("-")+1);
            String stringdatewithoutspaces2 = ToYearAfterHyphen.replaceAll(" ","");
            String StrToYear = stringdatewithoutspaces2.substring(stringdatewithoutspaces2.length() -4);
            int ToYear = Integer.parseInt(StrToYear);

            Assert.assertTrue((1900>= FromYear)&&(1900<=ToYear));
        }
        driver.quit();

    }
}
