package com.antares.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*
This class is for storing utility methods that can be used across project
 */
    public static void sleep(int seconds){

        seconds *= 1000;

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchWindowAndVerify(String expectedInURL, String expectedTitle){

        //TC #2: Create utility method

        //3. When method is called, it should switch window and verify title.
        //Method info:
        //• Name: switchWindowAndVerify
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedInUrl
        //• Arg3: String expectedTitle
        for (String eachHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(eachHandle);
            System.out.println("current URL = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.


    }

    public static void verifyTitle(String expectedTitle){

        //TC #3: Create utility method
        //1. Create a new method for title verification
        //2. Create a method to make title verification logic re-usable
        //3. When method is called, it should simply verify expected title with actual

        Assert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));
    }

    public static void verifyTitleContains(String expectedInTitle){

        //TC #3: Create utility method
        //1. Create a new method for title verification
        //2. Create a method to make title verification logic re-usable
        //3. When method is called, it should simply verify expected title with actual

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static void verifyUrlEndsWith(String urlEndsWith){
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.endsWith(urlEndsWith));

    }

    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForVisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(target));
    }


    public static List<String> dropdownOptions_as_string(WebElement dropdownElement) {

        Select select = new Select(dropdownElement);
        //storing all options into a list of web-elements

        List<WebElement> monthsAsWebElement = select.getOptions();
        //creating an empty list of string to store all options as a string

        List<String> actualMonthsString = new ArrayList<>();

        //looping through the List<WebElement>, getting all options' text, and storing them into a List<String>
        for (WebElement eachMonth : monthsAsWebElement) {
            actualMonthsString.add(eachMonth.getText());
        }

        return actualMonthsString;
    }


}
