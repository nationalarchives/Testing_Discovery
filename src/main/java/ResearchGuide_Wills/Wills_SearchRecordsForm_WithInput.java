package ResearchGuide_Wills;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import static java.util.Locale.ENGLISH;
import static org.apache.commons.lang3.time.DateUtils.parseDate;

public class Wills_SearchRecordsForm_WithInput extends Wrapper_methods {
    @Test
    public void Wills_SearchRecordsForm_FirstnameYear() throws IOException, InterruptedException{
        PopularCollectionsURL();
        // click on Wills link in Popular collections
        clickbyXpath("//*[@id=\"wills\"]/a");
        Thread.sleep(2000);
        // click on the third record
        clickbyXpath("//*[@id=\"reload-marker\"]/div[2]/div/ul/li[3]/a/div");

        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

        // enter first name
        clickbyXpath("//*[@id=\"FirstName\"]");
        driver.findElementByXPath("//*[@id=\"FirstName\"]").sendKeys("smith");

        // enter date range
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1800");
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1820");

        // click on search
        clickbyXpath("//*[@id=\"page_wrap\"]/div[2]/div[1]/div[2]/div/form/div/input");

       // check the filter is selected or not
        String Filter_CheckYears = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(Filter_CheckYears);
        Assert.assertEquals("1800 - 1820",Filter_CheckYears);

        ((JavascriptExecutor)driver).executeScript("scroll(0,700)");

        // checking the third record, if it contains 'Will'
        String KeywordWillAndSmithYear = driver.findElementByXPath("//*[@id=\"search-results\"]/li[2]/a").getText();
        //System.out.println(KeywordWillAndSmithYear);
        Assert.assertTrue(KeywordWillAndSmithYear.contains("Will")&& KeywordWillAndSmithYear.contains("Smith"));

        //click on the third record
        clickbyXpath("//*[@id=\"search-results\"]/li[3]/a");

        // checking the record year is in the year range
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[3]/td").getText();
        //System.out.println(actual);

        String string = actual;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", ENGLISH);
        LocalDate date = LocalDate.parse(string, formatter);
        //System.out.println(date);

        int year = date.getYear();
        System.out.println(year);

        Assert.assertTrue((year >= 1800) && (1820 >= year));
       //driver.quit();
    }

}
