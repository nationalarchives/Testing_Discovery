package SearchUI_Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class FromYear_ToYear_DifferentFormats extends Wrapper_methods {
    @Test(priority = 1)
    public void FromYear_MMDDFormat_WithHyphen() throws IOException,InterruptedException{
        SearchUIURL();
        // enter Month,Year with - in years field
        driver.findElementByXPath("//*[@id=\"start-date\"]").sendKeys("09-1900");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        Thread.sleep(3000);
        // check for the error message
        String errormsg = driver.findElementByXPath("//*[@id=\"discovery-home-page-search\"]/div/div[1]/div/ul/li").getText();
        Assert.assertEquals("You have entered an invalid date format for the start date. Please use the format DD/MM/YYYY or MM/YYYY or YYYY.",errormsg);
        driver.quit();
    }
    @Test(priority = 2)
    public void ToYear_MMDDFormat_WithHyphen() throws IOException,InterruptedException{
        SearchUIURL();
        // enter MM,Year with hyphen in To field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("09-1920");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        Thread.sleep(3000);
        // check for the error message
        String errormsg = driver.findElementByXPath("//*[@id=\"discovery-home-page-search\"]/div/div[1]/div/ul/li").getText();
        Assert.assertEquals("You have entered an invalid date format for the start date. Please use the format DD/MM/YYYY or MM/YYYY or YYYY.",errormsg);
        driver.quit();
    }
    @Test(priority = 3)
    public void FromYear_MMDDYYYYFormat_WithSlash() throws IOException,InterruptedException{
        SearchUIURL();
        // enter DD MM Year in From field
        driver.findElementByXPath("//*[@id=\"start-date\"]").sendKeys("20/09/1920");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        Thread.sleep(3000);
        // check filter
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        Assert.assertTrue(chkfilter.contains("20/09/1920"));
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

        String YearRecord = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(YearRecord);
       // System.out.println(YearRecord.length());

        if (YearRecord.length()==4){
            int IntYear = Integer.parseInt(YearRecord);  // If Record displays only YYYY
            Assert.assertTrue(IntYear==1920);
        }
        else {
            if (YearRecord.length()==11) // If Record displays YYYY - YYYY Format
            {
                int FromYear = Integer.parseInt(YearRecord.substring(0, 4));

                int ToYear = Integer.parseInt(YearRecord.substring(7));

                Assert.assertTrue((1920>= FromYear)&&(1920<=ToYear));
            }
            else { // if Record displays MM DD YYYY - MM DD YYYY format
                String FromYearBeforeHyphen = YearRecord.split("\\-")[0];
                String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
                String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
                int FromYear = Integer.parseInt(StrFromYear);


                String ToYearAfterHyphen = YearRecord.substring(YearRecord.indexOf("-")+1);
                String stringdatewithoutspaces2 = ToYearAfterHyphen.replaceAll(" ","");
                String StrToYear = stringdatewithoutspaces2.substring(stringdatewithoutspaces2.length() -4);
                int ToYear = Integer.parseInt(StrToYear);
                Assert.assertTrue((1920>= FromYear)&&(1920<=ToYear));
            }
        }

        driver.quit();
        }
    @Test(priority = 4)
    public void ToYear_MMDDYYYYFormat_WithSlash() throws IOException,InterruptedException{
        SearchUIURL();
        // enter DD MM Year in To field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("20/09/1950");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        Thread.sleep(3000);
        // check filter
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        Assert.assertTrue(chkfilter.contains("20/09/1950"));
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

        String YearRecord = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(YearRecord);
        // System.out.println(YearRecord.length());

        if (YearRecord.length()==4){
            int IntYear = Integer.parseInt(YearRecord);  // If Record displays only YYYY
            Assert.assertEquals(IntYear,1950);
        }
        else if (YearRecord.length()==11) // If Record displays YYYY - YYYY Format
            {
                int FromYear = Integer.parseInt(YearRecord.substring(0, 4));

                int ToYear = Integer.parseInt(YearRecord.substring(7));

                Assert.assertTrue((1950>= FromYear)&&(1950<=ToYear));
            }
            else if (YearRecord.length()>=20) { // if Record displays MM DD YYYY - MM DD YYYY format
                String FromYearBeforeHyphen = YearRecord.split("\\-")[0];
                String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
                String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
                int FromYear = Integer.parseInt(StrFromYear);


                String ToYearAfterHyphen = YearRecord.substring(YearRecord.indexOf("-")+1);
                String stringdatewithoutspaces2 = ToYearAfterHyphen.replaceAll(" ","");
                String StrToYear = stringdatewithoutspaces2.substring(stringdatewithoutspaces2.length() -4);
                int ToYear = Integer.parseInt(StrToYear);
                Assert.assertTrue((1950>= FromYear)&&(1950<=ToYear));
            }


       driver.quit();
    }
    }

