package com.rsscomponents.pages;

import com.rsscomponents.config.BasePage;
import com.rsscomponents.config.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by sivakumar on 27/01/2018.
 */

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        getPropertiesFile();
        getTestDataFile();

    }

    public RegisterPage() {
        new RegisterPage(driver);
    }

    public int generateRandomNumber(){

        int max = 100;
        int min = 1;
        Random randomNum = new Random();
        int generatedRandomNumber = min + randomNum.nextInt(max);
        return generatedRandomNumber;
    }

    public HomePage enterRegistertationDetails(){
        if(driver!=null){
            this.driver = driver;
                String registrationPageUrl = driver.getCurrentUrl();
                Assert.assertEquals(registrationPageUrl, objectProperties.getProperty("RegistrationPageUrl"));
            }
            int randomGenNumber = generateRandomNumber();
            findElement(By.id(objectProperties.getProperty("UserNameTxtFieldId"))).sendKeys(testDataProperties.getProperty("UsernameTestData")+randomGenNumber);
            findElement(By.id(objectProperties.getProperty("PasswordTxtFieldId"))).sendKeys(testDataProperties.getProperty("PasswordTestData"));
            findElement(By.id(objectProperties.getProperty("confirmPasswordTxtFieldId"))).sendKeys(testDataProperties.getProperty("ConfirmPasswordTestData"));
            Select titleSelect = new Select(findElement(By.id(objectProperties.getProperty("TitleDropdownId"))));
            titleSelect.selectByVisibleText("Mr.");
            findElement(By.id(objectProperties.getProperty("FirstNameTxtFieldId"))).sendKeys(testDataProperties.getProperty("FirstNameTestData"));
            findElement(By.id(objectProperties.getProperty("SurNameTxtFieldId"))).sendKeys(testDataProperties.getProperty("SurNameTestData"));
            findElement(By.id(objectProperties.getProperty("TelephoneTxtFieldId"))).sendKeys(testDataProperties.getProperty("PhoneNumberTestData"));
            findElement(By.id(objectProperties.getProperty("EmailTxtFieldId"))).sendKeys(testDataProperties.getProperty("UsernameTestData")+randomGenNumber+"@mail.com");
            Select designationSelect = new Select(findElement(By.id(objectProperties.getProperty("OrgDesignationDropDownId"))));
            designationSelect.selectByVisibleText("Other");
            findElement(By.id(objectProperties.getProperty("RegisterBtnId"))).click();
        return new HomePage(driver);
 }

}
