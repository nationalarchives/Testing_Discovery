package ResearchGuide_RAF_RecordBooks;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RAF_RecordBooks_Input_Years extends Wrapper_methods {
    @Test
    public void RAF_RecordBooks_Input_Years() throws IOException, InterruptedException{
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-operations-record-books-1939-1945/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter date
        clickbyXpath("//*[@id=\"fromdate\"]");
        driver.findElementByXPath("//*[@id=\"fromdate\"]").sendKeys("1940");

        clickbyXpath("//*[@id=\"todate\"]");
        driver.findElementByXPath("//*[@id=\"todate\"]").sendKeys("1945");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check for the first records date is in the range
        String YearFromRecord = driver.findElementByXPath("//*[@id=\"search-results\"]/li[1]/a/table/tbody/tr[2]/td[2]/span").getText();
       System.out.println(YearFromRecord);

        String FromYearBeforeHyphen = YearFromRecord.split("\\-")[0];
        //System.out.println(FromYearBeforeHyphen);


        String stringdatewithoutspaces = FromYearBeforeHyphen.replaceAll(" ","");
        //System.out.println(stringdatewithoutspaces);

       String StrFromYear = stringdatewithoutspaces.substring(stringdatewithoutspaces.length() -4);
      // System.out.println(StrFromYear);

        int FromYear = Integer.parseInt(StrFromYear);
        System.out.println(FromYear);

        String ToYearAfterHyphen = YearFromRecord.substring(YearFromRecord.indexOf("-")+1);
       // System.out.println(ToYearAfterHyphen);

        String stringdatewithoutspaces2 = ToYearAfterHyphen.replaceAll(" ","");
       // System.out.println(stringdatewithoutspaces2);

        String StrToYear = stringdatewithoutspaces2.substring(stringdatewithoutspaces2.length() -4);
        //System.out.println(StrToYear);

        int ToYear = Integer.parseInt(StrToYear);
        System.out.println(ToYear);

        Assert.assertTrue(((FromYear >= 1940)&&(FromYear<=1945)) || ((ToYear >= 1940)&&(ToYear <=1945)));
       driver.quit();
    }
}
