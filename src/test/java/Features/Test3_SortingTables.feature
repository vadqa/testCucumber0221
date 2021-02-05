
Feature: SortingTableFeature
  This feature deals with a sorting function for tables

  Scenario: Sort the Table 1 by the Last Name column ascending
    Given I navigate to the test page with tables
    And I find the column Last Name
    And I click on the column Last Name
    Then I should see that the TableOne is sorted by the Last Name column
