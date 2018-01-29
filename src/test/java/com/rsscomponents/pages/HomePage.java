package com.rsscomponents.pages;

import com.rsscomponents.config.BasePage;
import com.rsscomponents.config.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sivakumar on 26/01/2018.
 */

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        this.driver = driver;
        getPropertiesFile();
        getTestDataFile();

    }

    public HomePage() {
        new HomePage(driver);
    }

    public void checkHomePageUrl(){

        if(driver!=null){
            this.driver = driver;
            String homePageUrl = driver.getCurrentUrl();
            Assert.assertEquals(homePageUrl, objectProperties.getProperty("HomePageUrl"));
        }
    }

    public SearchTermPage enterSearchTerm(){

        findElement(By.id(objectProperties.getProperty("SearchTextField"))).sendKeys(testDataProperties.getProperty("SearchTermTestData"));
        findElement(By.id(objectProperties.getProperty("SearchIconId"))).click();
        WebDriverWait waitForSearchResults = new WebDriverWait(driver, 10);
        WebElement obtainedResults = waitForSearchResults.until(ExpectedConditions.visibilityOf(findElement(By.id(objectProperties.getProperty("TotalproductsId")))));
        obtainedResults.findElement(By.id(objectProperties.getProperty("TotalproductsId"))).getText();
        Assert.assertEquals(obtainedResults,testDataProperties.getProperty("ExpectedTotalProducts"));
        String searchTermPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(searchTermPageUrl, objectProperties.getProperty("SearchTermPageUrl"));
        return new SearchTermPage(driver);
    }
}
