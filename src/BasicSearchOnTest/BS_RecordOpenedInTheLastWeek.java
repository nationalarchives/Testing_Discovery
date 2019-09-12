package BasicSearchOnTest;

import com.gargoylesoftware.htmlunit.javascript.host.intl.DateTimeFormat;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.util.Locale.ENGLISH;

public class BS_RecordOpenedInTheLastWeek extends Wrapper_methods {
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

        // click on in the last week
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/ul/li[3]/label");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        // click on the first result
        clickbyXpath("//*[@id=\"search-results\"]/li[1]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        LocalDate date1 = LocalDate.now();
        LocalDate Lastweek = date1.minusDays(7);
        System.out.println(Lastweek);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate actualdate = LocalDate.parse(actual, formatter);

        if (Lastweek.isBefore(actualdate)) {
            System.out.println("It is within Last week");

        } else {
            System.out.println("It is not in the Last week");
        }

    }

    @Test(priority = 2)

    public void BS_RecordOpenedInTheLastWeek_withAnotherfield() throws IOException, InterruptedException, ParseException {

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

        // click on in the last week
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/ul/li[3]/label");
        // click on refine
        clickbyXpath("//*[@id=\"records-opening-date\"]/form/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        // click on the fifth result
        clickbyXpath("//*[@id=\"search-results\"]/li[5]/a");
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/div/div[2]/table/tbody/tr[9]/td").getText();
        System.out.println(actual);
        LocalDate date1 = LocalDate.now();
        LocalDate Lastweek = date1.minusDays(7);

        System.out.println(Lastweek);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",ENGLISH);
        LocalDate actualdate = LocalDate.parse(actual, formatter);

        if (Lastweek.isBefore(actualdate)) {
            System.out.println("It is within Last week");

        } else {
            System.out.println("It isn't in the last week");
        }

    }
}

