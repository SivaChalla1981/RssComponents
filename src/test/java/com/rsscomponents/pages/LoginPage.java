package com.rsscomponents.pages;

import com.rsscomponents.config.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by sivakumar on 26/01/2018.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        getPropertiesFile();
        getTestDataFile();
    }

    public LoginPage() {
        new LoginPage(driver);
    }

    public HomePage enterLoginDetails(){

            findElement(By.id(objectProperties.getProperty("UserNameTextField"))).sendKeys(testDataProperties.getProperty("LoginUserNameTestData"));
            findElement(By.id(objectProperties.getProperty("PasswordTextField"))).sendKeys(testDataProperties.getProperty("PasswordTestData"));
            findElement(By.id(objectProperties.getProperty("LoginBtn"))).click();
            String homePageUrl = driver.getCurrentUrl();
            Assert.assertEquals(homePageUrl,objectProperties.getProperty("HomePageUrl"));
        return new HomePage(driver);
    }

}
