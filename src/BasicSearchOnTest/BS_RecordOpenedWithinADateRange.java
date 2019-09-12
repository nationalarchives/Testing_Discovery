package BasicSearchOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.util.Locale.ENGLISH;
import static org.apache.commons.lang3.BooleanUtils.and;

public class BS_RecordOpenedWithinADateRange extends Wrapper_methods {
    @Test(priority = 1)
    public void BS_RecordOpenedWithinADateRange() throws IOException,InterruptedException{
        launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

        Thread.sleep(1000);
        // Enter the word in search

        driver.findElementById("search-all-collections").sendKeys("*");

        Thread.sleep(1000);

        driver.findElementByXPath("(//input[@type='submit'])[1]").click();
        Thread.sleep(1000);

        clickbyXpath("//*[@id=\"heldby\"]/div/ul/li[1]/a");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1700)");
        Thread.sleep(3000);
        // click on record opening date
        clickbyLinkText("Record opening date");

        Thread.sleep(3000);
        // click on Within a date range
        clickbyXpath("//*[@id=\"recordOpeningDateRange\"]/label[1]");

        //enter a date 01/04/2018 to 20/08/2019
        enterByTextXpath("//*[@id=\"rodfromdate\"]","01/04/2018");
        enterByTextXpath("//*[@id=\"rodtodate\"]","20/08/2019");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the first result
        clickbyXpath("//*[@id=\"search-results\"]/li[1]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate expectedDate1 = LocalDate.parse("01 April 2018", formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate expectedDate2 = LocalDate.parse("20 August 2019", formatter2);
        if ( (actualdate.isAfter(expectedDate1)) && (actualdate.isBefore(expectedDate2)))
        {
            System.out.println("It is within the range");

        } else {
            System.out.println("It is not within the range");
        }



    }
    @Test(priority =2)
    public void BS_RecordOpenedWithinADateRange_checkingWithAnotherField() throws IOException,InterruptedException {
        launchDriver("http://test.discovery.nationalarchives.gov.uk/", "chrome");

        Thread.sleep(1000);
        // Enter the word in search

        driver.findElementById("search-all-collections").sendKeys("*");

        Thread.sleep(1000);

        driver.findElementByXPath("(//input[@type='submit'])[1]").click();
        Thread.sleep(1000);

        clickbyXpath("//*[@id=\"heldby\"]/div/ul/li[1]/a");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1700)");
        Thread.sleep(3000);
        // click on record opening date
        clickbyLinkText("Record opening date");

        Thread.sleep(3000);
        // click on Within a date range
        clickbyXpath("//*[@id=\"recordOpeningDateRange\"]/label[1]");

        //enter a date 01/04/2018 to 20/08/2019
        enterByTextXpath("//*[@id=\"rodfromdate\"]", "01/04/2018");
        enterByTextXpath("//*[@id=\"rodtodate\"]", "20/08/2019");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the fifth result
        clickbyXpath("//*[@id=\"search-results\"]/li[5]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MMMM yyyy", ENGLISH);
        LocalDate expectedDate1 = LocalDate.parse("01 April 2018", formatter1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMMM yyyy", ENGLISH);
        LocalDate expectedDate2 = LocalDate.parse("20 August 2019", formatter2);
        if ((actualdate.isAfter(expectedDate1)) && (actualdate.isBefore(expectedDate2))) {
            System.out.println("It is within the range");

        } else {
            System.out.println("It is not within the range");
        }

    }
    }
