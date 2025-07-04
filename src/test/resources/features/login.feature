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

  @boundary-login
  Scenario Outline: Login with boundary value username and password
    Given user is on the login page
    When user input "<username>" as username
    And user input "<password>" as password
    And user click login button
    Then user will see error message "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username                      | password       |
      | a                            | secret_sauce   |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaa | secret_sauce   |
      | standard_user                | a              |
      | standard_user                | aaaaaaaaaaaaaa |
