package BasicSearchOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Locale.ENGLISH;

public class BS_RecordOpenedOnASpecificDate extends Wrapper_methods {
    @Test
    public void BS_RecordOpenedOnASpecificDate() throws IOException,InterruptedException{

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
        // click on On a specific date
        clickbyXpath("//*[@id=\"recordOpeningDate\"]/label");
        // enter a date
        enterByTextXpath("//*[@id=\"rodDate\"]","21/08/2019");

        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the first result
        clickbyXpath("//*[@id=\"search-results\"]/li[1]/a");

        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");

        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate expectedDate = LocalDate.parse("23 August 2019", formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter1);
        if (actualdate.isEqual(expectedDate))
        {
            System.out.println("It is the same date");

        } else {
            System.out.println("It is not the same date");
        }




    }
}
