
Feature: EnableDisableFeature
  This feature deals with clicking that opens a new browser-tab or new window

  Scenario: Click on the Enable button, wait until the async process is finished,
  then make sure that the input field is enabled

    Given I navigate to the test page with Enable button
    And I find the Enable button and click it
    And I wait until the async process is finished
    And I submit the string to the input field
    And Click on the Disable button, wait for async process
    Then I should see that the input field is disabled and still contains the string
