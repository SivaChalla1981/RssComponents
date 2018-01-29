package com.rsscomponents.pages;

import com.rsscomponents.config.BasePage;
import com.rsscomponents.config.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by sivakumar on 26/01/2018.
 */
public class LandingPage extends BasePage {


    public LandingPage() {
        driver = getDriver();
        getPropertiesFile();

    }

    public void openLandingPage(){
        navigateToLandingPage();
    }

    /**
     * Landing page mandatory checks
     */
    public void landingPageMandatoryChecks() {
        LandingPage.getPropertiesFile();
        findElement(By.xpath(objectProperties.getProperty("LandinPageLogoXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("SearchBarXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("LoginLinkXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("RegisterLinkXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("AllProdcutsInMenuXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("OurBrandsMenuXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("NewProductsInMenuXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("MyAccountInMenuXpath"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("ServicesInMenuXapth"))).isDisplayed();
        findElement(By.xpath(objectProperties.getProperty("FooterXpath"))).isDisplayed();
    }

    /**
     *
     * @return
     */

   public RegisterPage clickRegisterLink(){
        landingPageMandatoryChecks();
        String landingPageTitle = driver.getCurrentUrl();
        Assert.assertEquals(landingPageTitle, objectProperties.getProperty("LandingPageUrl"));
        clickLink("Register");
       return new RegisterPage(driver);
   }

    /**
     *
     * @return
     */

   public LoginPage clickLoginLink(){

        if(findElement(By.linkText(objectProperties.getProperty("LoginLink"))).isDisplayed()){
            findElement(By.linkText(objectProperties.getProperty("LoginLink"))).click();
        }
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl,objectProperties.getProperty("LoginPageUrl"));
        return new LoginPage(driver);
   }

}

