
Feature: ModalWindowFeature
  This feature deals with a modal window

  Scenario: Move a cursor to the ‘Close tab’ button
    Given I navigate to the test page with modal window
    And I move a cursor to the Close tab button
    Then I should see that a modal windows appears
