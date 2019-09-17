package FindAnAichiveOnTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class FA_ArchiveUsingKeyword extends Wrapper_methods {
    @Test(priority = 1)
    public void FA_ArchiveUsingKeyword() throws IOException, InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        driver.findElementByXPath("//*[@id=\"archive-search\"]").sendKeys("Greece");
        clickbyXpath("//*[@id=\"submit\"]");
        String CheckGreece = getTextByXpath("//*[@id=\"countries\"]/div/ul/li");
        System.out.println(CheckGreece);
        Assert.assertTrue(CheckGreece.contains("Greece"));
    }
    @Test(priority = 2)
    public void FA_ArchiveUsingAnotherKeyword() throws IOException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        driver.findElementByXPath("//*[@id=\"archive-search\"]").sendKeys("Rome");
        clickbyXpath("//*[@id=\"submit\"]");
        String CheckRome = getTextByXpath("//*[@id=\"countries\"]/div/ul/li");
        System.out.println(CheckRome);
        Assert.assertTrue(CheckRome.contains("Italy"));

    }
    @Test(priority = 3)
    public void FA_ArchiveUsingOneMoreKeyword() throws IOException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        driver.findElementByXPath("//*[@id=\"archive-search\"]").sendKeys("Canada");
        clickbyXpath("//*[@id=\"submit\"]");
        String CheckCanada = getTextByXpath("//*[@id=\"countries\"]/div/ul/li");
        System.out.println(CheckCanada);
        Assert.assertTrue(CheckCanada.contains("Canada"));

    }


}
