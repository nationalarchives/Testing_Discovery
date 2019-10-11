package SearchUI_Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Records_InBetween_FromAndTo extends Wrapper_methods {
    @Test(priority = 1)
    public void Records_InBetween_FromAndTo_YYYYAndMMYYYY() throws IOException, InterruptedException{
        SearchUIURL();
        // enter Year in FROM field
        driver.findElementByXPath("//*[@id=\"start-date\"]").sendKeys("1850");
        // enter MM Year in To field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("09/1860");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");
        // check filter
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(chkfilter);
       Assert.assertTrue(chkfilter.contains("1850 - 09/1860"));

        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

        String RecordDate = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(RecordDate);

        if (RecordDate.length()==4){
            int IntYear = Integer.parseInt(RecordDate);  // If Record displays only YYYY
            Assert.assertTrue((IntYear>=1850)&&(IntYear<=1860));
            System.out.println("The format is YYYY");
        }
        else if ((RecordDate.length()==11)&&(RecordDate.contains("-"))) // If Record displays YYYY - YYYY Format
        {
            int FromYear = Integer.parseInt(RecordDate.substring(0, 4));

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is YYYY - YYYY");
            Assert.assertTrue(FromYear >= 1850 && FromYear <= 1860 || ToYear >= 1850 && ToYear <= 1860 || 1850 >= FromYear && 1850 <= ToYear);
        }
        else if ((RecordDate.length()>=11)&&(RecordDate.length()<=20)){

            int Year = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is Date Month Year format");
            Assert.assertTrue((Year>=1850)&&(Year<=1860));
        }
        else if ((RecordDate.length()>=22)&&(RecordDate.contains("-"))){
            String FromYearBeforeHyphen = RecordDate.split("\\-")[0];
            String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
            String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
            int FromYear = Integer.parseInt(StrFromYear);

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is DD MM YYYY - DD MM YYYY");

            Assert.assertTrue(((FromYear>=1850)&&(FromYear<=1860))||((ToYear>=1850)&&(ToYear<=1860))||(1850 >= FromYear && 1850 <= ToYear));

        }

        driver.quit();
    }
    @Test (priority = 2)
    public void Records_InBetween_FromAndTo_YYYYAndYYYY_WithAnotherField() throws IOException, InterruptedException{
        SearchUIURL();
        // enter Year in FROM field
        driver.findElementByXPath("//*[@id=\"start-date\"]").sendKeys("1910");
        // enter MM Year in To field
        driver.findElementByXPath("//*[@id=\"end-date\"]").sendKeys("1920");

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");
        // check filter
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(chkfilter);
        Assert.assertTrue(chkfilter.contains("1910 - 1920"));

        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

        String RecordDate = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td/span").getText();
        System.out.println(RecordDate);

        if (RecordDate.length()==4){
            int IntYear = Integer.parseInt(RecordDate);  // If Record displays only YYYY
            Assert.assertTrue((IntYear>=1910)&&(IntYear<=1920));
            System.out.println("The format is YYYY");
        }
        else if ((RecordDate.length()==11)&&(RecordDate.contains("-"))) // If Record displays YYYY - YYYY Format
        {
            int FromYear = Integer.parseInt(RecordDate.substring(0, 4));

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is YYYY - YYYY");
            Assert.assertTrue(((FromYear>=1910)&&(FromYear<=1920))||((ToYear>=1910)&&(ToYear<=1920))||(1910 >= FromYear && 1920 <= ToYear));
        }
        else if ((RecordDate.length()>=11)&&(RecordDate.length()<=20)){

            int Year = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is Date Month Year format");
            Assert.assertTrue((Year>=1910)&&(Year<=1920));
        }
        else if ((RecordDate.length()>=22)&&(RecordDate.contains("-"))){
            String FromYearBeforeHyphen = RecordDate.split("\\-")[0];
            String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
            String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
            int FromYear = Integer.parseInt(StrFromYear);

            int ToYear = Integer.parseInt(RecordDate.substring(RecordDate.length()-4));
            System.out.println("The format is DD MM YYYY - DD MM YYYY");

            Assert.assertTrue(((FromYear>=1910)&&(FromYear<=1920))||((ToYear>=1910)&&(ToYear<=1920))||(1910 >= FromYear && 1920 <= ToYear));

        }

        driver.quit();
    }

}
