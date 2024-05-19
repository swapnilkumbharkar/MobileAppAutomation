@app
Feature: Login functionality verification scenarios
  This feature contains scenarios for login functionality

  Scenario: User verify the login with correct credentials
    When User tap on Main Menu
    And User select Login option
    And User enter "bob@example.com" as user name
    And User enter "10203040" as password
    And User tap on Login button
    Then User verify successful login landed on "Products" page

  Scenario: User verify the locked out login credentials error
    When User tap on Main Menu
    And User select Login option
    And User enter "alice@example.com" as user name
    And User enter "10203040" as password
    And User tap on Login button
    Then User verify the error message displayed for "LOCKED"

  Scenario: User verify the incorrect login credentials error
    When User tap on Main Menu
    And User select Login option
    And User enter "1@2.com" as user name
    And User enter "f-o-o" as password
    And User tap on Login button
    Then User verify the error message displayed for "NO MATCH"

  Scenario: User verify the user details required error
    When User tap on Main Menu
    And User select Login option
    And User enter "" as user name
    And User enter "" as password
    And User tap on Login button
    Then User verify the error message displayed for "NO USER DETAILS"

  Scenario: User verify the password required error
    When User tap on Main Menu
    And User select Login option
    And User enter "bob@example.com" as user name
    And User enter "" as password
    And User tap on Login button
    Then User verify the error message displayed for "NO PASSWORD"