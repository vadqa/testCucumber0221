
Feature: LoginSuccessErrorFeature
  This feature deals with a login success and login error

  Scenario: Valid login/valid password
    Given I navigate to the login test page
    And I type Correct Username in Username field
    And I type Correct Password in Password field
    And I click the Login button
    Then I should see that User logged in with message ‘You logged into a secure area!’

  Scenario: Valid login/invalid password
    Given I navigate to the login test page
    And I type Correct Username in Username field
    And I type Incorrect Password in Password field
    And I click the Login button
    Then I should see that User IS NOT logged in with a message ‘Provide valid combination of username and password‘

  Scenario: Invalid login/valid password
    Given I navigate to the login test page
    And I type Incorrect Username in Username field
    And I type Incorrect Password in Password field
    And I click the Login button
    Then I should see that User IS NOT logged in with a message ‘Provide valid combination of username and password‘