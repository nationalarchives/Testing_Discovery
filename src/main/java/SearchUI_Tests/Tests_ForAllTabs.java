package SearchUI_Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Tests_ForAllTabs extends Wrapper_methods {
    @Test(priority = 1)
    public void Tests_ForAllTabs() throws IOException, InterruptedException{
        SearchUIURL();

        // enter random wo95 in search
        driver.findElementByXPath("//*[@id=\"search-for\"]").sendKeys("wo 95");

        // enter Year in FROM field
        driver.findElementByXPath("//*[@id=\"start-date\"]").sendKeys("1900");
        // enter MM Year in To field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("1920");

        // select TNA from Held by
        Select sortedBy = new Select(driver.findElementByXPath("//*[@id=\"held-by\"]"));
        sortedBy.selectByIndex(1);

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        ((JavascriptExecutor)driver).executeScript("scroll(0,2000)");

        // check for 9th record
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[9]/a").getText();
        System.out.println(actual);

        Assert.assertTrue((actual.contains("WO 95"))&&(actual.contains("The National Archives")));

        // check the records date
        String RecordDate = driver.findElementByXPath("//*[@id=\"search-results\"]/li[9]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(RecordDate);

        if (RecordDate.length()==4){
            int IntYear = Integer.parseInt(RecordDate);  // If Record displays only YYYY
            Assert.assertTrue((IntYear>=1900)&&(IntYear<=1920));
            System.out.println("The format is YYYY");
        }
        else if ((RecordDate.length()==11)&&(RecordDate.contains("-"))) // If Record displays YYYY - YYYY Format
        {
            int FromYear = Integer.parseInt(RecordDate.substring(0, 4));

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is YYYY - YYYY");
            Assert.assertTrue(FromYear >= 1900 && FromYear <= 1920 || ToYear >= 1900 && ToYear <= 1920 || 1900 >= FromYear && 1900 <= ToYear);
        }
        else if ((RecordDate.length()>=11)&&(RecordDate.length()<=20))// If the Record displays DD MM YYYY
        {

            int Year = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is Date Month Year format");
            Assert.assertTrue((Year>=1900)&&(Year<=1920));
        }
        else if ((RecordDate.length()>=22)&&(RecordDate.contains("-")))// If the Record displays DD MM YYYY -  DD MM YYYY format
        {
            String FromYearBeforeHyphen = RecordDate.split("\\-")[0];
            String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
            String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
            int FromYear = Integer.parseInt(StrFromYear);

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is DD MM YYYY - DD MM YYYY");

            Assert.assertTrue((FromYear>=1900&&FromYear<=1920)||(ToYear>=1900&&ToYear<=1920)||(1900 >= FromYear && 1900 <= ToYear));

        }
        else  // if the format is in Year and month
            {
            int Year =  Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is in MONTH YEAR");
            Assert.assertTrue((Year>=1900)&&(Year<=1920));
        }
         driver.quit();
    }
    @Test(priority = 2)
    public void Tests_ForAllTabs_2() throws IOException, InterruptedException{
        SearchUIURL();

        // enter random wo95 in search
        driver.findElementByXPath("//*[@id=\"search-for\"]").sendKeys("royal");

        // enter Year in FROM field
        driver.findElementByXPath("//*[@id=\"start-date\"]").sendKeys("1850");
        // enter MM Year in To field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("1870");

        // select TNA from Held by
        Select sortedBy = new Select(driver.findElementByXPath("//*[@id=\"held-by\"]"));
        sortedBy.selectByIndex(2);

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        ((JavascriptExecutor)driver).executeScript("scroll(0,2000)");

        // check for 9th record
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[9]/a").getText();
        System.out.println(actual);

        Assert.assertTrue((actual.contains("Royal")));

        // check the records date
        String RecordDate = driver.findElementByXPath("//*[@id=\"search-results\"]/li[9]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(RecordDate);

        if (RecordDate.length()==4){
            int IntYear = Integer.parseInt(RecordDate);  // If Record displays only YYYY
            Assert.assertTrue((IntYear>=1850)&&(IntYear<=1870));
            System.out.println("The format is YYYY");
        }
        else if ((RecordDate.length()==11)&&(RecordDate.contains("-"))) // If Record displays YYYY - YYYY Format
        {
            int FromYear = Integer.parseInt(RecordDate.substring(0, 4));

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is YYYY - YYYY");
            Assert.assertTrue(FromYear >= 1850 && FromYear <= 1870 || ToYear >= 1850 && ToYear <= 1870 || 1850 >= FromYear && 1850 <= ToYear);
        }
        else if ((RecordDate.length()>=11)&&(RecordDate.length()<=20))// If the Record displays DD MM YYYY
        {

            int Year = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is Date Month Year format");
            Assert.assertTrue((Year>=1850)&&(Year<=1870));
        }
        else if ((RecordDate.length()>=22)&&(RecordDate.contains("-")))// If the Record displays DD MM YYYY -  DD MM YYYY format
        {
            String FromYearBeforeHyphen = RecordDate.split("\\-")[0];
            String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
            String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
            int FromYear = Integer.parseInt(StrFromYear);

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is DD MM YYYY - DD MM YYYY");

            Assert.assertTrue((FromYear>=1850&&FromYear<=1870)||(ToYear>=1850&&ToYear<=1870)||(1850 >= FromYear && 1870 <= ToYear));

        }
        else  // if the format is in Year and month
        {
            int Year =  Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is in MONTH YEAR");
            Assert.assertTrue((Year>=1850)&&(Year<=1870));
        }
        driver.quit();
    }
}
