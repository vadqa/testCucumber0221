
Feature: ClickButtonOpensNewWindowFeature
  This feature deals with clicking that opens a new browser-tab or new window

  Scenario: Click on the Click Here button
    Given I navigate to the test page with Click Here button
    And I find the Click Here button
    And I click on the Click Here button
    Then I should see that the new window opens
