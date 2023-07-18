package com.azulCRM.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to limit access to this object
    private Driver(){}

    /*
    We creat the WebDriver "private" to close access from outside class
    We make it "static" to instantiate it first, and we will use it in a static method
     */

    /*
    Create a reusable utility method that returns same driver instance once we call it
    - if an instance doesn't exist (driver == null), it will create an instance first,
    then will always return it when called
     */
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if (driverPool.get() == null){

            // We will read our browserType from configuration.properties file.
            // This way, we can control which browserType to be opened from outside our code

            String browserType = ConfigurationReader.getProperty("browser");

            // Depending on browserType returned from the configuration.properties,
            // switch statement will open the matching browser.
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    //WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                    break;
            }

        }

        return driverPool.get();

    }

    // Create a new Driver.closeDriver(); method which uses quit() method to quit browsers then set the driver value back to null.

    public static void closeDriver(){

        if (driverPool.get() != null){
            //Terminate the current driver permanently
            driverPool.get().quit();
            // re-assign the driver value back to null so that my "singleton" can create a newer one if needed
            driverPool.remove();
        }
    }



}
