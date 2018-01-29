package com.rsscomponents.config;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by sivakumar on 26/01/2018.
 */

/**
 * This class is used to initialize the driver, by basing on the environment the driver is initialized
 * and used accordingly.
 */
public class Driver {

    public static WebDriver driver;
    //Environment Variable to refer in shell script
    static String environmentType = System.getProperty("environment", "local");
    //Browser variable to refer in shell script
    static String browserType = System.getProperty("browser", "chrome");


    @BeforeClass
    protected static WebDriver getDriver() {
        driver = null;
        if (driver == null) {

            if ("local".equalsIgnoreCase(environmentType)) {
                /**
                 * Firefox Driver capabilities
                 */
                if ("firefox".equalsIgnoreCase(browserType)) {
                    DesiredCapabilities capability = DesiredCapabilities.firefox();
                    try {
                        driver = new FirefoxDriver(capability);
                        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                /**
                 * Chromedriver Capabilites
                 */
                if ("chrome".equalsIgnoreCase(browserType)) {
                    DesiredCapabilities capability = DesiredCapabilities.chrome();
                    try {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//browsers//chromedriver.exe");
                        driver = new ChromeDriver(capability);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                /**
                 * Html UnitDriver
                 */
                if ("htmlunit".equalsIgnoreCase(browserType)) {
                    driver = new HtmlUnitDriver();
                }

            }

        }
        driver.manage().window().maximize();
        return driver;
    }

    @AfterClass
    public void closeBrowserInstance(){
        if(driver!=null)
            driver.close();
    }

}
