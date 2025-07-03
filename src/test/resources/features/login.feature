Feature: Login functionality

  @valid-login
  Scenario: Login using valid email and password
    Given user is on the login page
    And user inputs username with "standard_user"
    And user inputs password with "secret_sauce"
    When user clicks the login button
    Then user should be redirected to the homepage

  @invalid-login
  Scenario: Login using invalid email and password
    Given user is on the login page
    And user inputs username with "standard"
    And user inputs password with "wrong"
    When user clicks the login button
    Then user should see an error message "Epic sadface: Username and password do not match any user in this service"
