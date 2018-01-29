@RSS-01
Feature: This feature explains the various scenarios for Rscomponents

    Scenario: As a new user i want to do the registration process, in order to become a registered user
       Given I opened the application in browser
       When the application got loaded
       And I look for the register link to click
       When I click register link, i expect to see the registration page and start filling the details
      Then After successful registration i expect to see the home page

    Scenario: As a not logged user, when i try to checkout it should ask me to create login
      Given I opened the application in browser
      When the application got loaded
      And I searched for the Lamps in the search bar
      When I click the Go to products button, then i expect to see the products in list view
      And I add the first product from the list and I expect to see the view basket option
      When I click the view basket option
      Then I should expect to see the basket summary page
      When I click checkout securely
      Then I should see the login or continue as guest popup alert

    Scenario: As a registered user, i can login with my credentials and search for the product
      Given I opened the application in browser
      When the application got loaded
      And I click the login link, i expect to see the login page
      When I entered valid credentials for username and password, home page should be displayed
      When I searched for Lamps in the search bar
      Then I should expect to see the number of lamps available in the store.


