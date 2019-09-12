package BasicSearchOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Locale.ENGLISH;

public class BS_RecordOpenedInTheLast6months extends Wrapper_methods {
    @Test(priority = 1)
    public void BS_RecordOpenedInTheLastWeek() throws IOException, InterruptedException, ParseException {

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

        // click on in the last six months
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/ul/li[4]/label");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the first result
        clickbyXpath("//*[@id=\"search-results\"]/li[1]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        LocalDate date2 = LocalDate.now();
        LocalDate Last6months = date2.minusMonths(6);
        System.out.println(Last6months);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);

        if (Last6months.isBefore(actualdate)) {
            System.out.println("It is in the last 6 months");

        } else {
            System.out.println("It is not in the last 6 months");
        }



    }
    @Test (priority = 2)
    public void BS_RecordOpenedInTheLastWeek_TestingwithanotherField() throws IOException, InterruptedException, ParseException {

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

        // click on in the last six months
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/ul/li[4]/label");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        // click on the fifth result
        clickbyXpath("//*[@id=\"search-results\"]/li[5]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        LocalDate date2 = LocalDate.now();
        LocalDate Last6months = date2.minusMonths(6);
        System.out.println(Last6months);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);

        if (Last6months.isBefore(actualdate)) {
            System.out.println("It is in the last 6 months");

        } else {
            System.out.println("It is not in the last 6 months");
        }


    }
}
