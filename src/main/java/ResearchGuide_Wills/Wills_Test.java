package ResearchGuide_Wills;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Wills_Test extends Wrapper_methods {
    @Test
    public void Wills_Test() throws IOException, InterruptedException{
        PopularCollectionsURL();
        // click on wills
        clickbyXpath("//*[@id=\"wills\"]/a");
        ((JavascriptExecutor)driver).executeScript("scroll(0,300)");
        // check the checkbox for Medals and awards checked
        WebElement checkbox = driver.findElementByXPath("//*[@id=\"wills-death-duties\"]");
        System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
        if(checkbox.isSelected()){
            System.out.println("check box is checked");
        }
        else{
            System.out.println("checkbox is not checked");
        }
        // check for guides available displaying or not
        String guidesavailablevariabble = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        System.out.println(guidesavailablevariabble);
        Assert.assertTrue(guidesavailablevariabble.contains("guides available"));
        driver.quit();
    }
}
