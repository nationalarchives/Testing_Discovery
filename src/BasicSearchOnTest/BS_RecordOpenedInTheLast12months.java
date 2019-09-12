package BasicSearchOnTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Locale.ENGLISH;

public class BS_RecordOpenedInTheLast12months extends Wrapper_methods {
    @Test(priority = 1)
    public void BS_RecordOpenedInTheLast12months() throws IOException, InterruptedException, ParseException {
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

        // click on in the last 12 months
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/ul/li[5]/label");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the first result
        clickbyXpath("//*[@id=\"search-results\"]/li[1]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        LocalDate date2 = LocalDate.now();
        LocalDate Last12months = date2.minusMonths(12);
        System.out.println(Last12months);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);

        if (Last12months.isBefore(actualdate)) {
            System.out.println("It is in the last 12 months");

        } else {
            System.out.println("It is not in the last 12 months");
        }

    }
    @Test(priority = 2)
    public void BS_RecordOpenedInTheLast12months_TestingwithanotherField() throws IOException, InterruptedException, ParseException {

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

        // click on in the last 12 months
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/ul/li[5]/label");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the fifth result
        clickbyXpath("//*[@id=\"search-results\"]/li[5]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        LocalDate date2 = LocalDate.now();
        LocalDate Last12months = date2.minusMonths(12);
        System.out.println(Last12months);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);

        if (Last12months.isBefore(actualdate)) {
            System.out.println("It is in the last 12 months");

        } else {
            System.out.println("It is not in the last 12 months");
        }

    }

}
