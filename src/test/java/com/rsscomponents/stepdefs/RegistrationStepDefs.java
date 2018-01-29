package com.rsscomponents.stepdefs;

import com.rsscomponents.config.BasePage;
import com.rsscomponents.config.Driver;
import com.rsscomponents.pages.HomePage;
import com.rsscomponents.pages.LandingPage;
import com.rsscomponents.pages.RegisterPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by sivakumar on 26/01/2018.
 */

public class RegistrationStepDefs {

    LandingPage lp = new LandingPage();
    RegisterPage rp = new RegisterPage();
    HomePage hp = new HomePage();
    BasePage bp = new BasePage();

    @Given("^I opened the application in browser$")
    public void i_opend_the_appliation_in_browser() throws Throwable {
         lp.openLandingPage();
    }

    @When("^the application got loaded$")
    public void the_application_got_loaded() throws Throwable {
        lp.landingPageMandatoryChecks();
    }

    @When("^I look for the register link to click$")
    public void i_look_for_the_register_link_to_click() throws Throwable {
        lp.clickRegisterLink();
    }

    @When("^I click register link, i expect to see the registration page and start filling the details$")
    public void i_click_register_link_i_expect_to_see_the_registration_page_and_start_filling_the_details() throws Throwable {
        rp.enterRegistertationDetails();
    }

    @Then("^After successful registration i expect to see the home page$")
    public void after_successful_registration_i_expect_to_see_the_home_page() throws Throwable {
        hp.checkHomePageUrl();
        bp.closeBrowserInstance();
    }

}
