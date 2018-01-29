package com.rsscomponents.stepdefs;

import com.rsscomponents.pages.HomePage;
import com.rsscomponents.pages.LandingPage;
import com.rsscomponents.pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * Created by sivakumar on 26/01/2018.
 */

public class LoingInStepDefs {

    LandingPage lp = new LandingPage();
    LoginPage lpage = new LoginPage();
    HomePage hp = new HomePage();

    @When("^I click the login link, i expect to see the login page$")
    public void i_click_the_login_link_i_expect_to_see_the_login_page() throws Throwable {
       lp.clickLoginLink();
    }

    @When("^I entered valid credentials for username and password, home page should be displayed$")
    public void i_entered_valid_credentials_for_username_and_password() throws Throwable {
        lpage.enterLoginDetails();
    }

    @When("^I searched for Lamps in the search bar$")
    public void i_searched_for_Lamps_in_the_search_bar() throws Throwable {
        hp.enterSearchTerm();
    }

    @Then("^I should expect to see the number of lamps available in the store\\.$")
    public void i_should_expect_to_see_the_number_of_lamps_available_in_the_store() throws Throwable {

    }
}
